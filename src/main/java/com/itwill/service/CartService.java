package com.itwill.service;

import java.util.List;

import com.itwill.entity.Cart;

public interface CartService {

	// 카트에 담기
	Cart insertCart(Cart cart);
	
	// 카트에 담긴 상품수량 변경 
	Cart update_qty(Cart updateQty) throws Exception;
	
	// 카트에 담긴 상품 선택
	Cart findByCartNo(Long no);
	
	// 카트에 담긴 상품 전체삭제
	void deleteByUserId(String userId);
	
	// 카트에서 선택한 상품만 삭제
	void deleteById(Long no) throws Exception;
	
	// 카트에 담긴 모든 상품 합계 금액
	Integer cartTotalPrice(String userId);
	
	// 카트에서 내가 선택한 상품의 합계 금액
	Integer cartSelectTotalPrice(Long no);
	
	/*
	// 카트에 중복제품이 있으면 합산되어 담기도록
	int productWithKindByUserId(Cart cart);
*/
	// 카트에 담긴 모든 상품 출력
	List<Cart> findAll();
	
	// 카트에 담긴 모든 상품 출력 (아이디 별)
	List<Cart> findAllCartByUserId(String userId);
	
}
