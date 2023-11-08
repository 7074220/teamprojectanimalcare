package com.itwill.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;


import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;

import com.itwill.service.ReplyBoardService;
import com.itwill.service.ReportBoardService;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class ReportController {
	
	
	
	@Autowired
	private ReportBoardService reportBoardService;
	
	@Autowired
	private ReplyBoardService replyBoardService;
	
	@Operation(summary = "신고게시판 리스트")
	@GetMapping("/reportlist")
	public String ReportList(Model model) {
		List<ReportBoard> reportBoards = reportBoardService.findAll();
		System.out.println(">>>>>>"+reportBoards);
		model.addAttribute("reportBoardList", reportBoards);
		return "reportList";
	}
	
	@GetMapping(value="/reportBoardView",params="boardNo")
	public String ReportView(Model model,@RequestParam Long boardNo) {
		
		ReportBoard reportBoard = reportBoardService.findByBoardNo(boardNo);
		List<ReplyBoard> replyBoardList= replyBoardService.findAllByReportBoardNo(boardNo);
		
		System.out.println(">>>>>>>>>>>>>>>>"+reportBoard);
		System.out.println(">>>>>>>>>>>>>>>>"+reportBoard.getBoardImage());
		model.addAttribute("reportBoard", reportBoard);
		model.addAttribute("replyBoardList", replyBoardList);
		return "reportBoardView";
	}
	
	
	
	@GetMapping("/reportWrite")
    public String showReportForm() {
        return "reportBoard_write_form"; 
    }

	
	
	
	/*
	@Operation(summary = "신고게시판 상세보기")
	@GetMapping("/{boardNo}")
	public String ReportView(Model model,@RequestParam(name = "boardNo") Long boardNo) {
		ReportBoard reportBoard = reportBoardService.findByBoardNo(boardNo);
		List<ReplyBoard> replyBoard=replyBoardService.findAllByReportBoardNo(boardNo);
		model.addAttribute("reportBoard", reportBoard);
		
		model.addAttribute("replyBoardList", replyBoard);
		
		return "reportBoardView";
	}
	
	@Operation(summary = "신고게시판 수정폼으로 이동")
	@PutMapping("/{boardNo}")
	public String ReportUpdate(Model model,@RequestParam(name = "boardNo")Long boardNo) {
		ReportBoard reportBoard = reportBoardService.findByBoardNo(boardNo);
		model.addAttribute("reportBoard", reportBoard);
		return "reportBoardUpdateForm";
	}
	*/
	
	
	
	
}
