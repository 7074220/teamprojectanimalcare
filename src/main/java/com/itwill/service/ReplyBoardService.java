package com.itwill.service;

import java.util.List;

import com.itwill.entity.ReplyBoard;

public interface ReplyBoardService {

	public ReplyBoard Create(ReplyBoard replyBoard);

	public ReplyBoard update(ReplyBoard replyBoard);

	public List<ReplyBoard> findByUserNo(Long userNo);

	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();

	// 댓글 삭제
	public void deleteByReplyBoardNo(Long ReplyBoardNo);
	
	//댓글 하나 찾기 
	public ReplyBoard findByReplyBoardNo(Long replyBoardNo);
}
