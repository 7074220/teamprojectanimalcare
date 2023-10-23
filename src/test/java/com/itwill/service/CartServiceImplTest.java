package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

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
	void updateQtyCartTest() {
		//Cart update = cartService.update_qty();
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findByCartNoTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteByUserIdTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteByIdTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAllTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void cartTotalPriceTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAllCartByUserIdTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void countProductByUserIdTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	// 카트에 중복제품이 있으면 (중복체크) --> 업데이트 돼서 담기도록 
	void updateOverlapCart() {
		
	}
}
