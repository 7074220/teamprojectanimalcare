package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.entity.ReviewBoard;

public interface ReviewBoardRepository extends JpaRepository<ReviewBoard, Long> {

	public List<ReviewBoard> findAllByOrderByBoardNoDesc(); // 최신순 정렬(board no정렬)

	public List<ReviewBoard> findAllByOrderByBoardNoAsc(); // 오래된순 정렬(board no정렬)

	public List<ReviewBoard> findAllByOrderByBoardStarDesc(); // 높은 평점순 정렬

	public List<ReviewBoard> findAllByOrderByBoardStarAsc(); // 낮은 평점순 정렬


	List<ReviewBoard> getReviewBoardByProduct_ProductNo(Long productNo);// productNo로 reviewboard 리스트 검색
	
	//public List<ReviewBoard> findByBoardStarOrderByBoardStarDescBoardNoDesc(Long star); //별점 높은순,최신순
	
	public List<ReviewBoard> findAllByBoardStar(Long star);
	
	List<ReviewBoard> findAllByUserinfoUserId(String userId); // 선택된 userId 리뷰 리스트만 나오기
	
	List<ReviewBoard> findAllByBoardStarDescAndBoardDateDesc();

}