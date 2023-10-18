package com.itwill.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.entity.ReportBoard;
import com.itwill.repository.ReportBoardRepository;

public class ReportBoardDaoImpl implements ReportBoardDao{
	
	@Autowired
	ReportBoardRepository reportBoardRepository;
	
	@Override
	public ReportBoard Create(ReportBoard reportBoard) {
		
		return null;
	}
	
}
