package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;
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
	
	@Test//생성
	@Disabled
	@Transactional
	@Rollback(false)
	void testCreate() {
	
		ReviewBoard reviewBoard = ReviewBoard.builder()
								.boardTitle("Dao 테스트 타이틀12")
								.boardContent("Dao 테스트 내용12")
								.boardDate(new Date())
								.boardStar(3)
								.userinfo(userInfoDao.findByNo(11L))
								.product(productDao.findByProductNo(11L))
								.build();

		reviewBoardDao.create(reviewBoard);
	}
		@Test
		@Transactional
		@Rollback(value = false)
		@Disabled
		void updatereviewBoard() {
			ReviewBoard updatereviewBoard = reviewBoardDao.findByBoardNo(2L);
			updatereviewBoard.setBoardContent("수정이될려나");
			System.out.println(updatereviewBoard);
		}
		
		@Test
		@Transactional
		//@Disabled
		void selectBoard() {
			ReviewBoard selectBoard = reviewBoardDao.findByBoardNo(22L);
			System.out.println(selectBoard);
		}
		
		@Test
		@Transactional
		@Rollback(value = false)
		@Disabled
		void deleteBoard() {
			reviewBoardDao.deleteById(1L);
		}
	
	@Test//상품번호로 리뷰찾기
	@Transactional
	@Rollback(value = false)
	@Disabled
	void getReviewBoardByProduct_ProductNo() {
		List<ReviewBoard> selectReviewBoard = reviewBoardDao.getReviewBoardByProductNo(1L);
		System.out.println(selectReviewBoard);
	}

	@Test//유저 아이디로 찾기
	@Transactional
	@Disabled 
	void findByReviewBoardUserId() {
		List<ReviewBoard> findByUserIdReviewBoard = reviewBoardDao.findByUserNo(5L);
		System.out.println(findByUserIdReviewBoard);
	}
	
	@Test//선택한 별점으로 찾기
	@Transactional
	@Disabled
	void findAllByBoardStar() {
		List<ReviewBoard> findAllByBoardStar = reviewBoardDao.findByStarAll(5L);
		System.out.println(findAllByBoardStar);
	}
	@Test//별점 높은순
	@Transactional
	@Disabled
	void findAllByOrderByBoardStarDesc() {
		List<ReviewBoard> findAllByOrderByBoardStarDesc = reviewBoardDao.findAllByOrderByBoardStarDesc();
		System.out.println(findAllByOrderByBoardStarDesc);
	}
	
	@Test//별점 낮은순
	@Transactional
	@Disabled
	void findAllByOrderByBoardStarAsc() {
		List<ReviewBoard> findAllByOrderByBoardStarAsc = reviewBoardDao.findAllByOrderByBoardStarAsc();
		System.out.println(findAllByOrderByBoardStarAsc);
	}
	
	@Test// 최신순 정렬(board Date정렬)
	@Transactional
	@Disabled
	void findAllByOrderByBoardNoDesc() {
		List<ReviewBoard> findAllByOrderByBoardDateDesc = reviewBoardDao.findAllByOrderByBoardDateDesc();
		System.out.println(findAllByOrderByBoardDateDesc);
	}
	
	
	@Test// 오래된순 정렬(board Date정렬)
	@Transactional
	@Disabled
	void findAllByOrderByBoardNoAsc() {
		List<ReviewBoard> findAllByOrderByBoardDateAsc = reviewBoardDao.findAllByOrderByBoardDateAsc();
		System.out.println(findAllByOrderByBoardDateAsc);
	}
	
	
	
	  @Test//별점 높은순,최신순	  
	  @Transactional  
	  @Rollback(false) 
	  @Disabled 
	  public void findByOrderByBoardStarDescBoardDateDesc() { 
		  List<ReviewBoard> findByOrderByBoardStarDescBoardDateDesc = reviewBoardDao.findByOrderByBoardStarDescBoardDateDesc();

		  System.out.println(findByOrderByBoardStarDescBoardDateDesc); 
	  }
	 
	  @Test//별점 낮은순,최신순	  
	  @Transactional  
	  @Rollback(false) 
	  @Disabled 
	  public void findByOrderByBoardStarAscBoardDateDesc() { 
		  List<ReviewBoard> findByOrderByBoardStarAscBoardDateDesc = reviewBoardDao.findByOrderByBoardStarAscBoardDateDesc();
		  
		  System.out.println(findByOrderByBoardStarAscBoardDateDesc); 
	  }
	 
	
	  
}
