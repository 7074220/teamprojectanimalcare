package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dao.OrderItemDao;
import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Wish;
import com.itwill.service.CartService;
import com.itwill.service.OrderItemService;
import com.itwill.service.OrderService;
import com.itwill.service.UserInfoService;
import com.itwill.service.WishService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private WishService wishService;
	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping("/login")
	public String login(Model model) throws Exception {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) throws Exception {
		return "register";
	}
	
	// 관리자가 유저리스트 볼때
	@GetMapping(value = "/userList")
	public String list(Model model) throws Exception {
		List<Userinfo> userList = userInfoService.findUserList();
		model.addAttribute("userList", userList);
		return "userList";
	}
	
	//마이페이지 이동
	@GetMapping(value="/userinfo")
	public String view(Model model, HttpSession session) throws Exception{
		Long userNo = (Long)session.getAttribute("userNo");
		if(userNo==null) {
			throw new Exception("로그인을 해주세요");
		}
		Userinfo userinfo = userInfoService.findUserByNo(userNo);
		model.addAttribute("userinfo", userinfo);
		
		return "my-account-userinfo";
		
	}
	
	@GetMapping(value = "userUpdate")
	public String update(Model model , HttpSession session , @RequestParam String userName , @RequestParam String userPassword,
			@RequestParam String userPhoneNumber,@RequestParam String userAddress) throws Exception{
		Long userNo = (Long)session.getAttribute("userNo");
		Userinfo userinfo = userInfoService.findUserByNo(userNo);
		userinfo.setUserName(userName);
		userinfo.setUserPassword(userPassword);
		userinfo.setUserPhoneNumber(userPhoneNumber);
		userinfo.setUserAddress(userAddress);
		userInfoService.update(userinfo);
		
		model.addAttribute("userinfo", userinfo);
		
		return "my-account-userinfo";
	}
	
	@GetMapping("userDelete")
	public String delete(HttpSession session) throws Exception {
		Long userNo = (Long)session.getAttribute("userNo");
		/*
		userInfoService.remove(userNo);
		cartService.deleteByUserId(userNo);
		*/
		List<Orders> orderList = orderService.findOrderById(userNo);
		System.out.println(">>>>>>>>>>>>>>>>"+orderList);
		
		for (Orders orders : orderList) {
		List<OrderItem> orderItemList = orders.getOrderItems();
		System.out.println(">>>>>>>>>>>>>>>>"+orderItemList);
			for (OrderItem orderitem : orderItemList) {
				if(orderitem!=null) {
					orderItemService.deleteOrderItem(orderitem);
				}
			}
			//orderService.removeOrder(orders.getOrderNo());
		}
		/*
		List<Wish> wishs = wishService.findAllWishByUserNo(userNo);
		for (Wish wish : wishs) {
			wishService.deleteWish(wish.getWishNo());
		}
		session.invalidate();
		*/
		return "index";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	
}
