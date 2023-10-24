package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.dao.ReplyBoardDao;
import com.itwill.entity.ReplyBoard;

public class ReplyBoardServiceImpl implements ReplyBoardService{

	@Autowired
	private ReplyBoardDao replyBoardDao;
	
	
	@Override
	public ReplyBoard Create(ReplyBoard replyBoard) {
		return replyBoardDao.Create(replyBoard);
	}	

	@Override
	public ReplyBoard update(ReplyBoard replyBoard) {
		return replyBoardDao.update(replyBoard);
	}

	@Override
	public List<ReplyBoard> findByUserId(String userId) {
		return replyBoardDao.findByUserId(userId);
	}

	@Override
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc() {
		return replyBoardDao.findAllByOrderByReplyBoardNoAsc();
	}

	@Override
	public void deleteByReplyBoardNo(Long ReplyBoardNo) {
		replyBoardDao.deleteByReplyBoardNo(ReplyBoardNo);
		
	}
	
	
}
