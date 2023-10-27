package com.itwill.controller;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ReportBoardInsertDto;
import com.itwill.dto.UserLoginActionDto;
import com.itwill.dto.UserWriteActionDto;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;
import com.itwill.service.ReportBoardService;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/report")
public class ReportRestController {
	
	@Autowired
	private ReportBoardService reportBoardService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Operation(summary = "유기견신고하기")
	@PostMapping
	public ResponseEntity<ReportBoardInsertDto> registerLostDog(ReportBoardInsertDto reportBoardInsertDto) throws Exception {
		Userinfo userinfo = userInfoService.findUserByNo(reportBoardInsertDto.getUserNo());
		
		ReportBoard reportBoard = ReportBoardInsertDto.toEntity(reportBoardInsertDto);
		
		reportBoard.setUserinfo(userinfo);
		reportBoardService.Create(reportBoard);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ReportBoardInsertDto>(reportBoardInsertDto,httpHeaders,HttpStatus.OK);
	}
	
	@Operation(summary = "유기견삭제")
	@DeleteMapping("/{boardNo}")
	public ResponseEntity<ReportBoardInsertDto> reportBoardDelete(@PathVariable(name = "boardNo") Long boardNo){
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ReportBoardInsertDto>(httpHeaders, HttpStatus.OK);

}


}
