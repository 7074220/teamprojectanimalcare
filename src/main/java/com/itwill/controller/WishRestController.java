package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.CartDto;
import com.itwill.dto.WishlistDto;
import com.itwill.dto.WishlistInsertDto;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Wish;
import com.itwill.service.UserInfoService;
import com.itwill.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/wish")
public class WishRestController {
	
	// 서진님... 왜 컨트롤러 안보이냐고  
	@Autowired
	private WishService wishService;
	@Autowired
	private UserInfoService userInfoService;
	
	
	
	
	@Operation(summary = "위시리스트 추가")
	@PostMapping
	// insert
	public ResponseEntity<WishlistInsertDto> insertWishlist(@RequestBody WishlistInsertDto dto, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Wish wishlist = WishlistInsertDto.toEntity(dto);
		
		wishService.insertWish(wishlist);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<WishlistInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "위시리스트에 담긴 갯수 출력")
	@GetMapping("/countWishlist/{userNo}")
	public ResponseEntity<Integer> countWishlist(@PathVariable(name = "userNo") Long userNo, HttpSession session) {
		Integer count = wishService.countWishlist(userNo);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<>(count, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "위시리스트 삭제")
	@DeleteMapping("/{no}")
	// delete
	public void deleteWish(@PathVariable(name = "no") Long no,HttpSession session) throws Exception{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>실행1");
		wishService.deleteWish(no);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>실행2");
		Long loginUserNo=(Long) session.getAttribute("userNo");
		Userinfo loginUserCheck = userInfoService.findUserByNo(loginUserNo);
		wishService.deleteWish(loginUserNo);
		int wishCount = wishService.findAllWishByUserNo(loginUserCheck.getUserNo()).size();
		session.setAttribute("wishCount", wishCount);
		
	}
	
	
	
	
	@Operation(summary = "위시리스트 보기")
	@GetMapping("/find/{userNo}")
	public ResponseEntity<List<WishlistInsertDto>> findAllWish(@PathVariable(name = "userNo") Long no) {
		List<Wish> wishList = wishService.findAllWishByUserNo(no);
		List<WishlistInsertDto> wishDtoList = new ArrayList<>();
		
		for (Wish wish : wishList) {
			WishlistInsertDto wishlistInsertDtos = WishlistInsertDto.toDto(wish);
			wishDtoList.add(wishlistInsertDtos);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<WishlistInsertDto>>(wishDtoList, httpHeaders, HttpStatus.OK);
	}
	
}