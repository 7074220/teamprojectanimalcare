package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.ReplyBoardDao;
import com.itwill.entity.ReplyBoard;

@Service
@Transactional
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
	public void deleteByReplyBoardStepBoardDepthBoardGroupNo(Integer ReplyBoardStep, Integer ReplyBoardDepth,
			Integer ReplyBoardGroupNo) {
		replyBoardDao.deleteByReplyBoardStepBoardDepthBoardGroupNo(ReplyBoardStep, ReplyBoardDepth, ReplyBoardGroupNo);
	}
	
	@Override
	public ReplyBoard findByReplyBoardNo(Long replyBoardNo) {
		return replyBoardDao.findByReplyBoardNo(replyBoardNo);
	}
	
	@Override
	public ReplyBoard CreateReply(ReplyBoard replyBoard) {
		return replyBoardDao.CreateReply(replyBoard);
	}
	
}
