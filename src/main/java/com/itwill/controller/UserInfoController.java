package com.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.service.UserInfoService;

@RestController
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	
	
	
	
}
