package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.dao.ProductDao;
import com.itwill.dao.UserInfoDao;
import com.itwill.entity.Wish;

class WishServiceImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	UserInfoDao userinfoDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	WishService wishService;
	
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void insert() {
		Wish insert = Wish.builder()

				.wishNo(null)
				.build();
		wishService.insertWish(insert);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void delete() throws Exception{
		wishService.deleteWish(3L);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAll() {
		List<Wish> wishList = wishService.findAllWishByUserNo(2L);
		System.out.println(wishList);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findByWishNo() {
		Wish wish = wishService.findByWishNo(19L);
		System.out.println(wish);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findByUserNoProductNo() {
		Wish wish = wishService.findByUserNoProductNo(8L, 1L);
		System.out.println(wish);	
	}
}



