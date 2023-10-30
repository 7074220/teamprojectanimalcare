package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itwill.dto.CartDto;
import com.itwill.entity.Cart;
import com.itwill.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/list")
	// 카트 리스트 보기 (유저)
	public String cartList(Model model, @PathVariable(name = "userNo") Long userNo) {
		List<CartDto> cartListDto = new ArrayList<>();
		List<Cart> cartList = cartService.findAllCartByUserId(userNo); 
		
		for (Cart cart : cartList) {
			cartListDto.add(CartDto.toDto(cart));
		}
		model.addAttribute("cartList", cartList);
		return "cart";
	}
}
