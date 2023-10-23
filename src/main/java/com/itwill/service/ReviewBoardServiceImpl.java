package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.ReviewBoardDao;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReviewBoard;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardDao {
	
	@Autowired
	private ReviewBoardDao reviewBoardDao;

	@Override
	public ReviewBoard create(ReviewBoard reviewBoard) {
		ReviewBoard createReviewBoard = reviewBoardDao.create(reviewBoard);
		return createReviewBoard;
	}

	@Override
	public ReviewBoard update(ReviewBoard reviewBoard) {
		ReviewBoard updateReviewBoard = reviewBoardDao.update(reviewBoard);
		return updateReviewBoard;
	}

	@Override
	public void deleteById(Long boardNo) {
		reviewBoardDao.deleteById(boardNo);
		
	}

	@Override
	public List<ReviewBoard> findAll() {
		List<ReviewBoard> reviewBoardList = reviewBoardDao.findAll();
		return reviewBoardList;
	}

	@Override
	public List<ReviewBoard> getReviewBoardByProductNo(Long productNo) {
		List<ReviewBoard> getReviewBoardByProductNo = 
				reviewBoardDao.getReviewBoardByProductNo(productNo);
		return getReviewBoardByProductNo;
	}

	@Override
	public List<ReviewBoard> findByStarAll(Long star) {
		List<ReviewBoard> findByStarAll = 
				reviewBoardDao.findByStarAll(star);
		return findByStarAll;
	}

	@Override
	public List<ReviewBoard> findByUserNo(Long no) {
		List<ReviewBoard> findByUserNo = 
				reviewBoardDao.findByUserNo(no);
		return findByUserNo;
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardStarDesc() {
		List<ReviewBoard> findAllByOrderByBoardStarDesc = 
				reviewBoardDao.findAllByOrderByBoardStarDesc();
		return findAllByOrderByBoardStarDesc;
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardStarAsc() {
		List<ReviewBoard> findAllByOrderByBoardStarAsc = 
				reviewBoardDao.findAllByOrderByBoardStarAsc();
		return findAllByOrderByBoardStarAsc;
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardNoDesc() {
		List<ReviewBoard> findAllByOrderByBoardNoDesc = 
				reviewBoardDao.findAllByOrderByBoardNoDesc();
		return findAllByOrderByBoardNoDesc;
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardNoAsc() {
		List<ReviewBoard> findAllByOrderByBoardNoAsc = 
				reviewBoardDao.findAllByOrderByBoardNoAsc();
		return findAllByOrderByBoardNoAsc;
	}

	@Override
	public List<ReviewBoard> findByBoardStarOrderByBoardStarDescBoardDateDesc(Long star) {
		List<ReviewBoard> findByBoardStarOrderByBoardStarDescBoardDateDesc = 
				reviewBoardDao.findByBoardStarOrderByBoardStarDescBoardDateDesc(star);
		return findByBoardStarOrderByBoardStarDescBoardDateDesc;
	}

	
	


}
