package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.dao.CartDao;
import com.itwill.dao.ProductDao;
import com.itwill.dao.UserInfoDao;
import com.itwill.entity.Cart;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;

class CartServiceImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartService cartService;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void insertCart() {
		Userinfo userinfo = userInfoDao.findById("전아현");
		Product product = productDao.findByProductNo(1L);
		Cart cart = Cart.builder()
				.cartNo(null)
				.cartQty(1)
				.userinfo(userinfo)
				.cartImage(product.getProductImage())
				.build();
		Cart babo = cartService.insertCart(cart);
		System.out.println(babo);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	// 카트에 담긴 상품 선택
	void findByCartNoTest() {
		Cart selectCart = cartService.findByCartNo(1L);
		System.out.println(selectCart);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	// 카트에서 cartNo로 하나 선택 --> 수량 업데이트
	void updateQtyCartTest() {
		Cart update = cartService.findByCartNo(1L);
		update.setCartQty(100);
		System.out.println(update);
	}
	
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	// 선택된 userId cart에 담긴 모든 상품 삭제
	void deleteByUserIdTest() throws Exception {
		cartService.deleteByUserId("전아현");
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	// 카트에서 선택한 상품만 삭제
	void deleteByIdTest() throws Exception {
		cartService.deleteById(1L);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAllTest() {
		List<Cart> carts = cartService.findAll();
		System.out.println(carts);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void cartTotalPriceTest() {
		Integer totalPrice = cartService.cartTotalPrice("전아현");
		System.out.println(totalPrice);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAllCartByUserIdTest() {
		List<Cart> carts = cartService.findAllCartByUserId("전아현");
		System.out.println(carts);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void countProductByUserIdTest() {
		Integer count = cartService.countProductByUserId("전아현", 2L);
		System.out.println(count);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	// 카트에 중복제품이 있으면 (중복체크) --> 업데이트 돼서 담기도록 
	void updateOverlapCart() {
		Cart update = cartService.updateOverlapCart(null);
		
	}
}
