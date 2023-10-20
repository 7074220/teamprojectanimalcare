package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.ReviewBoard;
import com.itwill.entity.Userinfo;

import jakarta.transaction.Transactional;
@SpringBootTest
class ReviewBoardDaoImplTest {
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	ReviewBoardDao reviewBoardDao;
	
//	@Test
//	@Transactional
//	@Rollback(value = false)
//	@Disabled
//	void getReviewBoardByProductNo() {
//		List<ReviewBoard> selectReviewBoard = reviewBoardDao.getReviewBoardByProductNo(1L);
//		System.out.println(selectReviewBoard);
//	}
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
