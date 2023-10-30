package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itwill.dto.WishlistInsertDto;
import com.itwill.entity.Wish;
import com.itwill.service.WishService;
import org.springframework.ui.Model;

@Controller
public class WishController {

	@Autowired
	private WishService wishService;
	
	@GetMapping("/wishList/{userNo}")
	// 위시리스트
	public String Wishlist(Model model, @PathVariable(name = "userNo") Long userNo) {
		List<WishlistInsertDto> wishlistDto = new ArrayList<>();
		List<Wish> wishlist = wishService.findAllWishByUserNo(userNo);
		
		for (Wish wish : wishlist) {
			wishlistDto.add(WishlistInsertDto.toDto(wish));
		}
		model.addAttribute("wishlist", wishlistDto);
		
		return "wishlist";
	}
}
