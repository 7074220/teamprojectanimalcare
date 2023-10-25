package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.ReplyBoard;

class ReplyBoardServiceImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	private ReplyBoardService replyBoardService;
	
	@Transactional
	@Rollback(false)
	//@Disabled
	@Test
	void insert() {
		ReplyBoard replyBoard = ReplyBoard.builder()
								.ReplyBoardContent("내용")
								.ReplyBoardDepth(null)
								.ReplyBoardGroupNo(null)
								.ReplyBoardRegisterDate(null)
								.ReplyBoardStep(null)
								.userinfo(null)
								.reportBoard(null)
								.build();
		
		replyBoardService.Create(null);
	}

}
