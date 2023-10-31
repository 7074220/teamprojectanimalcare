package com.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itwill.service.ReportBoardService;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class ReportController {
	
	@Autowired
	private ReportBoardService reportBoardService;
	
	@Operation(summary = "신청 리스트")
	public void List() {
		
	}
	
}
