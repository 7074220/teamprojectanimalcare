package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.ReviewBoard;
import com.itwill.repository.ReviewBoardRepository;

@Repository
public class ReviewBoardDaoImpl implements ReviewBoardDao {
	@Autowired
	ReviewBoardRepository reviewBoardRepository;

	@Override
	public ReviewBoard create(ReviewBoard reviewBoard) {
		return reviewBoardRepository.save(reviewBoard);
	}

	@Override
	public ReviewBoard update(ReviewBoard reviewBoard) {
		if (reviewBoardRepository.findById(reviewBoard.getBoardNo()).isPresent()) {
			reviewBoardRepository.save(reviewBoard);
		}
		return reviewBoard;
	}

	@Override
	public void deleteById(Long boardNo) {
		if (reviewBoardRepository.findById(boardNo).isPresent()) {
			reviewBoardRepository.deleteById(boardNo);
		}

	}

	@Override
	public List<ReviewBoard> findAll() {
		return reviewBoardRepository.findAll();
	}

	@Override
	public List<ReviewBoard> findByStarAll(Long star) {
		return reviewBoardRepository.findAllByBoardStar(star);
	}

	@Override
	public List<ReviewBoard> getReviewBoardByProductNo(Long productNo) {
		// productNo로 reviewboard 리스트 검색
		return reviewBoardRepository.getReviewBoardByProduct_ProductNo(productNo);
	}

	// userId로 리뷰 리스트 나오기

	@Override
	public List<ReviewBoard> findAllByUserIdUserinfo(String userId) {
		return reviewBoardRepository.findAllByUserinfoUserId(userId);
	}

	// 높은평점순 정렬
	@Override
	public List<ReviewBoard> findAllByOrderByBoardStarDesc() {
		return reviewBoardRepository.findAllByOrderByBoardStarDesc();
	}

	// 낮은평점순 정렬
	@Override
	public List<ReviewBoard> findAllByOrderByBoardStarAsc() {
		return reviewBoardRepository.findAllByOrderByBoardStarAsc();

	}

	// 최신순 정렬(board no정렬)
	@Override
	public List<ReviewBoard> findAllByOrderByBoardNoDesc() {
		return reviewBoardRepository.findAllByOrderByBoardNoDesc();
	}

	// 오래된순 정렬(board no정렬)
	@Override
	public List<ReviewBoard> findAllByOrderByBoardNoAsc() {
		return reviewBoardRepository.findAllByOrderByBoardNoAsc();
	}
	
	/*
	  //별점 높은순,최신순
	  
	  @Override public List<ReviewBoard>
	  findByBoardStarOrderByBoardStarDescBoardNoDesc(Long star) { return
	  reviewBoardRepository.findByBoardStarOrderByBoardStarDescBoardNoDesc(star); }
	 */
}