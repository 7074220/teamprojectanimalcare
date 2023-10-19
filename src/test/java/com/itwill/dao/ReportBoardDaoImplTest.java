package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;

class ReportBoardDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	ReportBoardDao reportBoardDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Test
	void test() {
		Userinfo userinfo = userInfoDao.findById("김");
		ReportBoard reportBoard = ReportBoard.builder()
									.boardNo(null)
									.boardContent("내용")
									.boardDate(null)
									.boardDepth(0)
									.boardGroupNo(1)
									.boardName("")
									.boardPhone(1111)
									.boardReadCount(0)
									.boardResisterDate(null)
									.boardStep(1)
									.boardTitle("제목")
									.userinfo(userinfo)
									.build();
									
		reportBoardDao.Create(reportBoard);
		
	}

}
