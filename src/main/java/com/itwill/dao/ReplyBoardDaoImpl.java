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
		return replyBoardRepository.save(replyBoard);
	}

	//대댓글 작성
	@Override
	public ReplyBoard CreateReply(ReplyBoard replyBoard) {
		// 해당 그룹의 최대 스텝 수
		Integer maxStep = replyBoardRepository.findGreatestStepByGroupNo(replyBoard.getReplyBoardGroupNo());
		ReplyBoard board = ReplyBoard.builder()
					.ReplyBoardGroupNo(replyBoard.getReplyBoardGroupNo())
					.ReplyBoardDepth(replyBoard.getReplyBoardDepth()+1)
					.ReplyBoardStep(maxStep+1)
					.build();
		
		/*
		그룹1번의 제일 마지막 스텝이 몇번인지????
		
		첫번째 : 그룹 1번 스텝1
			두번째 그룹 1번 스텝2 뎁스1
			세번째 그룹 1번 스텝3 뎁스1
		*/
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
	public void deleteByReplyBoardStepBoardDepthBoardGroupNo(Integer ReplyBoardStep,Integer ReplyBoardDepth,Integer ReplyBoardGroupNo) {
		replyBoardRepository.deleteByReplyBoardStepBoardDepthBoardGroupNo(ReplyBoardStep, ReplyBoardDepth, ReplyBoardGroupNo);
	}

	@Override
	public ReplyBoard findByReplyBoardNo(Long replyBoardNo) {
		return replyBoardRepository.findById(replyBoardNo).get();
	}
	
	@Override
	public Integer findGreatestStepByGroupNo(Integer ReplyBoardGroupNo) {
		return replyBoardRepository.findGreatestStepByGroupNo(ReplyBoardGroupNo);
	}
	
}


