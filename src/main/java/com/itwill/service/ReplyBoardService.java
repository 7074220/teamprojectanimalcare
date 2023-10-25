package com.itwill.service;

import java.util.List;

import com.itwill.entity.ReplyBoard;

public interface ReplyBoardService {

	public ReplyBoard Create(ReplyBoard replyBoard);

	public ReplyBoard update(ReplyBoard replyBoard);

	public List<ReplyBoard> findByUserNo(Long userNo);

	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();

	// 댓글 삭제
	public void deleteByReplyBoardStepBoardDepthBoardGroupNo(Integer ReplyBoardStep,Integer ReplyBoardDepth,Integer ReplyBoardGroupNo);
	
	//댓글 하나 찾기 
	public ReplyBoard findByReplyBoardNo(Long replyBoardNo);
	
	// 대댓글 작성
	public ReplyBoard CreateReply(ReplyBoard replyBoard);
	
	//해당 게시물의 댓글 보여주기 
	public List<ReplyBoard> findAllByReportBoardNo(Long BoardNo);
	
	
}
