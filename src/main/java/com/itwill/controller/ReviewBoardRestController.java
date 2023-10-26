package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ReviewBoardDto;
import com.itwill.entity.ReviewBoard;
import com.itwill.service.ReviewBoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/reviewBoard")
public class ReviewBoardRestController {
	
	@Autowired
	private ReviewBoardService reviewBoardService;
	
	/*
	@Operation(summary = "리뷰작성")
	@PostMapping
	public ResponseEntity<ReviewBoardDto> createReviewBoard(@RequestBody ReviewBoardDto dto, HttpSession httpSession) throws Exception{
		ReviewBoard reviewBoardEntity = ReviewBoardDto.toEntity(dto);
		reviewBoardService.create(reviewBoardEntity);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));				
		
		return new ResponseEntity<>(dto, httpHeaders, HttpStatus.CREATED);
	}
	*/
	
	
	
	
	
	
	
	/*
	@GetMapping("/{boardNo}")
	public ResponseEntity<ReviewBoard> findByBoardNo(@PathVariable Long boardNo) {
		ReviewBoard reviewBoard = reviewBoardService.findByBoardNo(boardNo);
		if(reviewBoard != null) {
			// ReviewBoard no 가 존재하면 ok 와 함께 반환
			return ResponseEntity.ok(reviewBoard);
		} else {
			// ReviewBoard no 가 존재하지 않으면 notFound() 반환
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{boardNo}")
	public ResponseEntity<ReviewBoard> updateReviewBoard(@PathVariable Long boardNo, @RequestBody ReviewBoard updatedReviewBoard) throws Exception {		
		ReviewBoard existingReviewBoard = reviewBoardService.findByBoardNo(boardNo);		
		if (existingReviewBoard == null) {
			// boardNo 가 존재하지 않으면 notFound() 반환
	        return ResponseEntity.notFound().build();
	    }		
		// boardNo 가 존재하면 업데이트 적용 후 저장
	    existingReviewBoard.setBoardTitle(updatedReviewBoard.getBoardTitle());
	    existingReviewBoard.setBoardContent(updatedReviewBoard.getBoardContent());
	    existingReviewBoard.setBoardStar(updatedReviewBoard.getBoardStar());
	    ReviewBoard updatedBoard = reviewBoardService.update(existingReviewBoard);	    
	    return ResponseEntity.ok(updatedBoard);
	} 

	@DeleteMapping("/{no}")
	public ResponseEntity<Map> deleteReviewBoard(@PathVariable(name = "no") Long boardNo) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> findAll() {
		// 전체 조회
		List<ReviewBoard> reviewBoardList = reviewBoardService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardList);
	}
	
	@GetMapping("/{productNo}")
	public ResponseEntity<List<ReviewBoard>> findByProductNo(@PathVariable Long productNo) {
		// productNo로 reviewboard 리스트 검색
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findByProductNo(productNo));
	}
	
	@GetMapping("/{star}")
	public ResponseEntity<List<ReviewBoard>> findByStarAll(@PathVariable Long star) {
		// 선택한 별점으로 찾기
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findByStarAll(star));
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<List<ReviewBoard>> findByUserNo(@PathVariable Long no) {
		// 선택된 userNo 리뷰 리스트만 나오기
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findByUserNo(no));
	}
	 
	
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> findAllByOrderByBoardStarDesc() {
		// 높은 평점순 정렬
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findAllByOrderByBoardStarDesc());
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> findAllByOrderByBoardStarAsc() {
		// 낮은 평점순 정렬
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findAllByOrderByBoardStarAsc());		
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> findAllByOrderByBoardDateDesc() {
		// 최신순 정렬(board Date정렬)
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findAllByOrderByBoardDateDesc());
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> findAllByOrderByBoardDateAsc() {
		// 오래된 순 정렬(board Date정렬)
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findAllByOrderByBoardDateAsc());
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> findByOrderByBoardStarDescBoardDateDesc() {
		// 별점 높은순,최신순
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findByOrderByBoardStarDescBoardDateDesc());
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewBoard>> findByOrderByBoardStarAscBoardDateDesc() {
		// 별점 낮은순,최신순
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardService.findByOrderByBoardStarAscBoardDateDesc());
	}
	*/
	
}
