package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.ReportBoardDao;
import com.itwill.entity.ReportBoard;

@Service
@Transactional
public class ReportBoardServiceImpl implements ReportBoardService{

	@Autowired
	private ReportBoardDao reportBoardDao;
	 
	@Override
	public ReportBoard Create(ReportBoard reportBoard) {
		return reportBoardDao.Create(reportBoard);
	}
	
	@Override
	public void deleteById(Long reportBoardNo) {
		reportBoardDao.deleteById(reportBoardNo);
		
	}

	@Override
	public ReportBoard update(ReportBoard reportBoard) {
		return reportBoardDao.update(reportBoard);
	}
	
	@Override
	public List<ReportBoard> findByUserId(String userId) {
		return reportBoardDao.findByUserId(userId);
	}

	@Override
	public List<ReportBoard> findAllByLikeUserId(String userId) {
		return reportBoardDao.findAllByLikeUserId(userId);
	}

	@Override
	public ReportBoard findByBoardNo(Long reportNo) {
		return reportBoardDao.findByBoardNo(reportNo);
	}

	@Override
	public void countReadCount(Long boardNo) {
		reportBoardDao.countReadCount(boardNo);
	}

	@Override
	public List<ReportBoard> findByUserNo(Long userNo) {
		return reportBoardDao.findByUserNo(userNo);
	}

	@Override
	public List<ReportBoard> findAll() {
		
		return reportBoardDao.findAll();
	}
	
	

}
