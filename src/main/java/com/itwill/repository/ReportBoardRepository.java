package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;

public interface ReportBoardRepository extends JpaRepository<ReportBoard, Long>{
	
}
