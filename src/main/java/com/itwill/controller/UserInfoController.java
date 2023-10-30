package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.entity.Userinfo;
import com.itwill.service.UserInfoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;
	
	public UserInfoController() {
		System.out.println("### UserController()기본생성자");
	}
	
	@GetMapping(value = "/user_list")
	public String list(HttpServletRequest request) throws Exception {
		List<Userinfo> userList= userInfoService.findUserList();
		request.setAttribute("userList", userList);
		return null;
	}
		

}
