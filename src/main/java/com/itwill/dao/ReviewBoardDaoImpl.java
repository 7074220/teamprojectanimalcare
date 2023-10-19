package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.entity.ReviewBoard;
import com.itwill.repository.ReviewBoardRepository;

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

	@Override
	public List<ReviewBoard> findByStarAll(Long star) {
		return null;
	}

	
}
