package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.entity.Volunteer;
import com.itwill.service.VolunteerService;

@Controller
@RequestMapping("/volunteer")
public class VolunteerRestController {
	
	@Autowired
	private VolunteerService volunteerService;
	
	
	
	@GetMapping
	public ResponseEntity<List<Volunteer>> findAllVolunteers() {		
		List<Volunteer> volunteerList = volunteerService.findAllVolunteers();
		return ResponseEntity.status(HttpStatus.OK).body(volunteerList);
	}; // 목록 전체 조회
	
	@GetMapping("/{userNo}")
	public ResponseEntity<List<Volunteer>> findVolunteertByUserNo(@PathVariable(name = "userNo") Long no) {
		return ResponseEntity.status(HttpStatus.OK).body(volunteerService.findVolunteertByUserNo(no));
	}; // userNo 로 Volunteer 목록 조회
	
	
	
}
