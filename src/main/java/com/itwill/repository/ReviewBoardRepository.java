package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.ReviewBoard;


public interface ReviewBoardRepository extends JpaRepository<ReviewBoard, Long>{
	
	@Query(value = "select * from review_board join userinfo u on u.user_id = ?1",nativeQuery = true)
	public ReviewBoard findByUserId(String userId);
}
