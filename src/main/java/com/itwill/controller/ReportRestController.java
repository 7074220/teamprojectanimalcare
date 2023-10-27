package com.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ReportBoardInsertDto;
import com.itwill.entity.ReportBoard;
import com.itwill.service.ReportBoardService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/report")
public class ReportRestController {
	
	@Autowired
	private ReportBoardService reportBoardService;
	
	@Operation(summary = "유기견신고하기")
	@PostMapping
	public ResponseEntity<ReportBoard> registerLostDog(@RequestBody ReportBoardInsertDto reportBoardInsertDto) {
		
		//reportBoardService.Create(reportBoardInsertDto);
		
		
		
		return null;
		
	}
	
}
