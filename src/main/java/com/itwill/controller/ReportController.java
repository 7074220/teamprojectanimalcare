package com.itwill.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;

import com.itwill.service.ReplyBoardService;
import com.itwill.service.ReportBoardService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;

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
	
	
	
	@GetMapping("/reportWriteForm")
    public String showReportForm() {
        return "reportBoard_write_form"; 
    }

	@PostMapping("/reportWrite")
	  public String handleImagePost(@RequestParam("imageFile") MultipartFile file , @RequestParam("boardTitle")String boardTitle,
			  @RequestParam("boardFindDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date boardFindDate, @RequestParam("boardFindName")String boardFindName,
			  @RequestParam("boardFindPhone")String boardFindPhone, @RequestParam("boardContent")String boardContent) throws Exception{

	    String uploadPath = System.getProperty("user.dir") + "/src/main/resources/static/image/reportboard/";
	    String originalFileName = file.getOriginalFilename();
	    UUID uuid = UUID.randomUUID();
	    String savedFileName = uuid.toString() + "_" + originalFileName;

	    File newFile = new File(uploadPath + savedFileName);

	    file.transferTo(newFile);
	    
	    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date parsingDate = dateFormat.parse(boardFindDate);
	    System.out.println(">>>>>>>>>>>>>>>>>"+boardFindDate);
	    ReportBoard writeReportBoard = ReportBoard.builder()
	    										.boardContent(boardContent)
	    										.boardFindDate(boardFindDate)
	    										.boardFindName(boardFindName)
	    										.boardFindPhone(boardFindPhone)
	    										.boardImage(newFile.getName())
	    										.boardTitle(boardTitle)
	    										.build();
	    System.out.println(">>>>"+writeReportBoard);
	    ReportBoard insertReportBoard = reportBoardService.Create(writeReportBoard);
	    System.out.println(">>>>"+insertReportBoard);
	    return "index";
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
