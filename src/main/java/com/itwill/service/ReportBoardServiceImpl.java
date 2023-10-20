package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.ReportBoardDao;
import com.itwill.entity.ReportBoard;

@Service
public class ReportBoardServiceImpl implements ReportBoardService{

	@Autowired
	ReportBoardDao reportBoardDao;
	 
	@Override
	public ReportBoard Create(ReportBoard repordBoard) {
		
		return reportBoardDao.Create(repordBoard);
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
	public Integer countReadCount(Long boardNo) {
		
		return reportBoardDao.countReadCount(boardNo);
	}

}
