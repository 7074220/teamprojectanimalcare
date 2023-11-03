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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.CartDto;
import com.itwill.dto.CartOverlapDto;
import com.itwill.dto.CartTotalPriceDto;
import com.itwill.entity.Cart;
import com.itwill.service.CartService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;

	/*
	@Operation(summary = "카트 추가")
	@GetMapping
	public ResponseEntity<CartDto> insertCart(CartDto dto, HttpSession session) throws Exception{

		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
			
		} else if (session.getAttribute("userNo") != null && dto.getCartQty() == 0) {
			throw new Exception("수량을 입력하세요.");
			
		} else if (session.getAttribute("userNo") != null && dto.getCartQty() != 0) {
			cartService.insertCart(CartDto.toEntity(dto));

		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<CartDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	*/
	
	@Operation(summary = "카트 번호로 한 개 삭제")
	@DeleteMapping("/delete/{cartNo}")
	public void deleteByCartNo(@PathVariable(name = "cartNo") Long cartNo, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		cartService.deleteById(cartNo);
	}

	
	@Operation(summary = "유저 아이디로 카트 전체 삭제")
	@DeleteMapping("/delete/user/{userNo}")
	public ResponseEntity<CartDto> deleteByUserNo(@PathVariable(name = "userNo") Long userNo, HttpSession session) throws Exception {

		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		cartService.deleteByUserId(userNo);
		
		HttpHeaders httpHeaders = new HttpHeaders();

		return new ResponseEntity<CartDto>(httpHeaders, HttpStatus.OK);
	}

	
	@Operation(summary = "상품 수량 업데이트")
	@PutMapping("/{cartNo}")
	public ResponseEntity<CartDto> updateCartQty(@PathVariable(name = "cartNo") Long no, @RequestBody CartDto dto, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Cart findCart = cartService.findByCartNo(no);

		findCart.setCartQty(dto.getCartQty());
		cartService.update_qty(findCart);

		CartDto updatedDto = CartDto.toDto(findCart);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<CartDto>(updatedDto, httpHeaders, HttpStatus.OK);
	}

	
	@Operation(summary = "카트번호로 선택하기")
	@GetMapping("/{cartNo}")
	public ResponseEntity<CartDto> findByCartNo(@PathVariable(name = "cartNo") Long cartNo, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Cart findCart = cartService.findByCartNo(cartNo);
		CartDto cartDto = CartDto.toDto(findCart);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<CartDto>(cartDto, httpHeaders, HttpStatus.OK);
	}

	
	@Operation(summary = "유저 카트 리스트")
	@GetMapping("/cartList/{userNo}")
	public ResponseEntity<List<CartDto>> cartList(@PathVariable(name = "userNo") Long no, HttpSession session) throws Exception{
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		List<Cart> cartList = cartService.findAllCartByUserId(no);
		List<CartDto> cartsDto = new ArrayList<CartDto>();

		for (Cart cart : cartList) {
			cartsDto.add(CartDto.toDto(cart));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<CartDto>>(cartsDto, httpHeaders, HttpStatus.OK);
	}

	
	@Operation(summary = "중복 상품 업데이트")
	@PutMapping
	public ResponseEntity<List<CartDto>> updateOverlapCart(CartOverlapDto dto, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Cart updateCart = cartService.updateOverlapCart(CartOverlapDto.toEntity(dto));
		CartOverlapDto cartOverlapDto = CartOverlapDto.toDto(updateCart);
		
		List<Cart> cartList = cartService.findAllCartByUserId(dto.getUserNo());
		List<CartDto> cartsDto = new ArrayList<CartDto>();

		for (Cart cart : cartList) {
			cartsDto.add(CartDto.toDto(cart));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<CartDto>>(cartsDto, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "카트에 있는 모든 상품 가격")
	@GetMapping("/totalPrice/{userNo}")
	public ResponseEntity<CartTotalPriceDto> cartTotalPrice(@PathVariable(name = "userNo") Long userNo, HttpSession session) throws Exception{
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Integer totalPrice = cartService.cartTotalPrice(userNo);
		CartTotalPriceDto total = new CartTotalPriceDto();
		total.setTotalPrice(totalPrice);

		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<CartTotalPriceDto>(total, httpHeaders, HttpStatus.OK);
	}
	
	/*
	@Operation(summary = "카트에 있는 모든 상품 가격")
	@PostMapping("/updateCart")
	public ResponseEntity<Cart> updateCart(HttpSession session,@RequestBody Integer cartQty) throws Exception{
		Long userNo = (Long)session.getAttribute("userNo");
		
		if (userNo == null) {
			throw new Exception("로그인 하세요.");
		}
		
		System.out.println(">>>>>>>cartqty"+cartQty);
		 000
		Integer totalPrice = cartService.cartTotalPrice(userNo);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<Cart>(total, httpHeaders, HttpStatus.OK);
	}
	*/
	
	
	

	 
}