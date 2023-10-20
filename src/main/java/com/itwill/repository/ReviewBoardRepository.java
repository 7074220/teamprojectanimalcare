package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.entity.ReviewBoard;

public interface ReviewBoardRepository extends JpaRepository<ReviewBoard, Long> {

	List<ReviewBoard> findAllByUserinfoUserId(String userId);
	//@Query(value = "select * from review_board join userinfo u on u.user_id = :userId", nativeQuery = true)
	//public ReviewBoard findByUserId(@Param("userId") String userId);


	public List<ReviewBoard> findAllByOrderByBoardStarDesc(); // 높은 평점순 정렬

	public List<ReviewBoard> findAllByOrderByBoardStarAsc(); // 낮은 평점순 정렬

	List<ReviewBoard> getReviewBoardByProduct_ProductNo(Long productNo);
	// productNo로 reviewboard 리스트 검색

	// select * from review_board b join userinfo u on b.user_id = u.user_id ORDER
	// by board_star desc;
	// @Query(value = "", nativeQuery = true)
	 public List<ReviewBoard> findAllByBoardStar(Long star);
	// public List<ReviewBoard> findAllByUserIdUserinfo(String userId); // 선택된
	// userId 리뷰 리스트만 나오기

}