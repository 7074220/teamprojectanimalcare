package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ReplyCreateDto;
import com.itwill.dto.ReplyListDto;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;
import com.itwill.service.ReplyBoardService;
import com.itwill.service.ReportBoardService;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
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
	@Operation(summary = "회원이 댓글 작성")
	@GetMapping("/create")
	public ResponseEntity<List<ReplyCreateDto>> Create(ReplyCreateDto replyCreateDto, HttpSession session)
			throws Exception {
		Userinfo findUserinfo = userInfoService.findUserByNo(replyCreateDto.getUserNo());
		ReportBoard findReportBoard = reportBoardService.findByBoardNo(replyCreateDto.getReportNo());
		ReplyBoard replyBoard = ReplyCreateDto.toEntity(replyCreateDto);
		replyBoard.setUserinfo(findUserinfo);
		replyBoard.setReportBoard(findReportBoard);

		if (session.getAttribute("userNo") != null) {
			if (replyBoard.getReplyBoardContent() != null) {
				replyBoardService.Create(replyBoard);
			} else {
				throw new Exception("내용을 입력해주세요");
			}
		} else {
			throw new Exception("로그인을 해주세요");
		}

		List<ReplyBoard> replyBoardList = replyBoardService.findAllByReportBoardNo(replyCreateDto.getReportNo());
		List<ReplyCreateDto> replyCreateDtoList = new ArrayList<ReplyCreateDto>();
		for (ReplyBoard replyBoard2 : replyBoardList) {
			ReplyCreateDto createDto = ReplyCreateDto.toDto(replyBoard2);
			replyCreateDtoList.add(createDto);
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<ReplyCreateDto>>(replyCreateDtoList, httpHeaders, HttpStatus.CREATED);
	}

	// 댓글 수정
	@Operation(summary = "자신이 쓴 댓글 수정")
	@PutMapping
	public ResponseEntity<List<ReplyCreateDto>> update(ReplyCreateDto replyCreateDto, HttpSession session)
			throws Exception {
		ReplyBoard replyBoard = ReplyCreateDto.toEntity(replyCreateDto);
		Userinfo userinfo = userInfoService.findUserByNo(replyCreateDto.getUserNo());
		ReportBoard reportBoard = reportBoardService.findByBoardNo(replyCreateDto.getReportNo());

		replyBoard.setUserinfo(userinfo);
		replyBoard.setReportBoard(reportBoard);

		if (session.getAttribute("userNo") != null) {
			replyCreateDto = ReplyCreateDto.toDto(replyBoardService.update(replyBoard));
		} else {
			throw new Exception("로그인을 해주세요");
		}

		List<ReplyBoard> replyBoardList = replyBoardService.findAllByReportBoardNo(replyCreateDto.getReportNo());
		List<ReplyCreateDto> replyCreateDtoList = new ArrayList<ReplyCreateDto>();
		for (ReplyBoard replyBoard2 : replyBoardList) {
			ReplyCreateDto createDto = ReplyCreateDto.toDto(replyBoard2);
			replyCreateDtoList.add(createDto);
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<ReplyCreateDto>>(replyCreateDtoList, httpHeaders, HttpStatus.OK);
	}

	// 댓글 삭제
	@Operation(summary = "자신이 쓴 댓글삭제")
	@DeleteMapping
	public ResponseEntity<List<ReplyCreateDto>> delete(ReplyCreateDto replyCreateDto, HttpSession session)
			throws Exception {
		Integer step = replyCreateDto.getReplyBoardStep();
		Integer depth = replyCreateDto.getReplyBoardGroupNo();
		Integer groupNo = replyCreateDto.getReplyBoardGroupNo();
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인을 해주세요");
		}

		replyBoardService.deleteByReplyBoardStepBoardDepthBoardGroupNo(step, depth, groupNo);

		List<ReplyBoard> replyBoardList = replyBoardService.findAllByReportBoardNo(replyCreateDto.getReportNo());
		List<ReplyCreateDto> replyCreateDtoList = new ArrayList<ReplyCreateDto>();
		for (ReplyBoard replyBoard2 : replyBoardList) {
			ReplyCreateDto createDto = ReplyCreateDto.toDto(replyBoard2);
			replyCreateDtoList.add(createDto);
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<ReplyCreateDto>>(replyCreateDtoList, httpHeaders, HttpStatus.OK);
	}

	// 댓글 리스트
	@Operation(summary = "회원이 쓴 댓글 리스트")
	@GetMapping("/list")
	public ResponseEntity<List<ReplyCreateDto>> List(ReplyListDto replyListDto, HttpSession session) throws Exception {

		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 해주세요");
		}

		List<ReplyBoard> replyBoardList = replyBoardService.findAllByReportBoardNo(replyListDto.getReportNo());
		List<ReplyCreateDto> replyCreateDtoList = new ArrayList<ReplyCreateDto>();
		for (ReplyBoard replyBoard2 : replyBoardList) {
			ReplyCreateDto createDto = ReplyCreateDto.toDto(replyBoard2);
			replyCreateDtoList.add(createDto);
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<ReplyCreateDto>>(replyCreateDtoList, httpHeaders, HttpStatus.OK);
	}

	// 댓글 쓰기 ( 비회원 )
	@Operation(summary = "비회원이 댓글 작성")
	@PostMapping("/inserted")
	public ResponseEntity<ReplyCreateDto> Create(@RequestBody ReplyCreateDto replyCreateDto) throws Exception {
		System.out.println(">>>>>> 맵핑");
		System.out.println("no:"+replyCreateDto.getReportNo());
		System.out.println("replyCreateDto:"+replyCreateDto);
		ReportBoard findReportBoard = reportBoardService.findByBoardNo(replyCreateDto.getReportNo());
		System.out.println(findReportBoard);
		ReplyBoard replyBoard = ReplyCreateDto.toEntity(replyCreateDto);
		replyBoard.setReportBoard(findReportBoard);
		/*
		List<ReplyBoard> replyBoardList = replyBoardService.findAllByReportBoardNo(replyBoard.getReportBoard().getBoardNo());
		List<ReplyCreateDto> replyCreateDtoList=new ArrayList<ReplyCreateDto>();
		for (ReplyBoard replyBoard2 : replyBoardList) {
		  ReplyCreateDto createDto =  ReplyCreateDto.toDto(replyBoard2);
		  replyCreateDtoList.add(createDto);
		}
		
			*/
		ReplyBoard saveReplyBoard= replyBoardService.Create(replyBoard);
		System.out.println(saveReplyBoard);
				 HttpHeaders httpHeaders = new HttpHeaders(); httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ReplyCreateDto>(ReplyCreateDto.toDto(saveReplyBoard), httpHeaders,HttpStatus.CREATED);
	}
}
