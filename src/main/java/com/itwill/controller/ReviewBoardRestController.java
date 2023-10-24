package com.itwill.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.entity.ReviewBoard;
import com.itwill.service.ReviewBoardService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ReviewBoard")
public class ReviewBoardRestController {
	
	@Autowired
	private ReviewBoardService reviewBoardService;
	
	
	// public ReviewBoard create(ReviewBoard reviewBoard); // reviewBoard 작성
	@PostMapping
	public ResponseEntity<ReviewBoard> createReviewBoard(@RequestBody ReviewBoard reviewBoard) {
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewBoardService.create(reviewBoard));
	}
	
	/*
	// public ReviewBoard findByBoardNo(Long BoardNo);
	@GetMapping("/{no}")
	public ResponseEntity<ReviewBoard> getBoardByNo(@PathVariable(name = "no") Long boardNo) {
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findByBoardNo(boardNo));
	}
	*/
	
	
	
	
	
	
	
	// public ReviewBoard update(ReviewBoard reviewBoard);
	@PutMapping
	public ResponseEntity<ReviewBoard> updateReviewBoard(@RequestBody ReviewBoard reviewBoard) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.update(reviewBoard));
	}
	
	// public void deleteById(Long boardNo);
	@DeleteMapping("/{no}")
	public ResponseEntity<Map> deleteReviewBoard(@PathVariable(name = "no") Long boardNo) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	}
	
	// public List<ReviewBoard> findAll();
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> getRevoewBoardList() {
		List<ReviewBoard> reviewBoardList = reviewBoardService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardList);
	}
	
	// List<ReviewBoard> findByProductNo(Long productNo); // productNo로 reviewboard 리스트 검색
	public ResponseEntity<List<ReviewBoard>> getFindByProductNo(@PathVariable(name = "no") Long productNo) {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
