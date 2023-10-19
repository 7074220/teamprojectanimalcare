package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Cart;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;

class CartDaoImplTest extends TeamprojectAnimalcareApplicationTest {
	@Autowired
	CartDao cartDao;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	ProductDao productDao;
	
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void insertCartTest() {
		Cart cart = Cart.builder()
				.cartQty(1)
				.userinfo(userInfoDao.findById("전아현"))
				.product(productDao.findByProductNo(1L))
				.build();
		cartDao.insertCart(cart);
	}
	
	@Test
	@Disabled
	void updateCartTest() {
		Cart findCart = cartDao.findByCartNo(1L);
		findCart.setCartQty(50);
		System.out.println(findCart);
	}
	
	@Test
	//@Disabled
	void findByCartNo() {
		Cart findCart = cartDao.findByCartNo(1L);
		System.out.println(findCart);
	}
}
