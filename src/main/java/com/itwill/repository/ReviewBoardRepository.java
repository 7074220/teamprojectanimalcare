package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.ReviewBoard;


public interface ReviewBoardRepository extends JpaRepository<ReviewBoard, Long>{
	
	@Query(value = "select * from review_board join userinfo u on u.user_id = ?1",nativeQuery = true)
	public ReviewBoard findByUserId(String userId);
	
	//select * from review_board b join userinfo u on b.user_id = u.user_id ORDER by board_star desc;
	//@Query(value = "", nativeQuery = true)
	//public List<ReviewBoard> findByStarUserId(Long star);
	
	
}