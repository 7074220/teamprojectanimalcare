package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;

public interface ReplyBoardDao {
	
	// 댓글 작성
	public ReplyBoard Create(ReplyBoard replyBoard);
	
	// 대댓글 작성
	public ReplyBoard CreateReply(ReplyBoard replyBoard);
	
	// 작성자 비교후 삭제
	public void deleteByUserId(String userId);
	
	// 댓글 삭제
	public void deleteByReplyBoardNo(Long ReplyBoardNo);
	
	
	// 댓글 수정
	public ReplyBoard update(ReplyBoard replyBoard);
	
	//작성자가 쓴 글 목록 
	public List<ReplyBoard> findByUserId(String userId);
	
	// 오래된 순서
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();
	
}
