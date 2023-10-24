package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.Product;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;

public interface ReplyBoardDao {
	
	// 댓글 작성
	public ReplyBoard Create(ReplyBoard replyBoard);
	
	// 댓글 하나 선택
	public ReplyBoard findByReplyBoardNo(Long replyBoardNo);
	
	// 댓글 삭제
	public void deleteByReplyBoardNo(Long replyBoardNo);
	
	// 대댓글 작성
	public ReplyBoard CreateReply(ReplyBoard replyBoard);
	
	// 댓글 수정 근데 굳이 필요가 없는거같음 메소드.
	public ReplyBoard update(ReplyBoard replyBoard);
	
	//작성자가 쓴 글 목록 
	public List<ReplyBoard> findByUserNo(Long userNo);
	
	// 오래된 순서
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();
	
}
