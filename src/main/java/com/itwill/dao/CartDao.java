package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Cart;

public interface CartDao {

	
	// 카트에 담기
	Cart insertCart(Cart cart);
	
	
	// 카트에 담긴 상품수량 변경 
	Cart update_qty(Cart updateQty) throws Exception;
	
	/*
	// 카트에 담긴 상품 삭제
	void deleteCart(Cart cart) throws Exception;
	
	// 카트에 담긴 모든 상품 합계 금액
	int totalPrice(Cart cart);
	
	// 카트에 중복제품이 있으면 합산되어 담기도록
	int productWithKindByUserId(Cart cart);

	// 카트에 담긴 모든 상품 출력
	List<Cart> findAll();
	*/
}
