package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.WishlistDto;
import com.itwill.dto.WishlistInsertDto;
import com.itwill.entity.Wish;
import com.itwill.service.WishService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/wish")
public class WishRestController {
	
	// 서진님... 왜 컨트롤러 안보이냐고  
	@Autowired
	private WishService wishService;
	
	@Operation(summary = "위시리스트 넣기")
	@PostMapping
	public ResponseEntity<WishlistInsertDto> insertWishlist(@RequestBody WishlistInsertDto dto){
		Wish wishlist = WishlistInsertDto.toEntity(dto);
		
		wishService.insertWish(wishlist);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<WishlistInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	
	
	
}
