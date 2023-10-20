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
import com.itwill.entity.Product;
import com.itwill.entity.ReviewBoard;
import com.itwill.entity.Userinfo;

import jakarta.transaction.Transactional;

@SpringBootTest
class ReviewBoardDaoImplTest {
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
	
		ReviewBoard reviewBoard = ReviewBoard.builder()
								.boardTitle("이것은 타이틀")
								.boardContent("이것은 내용")
								.boardDate(LocalDate.now())
								.boardStar(2L)
								.userinfo(userInfoDao.findById("전아현"))
								.product(productDao.findByProductNo(6L))
								.build();

		reviewBoardDao.create(reviewBoard);
		
	}
	@Test
	@Transactional
	@Rollback(value = false)
	@Disabled
	void getReviewBoardByProduct_ProductNo() {
		List<ReviewBoard> selectReviewBoard = reviewBoardDao.getReviewBoardByProductNo(6L);
		System.out.println(selectReviewBoard);
	}

	@Test
	@Transactional
	@Disabled
	void findByUserId() {
		List<ReviewBoard> findByUserIdReviewBoard = reviewBoardDao.findAllByUserIdUserinfo("박태환");
		System.out.println(findByUserIdReviewBoard);
	}
	
	@Test
	@Transactional
	void findAllByBoardStar() {
		List<ReviewBoard> findAllByBoardStar = reviewBoardDao.findByStarAll(2L);
		System.out.println(findAllByBoardStar);
	}
	
	 /*
	 * 
	 * @Test
	 * 
	 * @Disabled void testUpdate() { fail("Not yet implemented"); }
	 * 
	 * @Test
	 * 
	 * @Disabled void testDeleteById() { fail("Not yet implemented"); }
	 * 
	 * @Test
	 * 
	 * @Disabled void testFindByUserId() { fail("Not yet implemented"); }
	 * 
	 * @Test
	 * 
	 * @Disabled void testFindAll() { fail("Not yet implemented"); }
	 * 
	 * @Test
	 * 
	 * @Disabled void testFindByStarAll() { fail("Not yet implemented"); }
	 * 
	 * 
	 */
}