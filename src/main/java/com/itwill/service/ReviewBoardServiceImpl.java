package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.AdoptDao;
import com.itwill.dao.ReviewBoardDao;
import com.itwill.entity.Adopt;
import com.itwill.entity.ReviewBoard;
import com.itwill.repository.ReviewBoardRepository;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService {

	@Autowired
	private ReviewBoardDao reviewBoardDao;

	@Autowired
	ReviewBoardRepository reviewBoardRepository;

	@Override
	public ReviewBoard create(ReviewBoard reviewBoard) {

		return reviewBoardRepository.save(reviewBoard);
	}

	@Override
	public ReviewBoard update(ReviewBoard reviewBoard) {
		if (reviewBoardRepository.findById(reviewBoard.getBoardNo()).isPresent()) {
			reviewBoardRepository.save(reviewBoard);
		}
		return reviewBoard;
	}

	@Override
	public void deleteById(Long boardNo) {
		if (reviewBoardRepository.findById(boardNo).isPresent()) {
			reviewBoardRepository.deleteById(boardNo);
		}

	}

	@Override
	public List<ReviewBoard> findAll() {

		return reviewBoardRepository.findAll();
	}

	@Override
	public List<ReviewBoard> getReviewBoardByProductNo(Long productNo) {
		// productNo로 reviewboard 리스트 검색
		return reviewBoardRepository.getReviewBoardByProduct_ProductNo(productNo);
	}

	@Override
	public List<ReviewBoard> findByStarAll(Long star) {
		// 선택한 별점으로 찾기
		return reviewBoardRepository.findAllByBoardStar(star);
	}

	@Override
	public List<ReviewBoard> findByUserNo(Long no) {
		// 선택된 userId 리뷰 리스트만 나오기
		return reviewBoardRepository.findByUserNo(no);
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardStarDesc() {
		// 높은 평점순 정렬
		return reviewBoardRepository.findAllByOrderByBoardStarDesc();
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardStarAsc() {
		// 낮은 평점순 정렬
		return reviewBoardRepository.findAllByOrderByBoardStarAsc();
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardDateDesc() {
		// 최신순 정렬(board Date정렬)
		return reviewBoardRepository.findAllByOrderByBoardDateDesc();
	}

	@Override
	public List<ReviewBoard> findAllByOrderByBoardDateAsc() {
		// 오래된 순 정렬(board Date정렬)
		return reviewBoardRepository.findAllByOrderByBoardDateAsc();
	}

	@Override
	public List<ReviewBoard> findByOrderByBoardStarDescBoardDateDesc() {
		// 별점 높은순,최신순
		return reviewBoardRepository.findByOrderByBoardStarDescBoardDateDesc();
	}

	@Override
	public List<ReviewBoard> findByOrderByBoardStarAscBoardDateDesc() {
		// 별점 낮은순,최신순
		return reviewBoardRepository.findByOrderByBoardStarAscBoardDateDesc();
	}

	@Override
	public ReviewBoard findByBoardNo(Long BoardNo) {
		return reviewBoardRepository.findById(BoardNo).get();
	}
}
