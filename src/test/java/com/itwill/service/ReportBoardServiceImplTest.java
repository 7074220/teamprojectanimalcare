package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.dao.ReportBoardDao;
import com.itwill.dao.UserInfoDao;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;

class ReportBoardServiceImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	ReportBoardService reportBoardService;
	
	@Autowired
	ReportBoardDao reportBoardDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void test() {
		Userinfo userinfo = userInfoDao.findById("전아현");
		ReportBoard reportBoard = ReportBoard.builder()
									.boardContent("내용")
									.boardDate(null)
									.boardDepth(0)
									.boardGroupNo(1)
									.boardName(userinfo.getUserId())
									.boardPhone(userinfo.getUserPhoneNumber())
									.boardReadCount(0)
									.boardResisterDate(null)
									.boardStep(0)
									.boardTitle("제목")
									.userinfo(userinfo)
									.build();
		reportBoardService.Create(reportBoard);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test2() {
		reportBoardDao.deleteById(10L);
	}

}
