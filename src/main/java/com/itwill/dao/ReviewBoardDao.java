package com.itwill.dao;

import java.util.List;

import com.itwill.entity.ReviewBoard;

public interface ReviewBoardDao {
	
	public ReviewBoard create(ReviewBoard reviewBoard);

	public ReviewBoard update(ReviewBoard reviewBoard);

	public void deleteById(Long boardNo);

	public ReviewBoard findByUserId(String userId);

	public List<ReviewBoard> findAll();

	//public List<ReviewBoard> findByStarAll(Long star); // 선택한 평점과 관련된 리뷰나오기

	public List<ReviewBoard> findByUserinfoUserId(String userId); // 선택된 userId 리뷰 리스트만 나오기
	
	public List<ReviewBoard> findAllByOrderByReviewStarAvgDesc(); // 낮은 평점순 정렬
	
	public List<ReviewBoard> findAllByOrderByReviewStarAvgAsc(); // 높은 평점순 정렬
	
	

}
