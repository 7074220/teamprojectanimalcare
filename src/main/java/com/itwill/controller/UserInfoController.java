package com.itwill.controller;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.UserLoginActionDto;
import com.itwill.dto.UserWriteActionDto;
import com.itwill.entity.Userinfo;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	// 회원가입
	@Operation(summary = "회원가입")
	@PostMapping
	public ResponseEntity<UserWriteActionDto> user_write_action(UserWriteActionDto dto) throws Exception {

		userInfoService.create(UserWriteActionDto.toEntity(dto));
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<UserWriteActionDto>(dto, httpHeaders, HttpStatus.CREATED);
	}

	// 로그인

	@Operation(summary = "로그인")
	@GetMapping
	public ResponseEntity<UserLoginActionDto> user_login_action(@RequestBody UserLoginActionDto dto,
			HttpSession session) throws Exception {

		Userinfo loginUserCheck = userInfoService.login(dto.getUserId(), dto.getUserPassword());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		if (loginUserCheck == null) {
			dto.setUserId("");
			dto.setUserPassword("");

		}

		return new ResponseEntity<UserLoginActionDto>(dto, httpHeaders, HttpStatus.CREATED);
	}

}
