package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.entity.Visit;
import com.itwill.service.VisitService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/visit")
public class VIsitRestController {
	
	@Autowired
	private VisitService visitService ;
	
	
	@PostMapping
	public ResponseEntity<Visit> createVisit(@RequestBody Visit visit) {
		//견학 생성
		Visit createVisit = visitService.createVisit(visit);
		return ResponseEntity.status(HttpStatus.CREATED).body(createVisit) ;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Visit>> getAllVisits() {
		//모든 방문 리스트 조회
		List<Visit> visits = visitService.selectAllVisits();
		return ResponseEntity.ok(visits);
	}

	
}
