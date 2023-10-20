package com.itwill.service;

import java.util.List;

import com.itwill.entity.ReviewBoard;

public interface ReviewBoardService {
	public ReviewBoard create(ReviewBoard reviewBoard);

	public ReviewBoard update(ReviewBoard reviewBoard);

	public void delete(Long boardNo);

	public ReviewBoard findByUserId(String userId);

	public List<ReviewBoard> findAll();

	//public List<ReviewBoard> findByStarAll(Long star);
}
