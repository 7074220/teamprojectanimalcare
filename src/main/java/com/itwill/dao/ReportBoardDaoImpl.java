package com.itwill.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.ReportBoard;
import com.itwill.repository.ReportBoardRepository;

@Repository
public class ReportBoardDaoImpl implements ReportBoardDao{
	
	@Autowired
	ReportBoardRepository reportBoardRepository;
	
	@Override
	public ReportBoard Create(ReportBoard reportBoard) {
		return reportBoardRepository.save(reportBoard);
	}
	
	@Override
	public void deleteById(Long reportBoard_no) {
		if(reportBoardRepository.findById(reportBoard_no).isPresent()) {
			reportBoardRepository.deleteById(reportBoard_no);
		}	
	}
	
	@Override
	public ReportBoard update(ReportBoard reportBoard) {
		if(reportBoardRepository.findById(reportBoard.getBoardNo()).isPresent()) {
			reportBoardRepository.save(reportBoard);
		}
		return reportBoard;
	}
	
	@Override
	public ReportBoard findByUserId(String userid) {
		return reportBoardRepository.findByUserId(userid);
	}
	
}
