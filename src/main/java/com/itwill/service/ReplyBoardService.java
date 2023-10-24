package com.itwill.service;

import java.util.List;

import com.itwill.entity.ReplyBoard;

public interface ReplyBoardService {

	public ReplyBoard Create(ReplyBoard replyBoard);

	public ReplyBoard update(ReplyBoard replyBoard);

	public List<ReplyBoard> findByUserId(String userId);

	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc();

	// 댓글 삭제
	public void deleteByReplyBoardNo(Long ReplyBoardNo);
}
