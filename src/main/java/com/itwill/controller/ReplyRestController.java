package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ReplyCreateDto;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;
import com.itwill.service.ReplyBoardService;
import com.itwill.service.ReportBoardService;
import com.itwill.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/reply")
public class ReplyRestController {
	
	@Autowired
	private ReplyBoardService replyBoardService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private ReportBoardService reportBoardService;
	
	// 댓글 쓰기
	@GetMapping("/create")
	public ResponseEntity<ReplyCreateDto> Create(ReplyCreateDto replyCreateDto,HttpSession session) throws Exception {
		Userinfo findUserinfo = userInfoService.findUserByNo(replyCreateDto.getUserNo());
		ReportBoard findReportBoard = reportBoardService.findByBoardNo(replyCreateDto.getReportNo());
		ReplyBoard replyBoard = ReplyCreateDto.toEntity(replyCreateDto);
		replyBoard.setUserinfo(findUserinfo);
		replyBoard.setReportBoard(findReportBoard);
		
		if(session.getAttribute("userNo")!=null) {
			if(replyBoard.getReplyBoardContent()!=null) {
				replyBoardService.Create(replyBoard);
			}else {
				throw new Exception("내용을 입력해주세요");
			}
		}else {
			throw new Exception("로그인을 해주세요");
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ReplyCreateDto>(replyCreateDto, httpHeaders, HttpStatus.CREATED);
	}
	
	// 댓글 수정
	@PutMapping
	public ResponseEntity<ReplyCreateDto> update(ReplyCreateDto replyCreateDto,HttpSession session) throws Exception{
		ReplyBoard replyBoard = ReplyCreateDto.toEntity(replyCreateDto);
		if(session.getAttribute("userNo")!=null) {
			replyCreateDto = ReplyCreateDto.toDto(replyBoardService.update(replyBoard));
		}else {
			throw new Exception("로그인을 해주세요");
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ReplyCreateDto>(replyCreateDto, httpHeaders, HttpStatus.OK);
	}
	
}
