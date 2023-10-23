package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.dao.ReviewBoardDao;
import com.itwill.entity.ReviewBoard;

@SpringBootTest
class ReviewBoardServiceImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	ReviewBoardService reviewBoardService;
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	ProductService productService;
	
	
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void create() throws Exception{
		
		ReviewBoard reviewBoard = ReviewBoard.builder()
				 					.boardTitle("서비스 타이틀")
				 					.boardContent("서비스 내용")
				 					.boardDate(new Date())
				 					.boardStar(5)
				 					.userinfo(userInfoService.findUser(5L))
				 					.product(productService.findByProductNo(5L))			
				 					.build();
		reviewBoardService.create(reviewBoard);
		
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testGetReviewBoardByProductNo() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindByStarAll() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindByUserNo() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindAllByOrderByBoardStarDesc() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindAllByOrderByBoardStarAsc() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindAllByOrderByBoardNoDesc() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindAllByOrderByBoardNoAsc() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindByBoardStarOrderByBoardStarDescBoardDateDesc() {
		fail("Not yet implemented");
	}

}
