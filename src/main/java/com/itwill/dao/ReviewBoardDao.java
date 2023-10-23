package com.itwill.dao;

import java.util.List;

import com.itwill.entity.ReviewBoard;

public interface ReviewBoardDao {

	public ReviewBoard create(ReviewBoard reviewBoard);

	public ReviewBoard update(ReviewBoard reviewBoard);

	public void deleteById(Long boardNo);

	public List<ReviewBoard> findAll();

	List<ReviewBoard> getReviewBoardByProductNo(Long productNo); // productNo로 reviewboard 리스트 검색

	public List<ReviewBoard> findByStarAll(Long star); //선택한 별점으로 찾기

	public List<ReviewBoard> findByUserNo(Long no); // 선택된 userId 리뷰 리스트만 나오기

	public List<ReviewBoard> findAllByOrderByBoardStarDesc(); // 높은 평점순 정렬

	public List<ReviewBoard> findAllByOrderByBoardStarAsc(); // 낮은 평점순 정렬

	public List<ReviewBoard> findAllByOrderByBoardNoDesc(); // 최신순 정렬(board no정렬)
	
	public List<ReviewBoard> findAllByOrderByBoardNoAsc(); // 오래된 순 정렬(board no정렬)
	
	public List<ReviewBoard> findByBoardStarOrderByBoardStarDescBoardDateDesc(Long star);//별점 높은순,최신순
	
	
}		