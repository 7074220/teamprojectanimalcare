package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;
import com.itwill.repository.ReplyBoardRepository;
import com.itwill.repository.ReportBoardRepository;
import com.itwill.repository.UserinfoRepository;

@Repository
public class ReplyBoardDaoImpl implements ReplyBoardDao{
	
	@Autowired
	ReplyBoardRepository replyBoardRepository;
	
	@Autowired
	UserinfoRepository userinfoRepository;

	//댓글 작성
	@Override
	public ReplyBoard Create(ReplyBoard replyBoard) {
		return replyBoardRepository.Create(replyBoard);
	}

	//대댓글 작성
	@Override
	public ReplyBoard CreateReply(ReplyBoard replyBoard) {
		Long No = replyBoard.getReplyBoardNo();
		ReplyBoard board = ReplyBoard.builder()
					.ReplyBoardNo(No)
					.ReplyBoardDepth(replyBoard.getReplyBoardDepth()+1)
					.ReplyBoardStep(replyBoard.getReplyBoardStep()+1)
					.build();
		return replyBoardRepository.save(board);
	}
	


	@Override
	public ReplyBoard update(ReplyBoard replyBoard) {
		return replyBoardRepository.save(replyBoard);
	}
	
	@Override
	public List<ReplyBoard> findByUserNo(Long userNo) {
		return replyBoardRepository.findByUserNo(userNo);
	}
	
	
	
	@Override
	public List<ReplyBoard> findAllByOrderByReplyBoardNoAsc() {
		return replyBoardRepository.findAllByOrderByReplyBoardNoAsc();
	}

	@Override
	public void deleteByReplyBoardNo(Long ReplyBoardNo) {
		replyBoardRepository.deleteById(ReplyBoardNo);
		
	}

	@Override
	public ReplyBoard findByReplyBoardNo(Long replyBoardNo) {
		// TODO Auto-generated method stub
		return replyBoardRepository.findById(replyBoardNo).get();
	}
	
}


