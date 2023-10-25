package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;
@WebAppConfiguration
class ReplyBoardDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	ReplyBoardDao replyBoardDao;
	
	@Autowired
	ReportBoardDao reportBoardDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void test() {
		Userinfo userinfo = userInfoDao.findByNo(2L);
		ReportBoard reportBoard = reportBoardDao.findByBoardNo(1L);
		ReplyBoard replyBoard = ReplyBoard.builder()
										.ReplyBoardContent("내용")
										.ReplyBoardDepth(0)
										.ReplyBoardGroupNo(1)
										.ReplyBoardRegisterDate(new Date())
										.ReplyBoardStep(1)
										.userinfo(userinfo)
										.reportBoard(reportBoard)
										.build();
		
		replyBoardDao.Create(replyBoard);
	}
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void test1() {
		replyBoardDao.deleteByReplyBoardNo(1L);
	}
	
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void test2() {
	List<ReplyBoard> boards=replyBoardDao.findAllByOrderByReplyBoardNoAsc();
	System.out.println(boards);
	
	}
	
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void test3() {
			
	List<ReplyBoard> boards=	replyBoardDao.findByUserNo(2L);
	System.out.println(boards);
		
	}
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void test4() {
		
	ReplyBoard  replyBoard=replyBoardDao.findByReplyBoardNo(5L);
	replyBoard.setReplyBoardContent("아리가또");
	System.out.println(replyBoard);
	
	}
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void test5() {
		
		ReplyBoard  replyBoard=replyBoardDao.findByReplyBoardNo(5L);
		replyBoard.setReplyBoardContent("아리가또");
		System.out.println(replyBoard);
		
	}
	
	@Transactional
	@Rollback(false)
	//@Disabled
	@Test
	void test6() {
		Userinfo userinfo = userInfoDao.findByNo(5L);
		ReportBoard reportBoard = reportBoardDao.findByBoardNo(1L);
		ReplyBoard replyBoard=ReplyBoard.builder()
										.ReplyBoardContent("하하1")
										.userinfo(userinfo)
										.reportBoard(reportBoard)
										.build();
		
		replyBoardDao.Create(replyBoard);
	}
	
	@Transactional
	@Rollback(false)
	//@Disabled
	@Test
	void test7() {
		ReplyBoard replyBoard=replyBoardDao.findByReplyBoardNo(5L);
		System.out.println(replyBoard);
	
	}
	

}
