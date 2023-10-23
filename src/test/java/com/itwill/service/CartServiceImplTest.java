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
				.build();
		Cart babo = cartService.insertCart(cart);
		System.out.println(babo);
	}

}
