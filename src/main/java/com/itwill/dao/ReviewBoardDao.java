package com.itwill.dao;

import java.util.List;

import com.itwill.entity.ReviewBoard;

public interface ReviewBoardDao {
	
	public ReviewBoard create(ReviewBoard reviewBoard);

	public ReviewBoard update(ReviewBoard reviewBoard);

	public void deleteById(Long boardNo);

	public ReviewBoard findByUserId(String userId);

	public List<ReviewBoard> findAll();

	public List<ReviewBoard> findByStarAll(Long star);
}
