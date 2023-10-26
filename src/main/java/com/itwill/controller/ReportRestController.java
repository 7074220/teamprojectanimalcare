package com.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.service.ReportBoardService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/report")
public class ReportRestController {
	
	@Autowired
	ReportBoardService reportBoardService;
	
	@Operation(summary = "유저에 따른 쿠폰 뽑기")
	@GetMapping("/{userNo}")
	public void reportList() {
		
	}
	
}
