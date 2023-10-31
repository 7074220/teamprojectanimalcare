package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.itwill.entity.ReplyBoard;
import com.itwill.service.ReplyBoardService;

@Controller
public class ReplyBoardController {

	@Autowired
	private ReplyBoardService replyBoardService;
	
	public String ReportList(Model model,Long boardNo) {
		
		replyBoardService.findAllByReportBoardNo(boardNo);
	 	
		return "";
	}
}
