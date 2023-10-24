package com.itwill.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.entity.Volunteer;
import com.itwill.service.VolunteerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/volunteer")
public class VolunteerRestController {
	
	@Autowired
	private VolunteerService volunteerService;
	
	
	
	@GetMapping
	public ResponseEntity<List<Volunteer>> findAllVolunteers() {		
		List<Volunteer> volunteerList = volunteerService.findAllVolunteers();
		return ResponseEntity.status(HttpStatus.OK).body(volunteerList);
	}; // 목록 전체 조회
	
	@GetMapping("/{no}")
	public ResponseEntity<List<Volunteer>> findVolunteertByUserNo(@PathVariable(name = "no") Long no) {
		return ResponseEntity.status(HttpStatus.OK).body(volunteerService.findVolunteertByUserNo(no));
	}; // userNo 로 Volunteer 목록 조회
	
	@GetMapping("/{no}")
	public ResponseEntity<Volunteer> findByVolunteerNo(@PathVariable(name = "no") Long no) {
		return ResponseEntity.status(HttpStatus.OK).body(volunteerService.findByVolunteerNo(no));
	}; // 봉사 목록 찾기
	
	@PostMapping
	public ResponseEntity<Volunteer> insertVolunteer(@RequestBody Volunteer volunteer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(volunteerService.insertVolunteer(volunteer));
	}; // INSERT
	
	@PutMapping
	public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(volunteerService.updateVolunteer(volunteer));
	}; // UPDATE
	
	@DeleteMapping("/{no}")
	public ResponseEntity<Map> deleteVolunteer(@PathVariable(name = "no") Long no) throws Exception {
		volunteerService.deleteVolunteer(no);
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	}; // DELETE
	
	
	

	
}
