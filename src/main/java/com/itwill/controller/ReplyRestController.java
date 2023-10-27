package com.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ReplyCreateDto;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.Userinfo;
import com.itwill.service.ReplyBoardService;
import com.itwill.service.ReportBoardService;
import com.itwill.service.UserInfoService;

@RestController
@RequestMapping("/reply")
public class ReplyRestController {
	
	@Autowired
	private ReplyBoardService replyBoardService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private ReportBoardService reportBoardService;
	
	@GetMapping
	public void replyCreate(ReplyCreateDto replyCreateDto) {
		Userinfo userinfo = userInfoService.findUserByNo(replyCreateDto.getUserNo());
		ReplyBoard replyBoard = ReplyCreateDto.toEntity(replyCreateDto);
		replyBoardService.Create(replyBoard);
	}
	
}
