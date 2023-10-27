package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ReviewBoardDto;
import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Product;
import com.itwill.entity.ReviewBoard;
import com.itwill.service.ReviewBoardService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/reviewBoard")
public class ReviewBoardRestController {
	
	@Autowired
	private ReviewBoardService reviewBoardService;
	
	@Operation(summary = "리뷰작성")
	@PostMapping
	public ResponseEntity<ReviewBoardDto> createReviewBoard(@RequestBody ReviewBoardDto dto, HttpSession httpSession) throws Exception {
	    ReviewBoard reviewBoardEntity = ReviewBoardDto.toEntity(dto);
	    reviewBoardService.create(reviewBoardEntity);
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    return new ResponseEntity<>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "boardNo로 리뷰 보기")
	@GetMapping("/board/{boardNo}")
	public ResponseEntity<ReviewBoardDto> findByBoardNo(@PathVariable(value = "boardNo") Long boardNo, HttpSession httpSession) throws Exception {    
	    ReviewBoard reviewBoard = reviewBoardService.findByBoardNo(boardNo);

	    if (reviewBoard == null) {
	        // ReviewBoard가 없을 때 NOT_FOUND 상태 반환
	        return ResponseEntity.notFound().build();
	    } else {
	        ReviewBoardDto reviewBoardDto = ReviewBoardDto.toDto(reviewBoard);
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));    
	        return new ResponseEntity<>(reviewBoardDto, httpHeaders, HttpStatus.OK);
	    }
	
	
	}
	@Operation(summary = "no로 review 삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<Map> deleteReviewBoard(@PathVariable(value = "no") Long boardNo) throws Exception {
		reviewBoardService.deleteById(boardNo);
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	}
	
	@Operation(summary = "reviewList 전체 조회")
	@GetMapping
	public ResponseEntity<List<ReviewBoardDto>> findAll() {
		// 전체 조회
		
		List<ReviewBoard> reviewBoardList = reviewBoardService.findAll();
		List<ReviewBoardDto> reviewBoardDtoList = new ArrayList<>();
		for (ReviewBoard reviewBoard : reviewBoardList) {
			ReviewBoardDto reviewBoardDto = ReviewBoardDto.toDto(reviewBoard);
			reviewBoardDtoList.add(reviewBoardDto);
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<>(reviewBoardDtoList, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "productNo로 reviewList 조회")
	@GetMapping("/product/{productNo}")
	public ResponseEntity<List<ReviewBoardDto>> findByProductNo(@PathVariable(value = "productNo") Long productNo) {
		// productNo로 reviewboard 리스트 검색
		List<ReviewBoard> findReview=reviewBoardService.findByProductNo(productNo);
		if(findReview.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
		}
		List<ReviewBoardDto> reviewDtoList = new ArrayList<>();
		for (ReviewBoard reviewBoard : findReview) {
			ReviewBoardDto boardDto=ReviewBoardDto.toDto(reviewBoard);
			reviewDtoList.add(boardDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(reviewDtoList);
	}
	
	@Operation(summary = "별점으로 review 찾기")
	@GetMapping("/{boardStar}")
	public ResponseEntity<List<ReviewBoardDto>> findByStarAll(@PathVariable(value = "boardStar") Long star) {
		// 선택한 별점으로 찾기
		List<ReviewBoard> reviewBoardList = reviewBoardService.findByStarAll(star);
		if(reviewBoardList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
		}
		List<ReviewBoardDto> reviewBoardDtoList =  new ArrayList<>();		
		
		for (ReviewBoard reviewBoard : reviewBoardList) {
			ReviewBoardDto reviewBoardDto = ReviewBoardDto.toDto(reviewBoard);
			reviewBoardDtoList.add(reviewBoardDto);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardDtoList);
	}
	
	@Operation(summary = "userNo로 리뷰리스트 조회")
	@GetMapping("/user/{userNo}")
	public ResponseEntity<List<ReviewBoardDto>> findByUserNo(@PathVariable(value = "userNo") Long userNo) {
		// 선택된 userNo 리뷰 리스트만 나오기
		List<ReviewBoard> reviewBoards=reviewBoardService.findByUserNo(userNo);
		if(reviewBoards.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
		}
		List<ReviewBoardDto> reviewBoardDtoList = new ArrayList<>();
		
		for (ReviewBoard reviewBoard : reviewBoards) {
			ReviewBoardDto reviewBoardDto = ReviewBoardDto.toDto(reviewBoard);
			reviewBoardDtoList.add(reviewBoardDto);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(reviewBoardDtoList);
	}	
	
	@Operation(summary = "boardNo로 reviewBoard 수정")
	@PutMapping("/{boardNo}")
	public ResponseEntity<ReviewBoardDto> updateReviewBoard(@PathVariable(value = "boardNo") Long boardNo, @RequestBody ReviewBoardDto dto) throws Exception {		
		ReviewBoard existingReviewBoard = reviewBoardService.findByBoardNo(boardNo);		
		
		if(existingReviewBoard!=null) {
			if(dto.getBoardContent()!=null) {
				existingReviewBoard.setBoardContent(dto.getBoardContent());
			}
			if(dto.getBoardStar()!=null) {
				existingReviewBoard.setBoardStar(dto.getBoardStar());
			}
			if(dto.getBoardTitle()!=null) {
				existingReviewBoard.setBoardTitle(dto.getBoardTitle());
			}
			
		// productNo는 수정할수없다.?
			
			reviewBoardService.update(existingReviewBoard);
			ReviewBoardDto reviewBoardDto = ReviewBoardDto.toDto(existingReviewBoard);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			
			return new ResponseEntity<>(reviewBoardDto, httpHeaders, HttpStatus.OK);
		
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
		
	
	@Operation(summary = "높은 평점순 정렬")
	@GetMapping("reviewBoards/BoardStarDesc")
	public ResponseEntity<List<ReviewBoardDto>> findAllByOrderByBoardStarDesc() {
	    List<ReviewBoard> reviewBoards = reviewBoardService.findAllByOrderByBoardStarDesc();
	    List<ReviewBoardDto> reviewBoardDtos = new ArrayList<>();

	    for (ReviewBoard reviewBoard : reviewBoards) {
	        ReviewBoardDto dto = new ReviewBoardDto();
	        dto.setBoardNo(reviewBoard.getBoardNo());
	        dto.setBoardTitle(reviewBoard.getBoardTitle());
	        dto.setBoardContent(reviewBoard.getBoardContent());
	        dto.setBoardDate(reviewBoard.getBoardDate());
	        dto.setBoardStar(reviewBoard.getBoardStar());

	        reviewBoardDtos.add(dto);
	    }
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    if (!reviewBoardDtos.isEmpty()) {
	        return new ResponseEntity<>(reviewBoardDtos, httpHeaders, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
	    }
	}	
	
	@Operation(summary = "낮은 평점순 정렬")
	@GetMapping("reviewBoards/BoardStarAsc")
	public ResponseEntity<List<ReviewBoardDto>> findAllByOrderByBoardStarAsc() {
	    List<ReviewBoard> reviewBoards = reviewBoardService.findAllByOrderByBoardStarAsc();
	    List<ReviewBoardDto> reviewBoardDtos = new ArrayList<>();

	    for (ReviewBoard reviewBoard : reviewBoards) {
	        ReviewBoardDto dto = new ReviewBoardDto();
	        dto.setBoardNo(reviewBoard.getBoardNo());
	        dto.setBoardTitle(reviewBoard.getBoardTitle());
	        dto.setBoardContent(reviewBoard.getBoardContent());
	        dto.setBoardDate(reviewBoard.getBoardDate());
	        dto.setBoardStar(reviewBoard.getBoardStar());

	        reviewBoardDtos.add(dto);
	    }
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    if (!reviewBoardDtos.isEmpty()) {
	        return new ResponseEntity<>(reviewBoardDtos, httpHeaders, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
	    }
	}
	
	@Operation(summary = "최신 날짜순으로 정렬")
	@GetMapping("reviewBoards/BoardDateDesc")
	public ResponseEntity<List<ReviewBoardDto>> findAllByOrderByBoardDateDesc() {
	    List<ReviewBoard> reviewBoards = reviewBoardService.findAllByOrderByBoardDateDesc();
	    List<ReviewBoardDto> reviewBoardDtos = new ArrayList<>();

	    for (ReviewBoard reviewBoard : reviewBoards) {
	        ReviewBoardDto dto = new ReviewBoardDto();
	        dto.setBoardNo(reviewBoard.getBoardNo());
	        dto.setBoardTitle(reviewBoard.getBoardTitle());
	        dto.setBoardContent(reviewBoard.getBoardContent());
	        dto.setBoardDate(reviewBoard.getBoardDate());
	        dto.setBoardStar(reviewBoard.getBoardStar());

	        reviewBoardDtos.add(dto);
	    }

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    if (!reviewBoardDtos.isEmpty()) {
	        return new ResponseEntity<>(reviewBoardDtos, httpHeaders, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
	    }
	}
	
	@Operation(summary = "오래된 날짜순으로 정렬")
	@GetMapping("reviewBoards/BoardDateAsc")
	public ResponseEntity<List<ReviewBoardDto>> findAllByOrderByBoardDateAsc() {
	    List<ReviewBoard> reviewBoards = reviewBoardService.findAllByOrderByBoardDateAsc();
	    List<ReviewBoardDto> reviewBoardDtos = new ArrayList<>();

	    for (ReviewBoard reviewBoard : reviewBoards) {
	        ReviewBoardDto dto = new ReviewBoardDto();
	        dto.setBoardNo(reviewBoard.getBoardNo());
	        dto.setBoardTitle(reviewBoard.getBoardTitle());
	        dto.setBoardContent(reviewBoard.getBoardContent());
	        dto.setBoardDate(reviewBoard.getBoardDate());
	        dto.setBoardStar(reviewBoard.getBoardStar());

	        reviewBoardDtos.add(dto);
	    }

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    if (!reviewBoardDtos.isEmpty()) {
	        return new ResponseEntity<>(reviewBoardDtos, httpHeaders, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
	    }
	}

	@Operation(summary = "별점 높은순, 최신순으로 정렬")
	@GetMapping("reviewBoards/BoardStarDescBoardDateDesc")
	public ResponseEntity<List<ReviewBoardDto>> findByOrderByBoardStarDescBoardDateDesc() {
	    List<ReviewBoard> reviewBoards = reviewBoardService.findByOrderByBoardStarDescBoardDateDesc();
	    List<ReviewBoardDto> reviewBoardDtos = new ArrayList<>();

	    for (ReviewBoard reviewBoard : reviewBoards) {
	        ReviewBoardDto dto = new ReviewBoardDto();
	        dto.setBoardNo(reviewBoard.getBoardNo());
	        dto.setBoardTitle(reviewBoard.getBoardTitle());
	        dto.setBoardContent(reviewBoard.getBoardContent());
	        dto.setBoardDate(reviewBoard.getBoardDate());
	        dto.setBoardStar(reviewBoard.getBoardStar());

	        reviewBoardDtos.add(dto);
	    }

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    if (!reviewBoardDtos.isEmpty()) {
	        return new ResponseEntity<>(reviewBoardDtos, httpHeaders, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
	    }
	}
	
	@Operation(summary = "별점 낮은순, 최신순으로 정렬")
	@GetMapping("reviewBoards/BoardStarAscBoardDateDesc")
	public ResponseEntity<List<ReviewBoardDto>> findByOrderByBoardStarAscBoardDateDesc() {
	    List<ReviewBoard> reviewBoards = reviewBoardService.findByOrderByBoardStarAscBoardDateDesc();
	    List<ReviewBoardDto> reviewBoardDtos = new ArrayList<>();

	    for (ReviewBoard reviewBoard : reviewBoards) {
	        ReviewBoardDto dto = new ReviewBoardDto();
	        dto.setBoardNo(reviewBoard.getBoardNo());
	        dto.setBoardTitle(reviewBoard.getBoardTitle());
	        dto.setBoardContent(reviewBoard.getBoardContent());
	        dto.setBoardDate(reviewBoard.getBoardDate());
	        dto.setBoardStar(reviewBoard.getBoardStar());

	        reviewBoardDtos.add(dto);
	    }

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    if (!reviewBoardDtos.isEmpty()) {
	        return new ResponseEntity<>(reviewBoardDtos, httpHeaders, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
	    }
	}
	
	
}