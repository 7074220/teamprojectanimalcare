package com.itwill.controller;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.UserLoginActionDto;
import com.itwill.dto.UserWriteActionDto;
import com.itwill.entity.Userinfo;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserInfoRestController {

	@Autowired
	private UserInfoService userInfoService;

	// 회원가입
	@Operation(summary = "회원가입")
	@PostMapping()
	public ResponseEntity<UserWriteActionDto> user_write_action(UserWriteActionDto dto) throws Exception {

		userInfoService.create(UserWriteActionDto.toEntity(dto));
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<UserWriteActionDto>(dto, httpHeaders, HttpStatus.CREATED);
	}

	// 로그인
	@Operation(summary = "로그인")
	@GetMapping("/login")
	public ResponseEntity<UserLoginActionDto> user_login_action(@RequestBody UserLoginActionDto dto,
			HttpSession session) throws Exception {

		Userinfo loginUserCheck = userInfoService.login(dto.getUserId(), dto.getUserPassword());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		if (loginUserCheck == null) {
			dto.setUserId("");
			dto.setUserPassword("");
		} else {
			session.setAttribute("userNo", loginUserCheck.getUserNo());
		}

		return new ResponseEntity<UserLoginActionDto>(dto, httpHeaders, HttpStatus.OK);
	}

	// 회원탈퇴
	@Operation(summary = "회원탈퇴")
	@DeleteMapping("/{userNo}")
	public ResponseEntity<UserLoginActionDto> user_delete_action(@PathVariable(name = "userNo") Long userNo,
			HttpSession session) throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();

		if (session.getAttribute("userNo") != null) {
			userInfoService.remove(userNo);
			session.invalidate();
		}

		return new ResponseEntity<UserLoginActionDto>(httpHeaders, HttpStatus.OK);
	}

	// 회원 로그아웃
	@Operation(summary = "회원로그아웃")
	@GetMapping("/logout")
	public ResponseEntity<UserLoginActionDto> user_logout_action(@RequestBody UserLoginActionDto dto,
			HttpSession session) throws Exception {

		if (session.getAttribute("userNo") != null) {
			session.invalidate();
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<UserLoginActionDto>(httpHeaders, HttpStatus.OK);

	}

	// @PathVariable(name="userNo")Long userNo,
	// 회원 정보보기
	@Operation(summary = "회원정보보기")
	@GetMapping("/{userNo}")
	public ResponseEntity<UserWriteActionDto> user_view(@PathVariable(name = "userNo") Long userNo, HttpSession session)
			throws Exception {
		UserWriteActionDto dto = UserWriteActionDto.builder().build();
		if (session.getAttribute("userNo") != null) {
			Userinfo loginUser = userInfoService.findUserByNo(userNo);
			dto.setUserAddress(loginUser.getUserAddress());
			dto.setUserGender(loginUser.getUserGender());
			dto.setUserId(loginUser.getUserId());
			dto.setUserName(loginUser.getUserName());
			dto.setUserNo(loginUser.getUserNo());
			dto.setUserPhoneNumber(loginUser.getUserPhoneNumber());
			dto.setUserPassword(loginUser.getUserPassword());
			dto.setUserPoint(loginUser.getUserPoint());
			dto.setUserRegisterDate(loginUser.getUserRegisterDate());
			dto.setUserResidentNumber(loginUser.getUserResidentNumber());
			
		} else {
			dto = UserWriteActionDto.builder().build();
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<UserWriteActionDto>(dto, httpHeaders, HttpStatus.OK);

	}
	
	@Operation(summary="회원정보수정")
	@PutMapping("/{userNo}")
	public ResponseEntity<UserWriteActionDto> updateUser(@RequestBody UserWriteActionDto userWriteActionDto,@PathVariable(name="userNo")Long userNo, 
			HttpSession httpSession) throws Exception{
		
		Userinfo userinfo=	userInfoService.findUserByNo(userNo);
		userinfo.setUserPassword(userWriteActionDto.getUserPassword());
		userinfo.setUserName(userWriteActionDto.getUserName());
		userinfo.setUserGender(userWriteActionDto.getUserGender());
		userinfo.setUserAddress(userWriteActionDto.getUserAddress());
		userinfo.setUserPhoneNumber(userWriteActionDto.getUserPhoneNumber());
		
		userInfoService.update(userinfo);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserWriteActionDto>(userWriteActionDto, httpHeaders, HttpStatus.OK);
	}

}
