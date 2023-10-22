package com.itwill.service;

import java.util.List;

import com.itwill.entity.ReplyBoard;


public interface ReplyBoardService {
	
	public ReplyBoard Create(ReplyBoard replyBoard);
	
	public void deleteByUserId(String userId);
	
	public ReplyBoard update(ReplyBoard replyBoard);
	
	public List<ReplyBoard> findByUserId(String userId);
	
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();
	
}
