package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.CartDto;
import com.itwill.dto.OrdersDto;
import com.itwill.entity.Cart;
import com.itwill.entity.Product;
import com.itwill.service.CartService;
import com.itwill.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/cartList")
	// 카트 리스트 보기 (유저)
	public String cartList(Model model, HttpSession session) throws Exception{
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Long userNo=(Long)session.getAttribute("userNo");
		
		List<CartDto> cartListDto = new ArrayList<>();
		List<Cart> cartList = cartService.findAllCartByUserId(userNo); 
		
		for (Cart cart : cartList) {
			cartListDto.add(CartDto.toDto(cart));
		}
		model.addAttribute("cartList", cartList);
		return "cart";
	}
	
	
	@GetMapping(value = "/cart", params = "productNo")
	// 카트에 담기
	public String insertCart(Model model, HttpSession session, @RequestParam Long productNo) throws Exception{
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Long userNo=(Long)session.getAttribute("userNo");
		
		// productNo로 product 정보 가져오기
		Product product = productService.findByProductNo(productNo);
		// 
		Cart selectCart = new Cart();
		selectCart.setProduct(product);
		selectCart.setCartQty(product.getProductQty());
		
		return "cart";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
