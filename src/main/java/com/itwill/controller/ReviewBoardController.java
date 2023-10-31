package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.ReviewBoardDto;
import com.itwill.entity.ReviewBoard;
import com.itwill.service.ReviewBoardService;

@Controller
@RequestMapping("/reviewBoard")
public class ReviewBoardController {

	@Autowired
	private ReviewBoardService reviewBoardService;
	
	// admin이 리뷰리스트 볼 때
	@GetMapping("/admin/reviewBoardList")
	public String reviewBoardList(Model model) {
		List<ReviewBoard> reviewBoardList=reviewBoardService.findAll();
		List<ReviewBoardDto> reviewBoardDtoList = new ArrayList<>();
		for (ReviewBoard reviewBoard : reviewBoardList) {
			reviewBoardDtoList.add(ReviewBoardDto.toDto(reviewBoard));
		}
		model.addAttribute("reviewBoardDtoList", reviewBoardDtoList);
		return "reviewboard";    // 링크수정하기
	}
	
	
	// productNo로 리뷰리스트 볼 때
	@GetMapping("/product/{productNo}")
	public String findByProductNoReviewBoardList(Model model, @PathVariable(name = "productNo") Long productNo) {
		List<ReviewBoard> reviewBoards=reviewBoardService.findByProductNo(productNo);
		List<ReviewBoardDto> reviewBoardDtos = new ArrayList<>();
		
		for (ReviewBoard reviewBoard : reviewBoards) {
			reviewBoardDtos.add(ReviewBoardDto.toDto(reviewBoard));
		}
		model.addAttribute("reviewBoardDtos", reviewBoardDtos);
		return "reviewboard";  //링크 수정하기
	}
	
	
	
	
	
}
