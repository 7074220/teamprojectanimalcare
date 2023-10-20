package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.ReviewBoard;
import com.itwill.repository.ReviewBoardRepository;

@Repository
public class ReviewBoardDaoImpl implements ReviewBoardDao{
	@Autowired
	ReviewBoardRepository reviewBoardRepository;

	@Override
	public ReviewBoard create(ReviewBoard reviewBoard) {
		return reviewBoardRepository.save(reviewBoard);
	}

	@Override
	public ReviewBoard update(ReviewBoard reviewBoard) {
		if(reviewBoardRepository.findById(reviewBoard.getBoardNo()).isPresent()) {
			reviewBoardRepository.save(reviewBoard);
		}
		return reviewBoard;
	}

	@Override
	public void deleteById(Long boardNo) {
		if(reviewBoardRepository.findById(boardNo).isPresent()) {
			reviewBoardRepository.deleteById(boardNo);
		}
		
	}

	@Override
	public ReviewBoard findByUserId(String userId) {
		return reviewBoardRepository.findByUserId(userId);
	}

	@Override
	public List<ReviewBoard> findAll() {
		return reviewBoardRepository.findAll();
	}
	/*
	@Override
	public List<ReviewBoard> findByStarAll(Long star) {
		return reviewBoardRepository.findByStarUserId(star);
	}
	*/

	// userId로 리뷰 리스트 나오기
	/*
	@Override
	public List<ReviewBoard> findAllByUserIdUserinfo(String userId) {
		return reviewBoardRepository.findAllById(userId);
	}
	*/
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
	
}
