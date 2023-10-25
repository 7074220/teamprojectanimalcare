package com.itwill.controller;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.entity.Userinfo;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	// 회원가입
	@Operation(summary = "회원가입")
	@PostMapping
	public ResponseEntity<Userinfo> user_write_action(@RequestBody Userinfo userinfo) throws Exception{
		userInfoService.create(userinfo);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<Userinfo>(userinfo, httpHeaders, HttpStatus.CREATED);
	}
	
	
	
	
	
}
