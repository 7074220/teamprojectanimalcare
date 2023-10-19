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
	void findByCartNo() {
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
	// 강사님께 여쭤보기 ORA-01002 : fetch out of sequence
	void deleteByUserId(){
		cartDao.deleteByUserId("전아현");
	}
	
	@Test
	@Disabled
	void deleteById() throws Exception{
		cartDao.deleteById(10l);
	}
	
}
