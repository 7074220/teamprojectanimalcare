package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Product;
import com.itwill.entity.ReviewBoard;
import com.itwill.entity.Userinfo;

import jakarta.transaction.Transactional;

class ReviewBoardDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	
	
	@Autowired
	ReviewBoardDao reviewBoardDao;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	ProductDao productDao;
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testCreate() {
		Userinfo userinfo = userInfoDao.findById("전아현");
		Product product = productDao.findByProductNo(4L);
		ReviewBoard reviewBoard = ReviewBoard.builder()
								.boardTitle("이것은 타이틀")
								.boardContent("이것은 내용")
								.boardDate(LocalDate.now())
								.boardStar(2L)
								.userinfo(userinfo)
								.product(product)
								.build();

		reviewBoardDao.create(reviewBoard);
		
	}
	
	
	
	
	/*
	
	@Test
	@Disabled
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteById() {
		fail("Not yet implemented");
	}


	@Test
	@Disabled
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testFindByStarAll() {
		fail("Not yet implemented");
	}
	
	
	*/
}
