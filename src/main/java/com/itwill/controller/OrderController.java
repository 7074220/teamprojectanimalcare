package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.CartDto;
import com.itwill.dto.OrderItemDto;
import com.itwill.dto.OrdersDto;
import com.itwill.entity.Cart;
import com.itwill.entity.Coupon;
import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;
import com.itwill.entity.Orderstatus;
import com.itwill.entity.Userinfo;
import com.itwill.repository.OrderStatusRepository;
import com.itwill.service.CartService;
import com.itwill.service.OrderItemService;
import com.itwill.service.OrderService;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	OrderStatusRepository orderStatusRepository;
	@Autowired
	OrderItemService itemService;
	@Autowired
	UserInfoService userInfoService;
	
	@Operation(summary = "주문 등록")
	@Transactional
	@PostMapping("/orderInsert")
	public String insert_Order(@RequestBody OrdersDto orderDto, HttpSession session)throws Exception {
		  if (session.getAttribute("userNo") == null) {
			  
			  throw new
		 Exception("로그인 하세요."); 
		  
		  }
		Long userNo = (Long) session.getAttribute("userNo");
		Orderstatus orderstatus= orderStatusRepository.findById(1L).get();
		Long osNo = orderstatus.getOsNo();
		List<Cart> carts = cartService.findAllCartByUserId(userNo);
		Orders insertOrder = orderService.insertOrder(OrdersDto.toEntity(orderDto));
		
		List<OrderItemDto> orderItemDtos = new ArrayList<OrderItemDto>();
		
		for (Cart cart : carts) {
			OrderItemDto tempOrderItemDto=OrderItemDto.builder().build();
			tempOrderItemDto.setOiQty(cart.getCartQty());
			tempOrderItemDto.setOrderNo(insertOrder.getOrderNo());
			tempOrderItemDto.setOsNo(osNo);
			tempOrderItemDto.setProductNo(cart.getProduct().getProductNo());
			
			itemService.insertOrderItem(OrderItemDto.toEntity(tempOrderItemDto));
			orderItemDtos.add(tempOrderItemDto);
			
		}
		orderDto.setOrderItemDtos(orderItemDtos);
		orderDto.setUserNo(userNo);
		orderDto.setOrderDesc(carts.get(0).getProduct().getProductName()+"외"+(carts.size()-1)+"개 상품");
		//insertOrder.setOrderDesc(carts.get(0).getProduct().getProductName()+"외"+(carts.size()-1)+"개 상품");
		//insertOrder.setOrderAddress(orderDto.getOrderAddress());
		
		orderService.insertOrder(orderDto.toEntity(orderDto));
		cartService.deleteByUserId(userNo);
		return "redirect:order_success";
	}
	//관리자전용
	@GetMapping("/ordersList")
	public String findOrders(Model model) {
		List<Orders> orderList = orderService.findOrders();
		List<OrdersDto> ordersDto = new ArrayList<OrdersDto>();
		
		for (Orders orders : orderList) {
			ordersDto.add(OrdersDto.toDto(orders));
		}
		model.addAttribute("ordersList",ordersDto);

		return "orderList";
	}
	//회원 주문목록
	@GetMapping("/uordersList")
	public String findOrderByUser( HttpSession session,Model model) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		Long userNo=(Long)session.getAttribute("userNo");
		
		List<Orders> orderList = orderService.findOrderById(userNo);
		List<OrdersDto> ordersDto = new ArrayList<OrdersDto>();
		
		for (Orders orders : orderList) {
			ordersDto.add(OrdersDto.toDto(orders));
		}
		
		model.addAttribute("uOrderList",ordersDto);
		return "uOrderList";
	}
	
	//orderform
		@GetMapping("orderView")
		public String orderView(HttpSession session,Model model) throws Exception{
			if (session.getAttribute("userNo") == null) {
				throw new Exception("로그인 하세요.");
			}
			Long userNo=(Long)session.getAttribute("userNo");
			List<Cart> carts=cartService.findAllCartByUserId(userNo);
			List<CartDto> cartDtos=new ArrayList<>();
			for (Cart cart : carts) {
				cartDtos.add(CartDto.toDto(cart));
			}
			//user정보가지고있는 dto 필요
			Userinfo userinfo=userInfoService.findUserByNo(userNo);
			model.addAttribute("user",userinfo);//userinfo는 서비스로 찾는지 의문
			model.addAttribute("cartList",cartDtos);
			
			
			
			
			return "orderView";
		}
		//orderitemList 조회
		@GetMapping("orderItemiew")
		public String orderItemiew(@RequestParam(name = "orderNo")Long orderNo,HttpSession session,Model model) throws Exception{
			if (session.getAttribute("userNo") == null) {
				throw new Exception("로그인 하세요.");
			}
			Orders orders=orderService.findOrderByNo(orderNo);
		List<OrderItem> orderItems=orders.getOrderItems();
		List<OrderItemDto> orderitemDtos= new ArrayList<>();
		for (OrderItem orderItem : orderItems) {
			orderitemDtos.add(OrderItemDto.toDto(orderItem));
		}
		model.addAttribute("orderItemList",orderitemDtos);
		
			return "orderItemView";
		}
		
	
}
