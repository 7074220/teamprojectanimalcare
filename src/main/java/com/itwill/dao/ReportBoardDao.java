package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.ReportBoard;

public interface ReportBoardDao {
	
	public ReportBoard Create(ReportBoard reportBoard);
	
	public void deleteById(Long reportBoard_no);
	
	public ReportBoard update(ReportBoard reportBoard);
	
	public ReportBoard findByUserId(String userid);
	
	public List<ReportBoard> findAllByLikeUserId(String userId);
	
}
