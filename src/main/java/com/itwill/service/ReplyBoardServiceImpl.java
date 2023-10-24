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
	public List<ReplyBoard> findByUserNo(Long userNo) {
		return replyBoardDao.findByUserNo(userNo);
	}

	@Override
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc() {
		return replyBoardDao.findAllByOrderByReplyBoardNoAsc();
	}

	@Override
	public void deleteByReplyBoardNo(Long ReplyBoardNo) {
		replyBoardDao.deleteByReplyBoardNo(ReplyBoardNo);
		
	}

	@Override
	public ReplyBoard findByReplyBoardNo(Long replyBoardNo) {
		
		return replyBoardDao.findByReplyBoardNo(replyBoardNo);
	}
	
	
}
