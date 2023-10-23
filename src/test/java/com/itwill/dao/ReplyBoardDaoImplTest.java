package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.Userinfo;

class ReplyBoardDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	ReplyBoardDao replyBoardDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	//@Transactional
	//@Rollback(false)
	//@Disabled
	@Test
	void test() {
		Userinfo userinfo = userInfoDao.findById("김창섭");
		ReplyBoard replyBoard = ReplyBoard.builder()
										.ReplyBoardContent("내용")
										.ReplyBoardDepth(0)
										.ReplyBoardGroupNo(1)
										.ReplyBoardResisterDate(new Date())
										.ReplyBoardStep(1)
										.userinfo(userinfo)
										.build();
		
		replyBoardDao.Create(replyBoard);
	}
	
	//@Transactional
	//@Rollback(false)
	@Disabled
	@Test
	void test1() {
	
		replyBoardDao.deleteByUserId("김창섭");
	}
	
	

}
