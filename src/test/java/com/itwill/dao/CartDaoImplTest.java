package com.itwill.dao;


import java.util.List;

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
	@Disabled
	@Transactional
	@Rollback(false)
	void updateCartTest() {
		Cart findCart = cartDao.findByCartNo(1L);
		findCart.setCartQty(50);
		System.out.println(findCart);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByCartNoTest() {
		Cart findCart = cartDao.findByCartNo(1L);
		System.out.println(findCart);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertCartTest() {
		Cart cart1 = Cart.builder()
				.cartNo(null)
				.cartQty(5)
				.userinfo(userInfoDao.findById("전아현"))
				.product(productDao.findByProductNo(22L))
				.build();
		cartDao.insertCart(cart1);
		Cart cart2 = Cart.builder()
				.cartNo(null)
				.cartQty(5)
				.userinfo(userInfoDao.findById("전아현"))
				.product(productDao.findByProductNo(30L))
				.build();
		cartDao.insertCart(cart2);
		Cart cart3 = Cart.builder()
				.cartNo(null)
				.cartQty(5)
				.userinfo(userInfoDao.findById("전아현"))
				.product(productDao.findByProductNo(1L))
				.build();
		cartDao.insertCart(cart3);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteByUserIdTest(){
		System.out.println(cartDao);
		cartDao.deleteByUserId("박태환");
	}
	
	@Test
	@Disabled
	void deleteByIdTest() throws Exception{
		cartDao.deleteById(10l);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAllTest() {
		List<Cart> carts = cartDao.findAll();
		System.out.println(carts);
	}
	
	@Test
	@Disabled
	// SQL Error: 17006, SQLState: 99999 부적합한 열 이름
	void cartTotalPriceTest() {
		Cart totalPrice = cartDao.cartTotalPrice("전아현");
		System.out.println(totalPrice);
	}
	
}
