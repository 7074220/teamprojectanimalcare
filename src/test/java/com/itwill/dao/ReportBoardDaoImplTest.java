package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.ReviewBoard;
import com.itwill.entity.Userinfo;

import jakarta.transaction.Transactional;

class ReviewBoardDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	/*
	
	@Autowired
	ReviewBoardDao reviewBoardDao;
	@Autowired
	UserInfoDao userInfoDao;

	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void testCreate() {
		Userinfo userinfo = userInfoDao.findById("전아현");
		
		ReviewBoard reviewBoard = ReviewBoard.builder()
								.boardNo(8L)
								.boardTitle("이것은 타이틀")
								.boardContent("이것은 내용")
								.boardDate(LocalDate.now())
								.boardStar(2L)
								.userinfo(userinfo)
								.build();

		reviewBoardDao.create(reviewBoard);
		
	}
	
	
	
	
	
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
	void testFindByUserId() {
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