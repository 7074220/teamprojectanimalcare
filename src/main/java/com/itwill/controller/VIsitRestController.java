package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.CenterDto;
import com.itwill.dto.VisitDto;
import com.itwill.entity.Visit;
import com.itwill.service.VisitService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.criteria.Path;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/visit")
public class VIsitRestController {
	
	@Autowired
	private VisitService visitService ;
	
	@Operation(summary = "견학신청")
	@PostMapping
	public ResponseEntity<VisitDto> createVisit(@RequestBody VisitDto dto, HttpSession session) {
		//견학 생성
		Visit visitEntity = VisitDto.toEntity(dto);
		visitService.createVisit(visitEntity);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<>(dto, httpHeaders, HttpStatus.CREATED);
	}
	@Operation(summary = "견학리스트조회")
	@GetMapping("/visits")
	public ResponseEntity<List<VisitDto>> visitList() {
		//모든 방문 리스트 조회
		List<Visit> visits = visitService.selectAllVisits();
		List<VisitDto> visitDtoList = new ArrayList<VisitDto>();
		for(Visit visit : visits) {
			visitDtoList.add(VisitDto.toDto(visit));
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<VisitDto>>(visitDtoList, httpHeaders, HttpStatus.OK);
	}

	@Operation(summary = "견학리스트삭제")
	@DeleteMapping("/{visitNo}")
	public void VisitDelete(@PathVariable(name = "visitNo") Long visitNo) {
		visitService.deleteVisit(visitNo);
	}
	
}
