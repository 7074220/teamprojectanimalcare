package com.itwill.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;

public interface ReportBoardRepository extends JpaRepository<ReportBoard, Long>{
	
	@Query(value="select * from report_board join userinfo u on u.user_id = ?1",nativeQuery = true)
	public ReportBoard findByUserId(String userId);
	
	@Query(value="select * from report_board where user_id like '%'|| ?1 || '%'",nativeQuery = true)
	public List<ReportBoard> findAllByLikeUserId(String userId);
	
}
