package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.entity.Userinfo;
import com.itwill.service.CouponService;
import com.itwill.service.UserInfoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
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

	
}
