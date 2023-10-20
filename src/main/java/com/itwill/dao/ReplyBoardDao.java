package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;

public interface ReplyBoardDao {
	
	// 댓글 작성
	public ReplyBoard Create(ReplyBoard replyBoard);
	
	// 작성자 비교후 삭제
	public void deleteByWriter(String writer);
	
	// 댓글 수정
	public ReplyBoard update(String writer);
	
	//작성자가 쓴 글 목록 
	public List<ReplyBoard> findByWriter(String writer);
	
	//like 검색 기능 
	public List<ReplyBoard> findAllByLikeWriter(String writer);
	
}
