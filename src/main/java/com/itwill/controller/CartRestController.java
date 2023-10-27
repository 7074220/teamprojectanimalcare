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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.CartDto;
import com.itwill.service.CartService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;

	@Operation(summary = "카트 추가")
	@GetMapping
	public ResponseEntity<CartDto> insertCart(CartDto dto) {

		cartService.insertCart(CartDto.toEntity(dto));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<CartDto>(dto, httpHeaders, HttpStatus.CREATED);
	}

	@Operation(summary = "카트 번호로 한 개 삭제")
	@DeleteMapping("/{productNo}")
	public ResponseEntity<CartDto> deleteByCartNo(@PathVariable(name = "productNo") Long productNo) throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();

		cartService.deleteById(productNo);

		return new ResponseEntity<CartDto>(httpHeaders, HttpStatus.OK);
	}

	@Operation(summary = "유저 아이디로 카트 전체 삭제")
	@DeleteMapping("/{userNo}")
	public ResponseEntity<CartDto> deleteByUserNo(@PathVariable(name = "userNo") Long userNo) throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();

		cartService.deleteById(userNo);

		return new ResponseEntity<CartDto>(httpHeaders, HttpStatus.OK);
	}
}
