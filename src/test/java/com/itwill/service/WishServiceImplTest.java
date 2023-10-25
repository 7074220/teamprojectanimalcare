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
	@Disabled
	@Transactional
	@Rollback(false)
	void insert() {
		Wish insert = Wish.builder()
				.product(productDao.findByProductNo(1L))
				.userinfo(userinfoDao.findByNo(2L))
				.wishNo(null)
				.build();
		wishService.insertWish(insert);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void delete() throws Exception{
		wishService.deleteWish(2L);
	}
	
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void findAll() {
		List<Wish> wishList = wishService.findAllWishByUserNo(2L);
		System.out.println(wishList);
	}

}
