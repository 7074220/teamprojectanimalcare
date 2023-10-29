package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.ReportBoard;

public interface ReportBoardDao {
	
	public ReportBoard Create(ReportBoard reportBoard);
	
	public void deleteById(Long reportBoardNo);
	
	public ReportBoard update(ReportBoard reportBoard);
	
	//게시판 상세보기
	public ReportBoard findByBoardNo(Long reportNo);
	
	//사용자가 쓴 글 목록 
	public List<ReportBoard> findByUserId(String userId);
	
	//사용자 번호로 쓴글 목록 보기
	public List<ReportBoard> findByUserNo(Long userNo);

	
	//like 검색 기능 
	public List<ReportBoard> findAllByLikeUserId(String userId);
	
	//조회수 1증가
	public void countReadCount(Long boardNo);
	
	
	
}
