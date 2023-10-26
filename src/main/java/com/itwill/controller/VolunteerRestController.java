package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.itwill.dao.VolunteerDao;
import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Volunteer;
import com.itwill.service.CenterService;
import com.itwill.service.UserInfoService;
import com.itwill.service.VolunteerService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/volunteer")
public class VolunteerRestController {
	
	@Autowired
	private VolunteerService volunteerService;
	
	@Operation(summary = "봉사신청")
	@PostMapping
	public ResponseEntity<VolunteerDto> insertVolunteer(@RequestBody VolunteerDto dto, HttpSession httpSession) throws Exception{
		Volunteer volunteerEntity = VolunteerDto.toEntity(dto);		
		volunteerService.insertVolunteer(volunteerEntity);	
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));		
		return new ResponseEntity<>(dto, httpHeaders, HttpStatus.CREATED);		
	} // INSERT
	
	@Operation(summary = "no로 봉사신청 보기")
	@GetMapping("/{no}") 
	public ResponseEntity<VolunteerDto> findByVolunteerNo(@PathVariable(name = "no") Long no,  HttpSession httpSession) throws Exception{		
		Volunteer findVolunteer = volunteerService.findByVolunteerNo(no);		
		if(findVolunteer == null) {
			throw new Exception("찾을수없다.");
		}
		VolunteerDto volunteerDto = VolunteerDto.toDto(findVolunteer);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));		
		return new ResponseEntity<VolunteerDto>(volunteerDto, httpHeaders, HttpStatus.OK);
	} // 봉사 목록 찾기
	
	@Operation(summary = "userNo로 봉사목록 조회")
	@GetMapping("/user/{userNo}")
	public ResponseEntity<List<VolunteerDto>> findVolunteertByUserNo(@PathVariable(name = "userNo") Long userNo) {
		List<Volunteer> volunteers = volunteerService.findVolunteertByUserNo(userNo);
		List<VolunteerDto> volunteerDtoList = new ArrayList<VolunteerDto>();
		
		for (Volunteer volunteer : volunteers) {
			volunteerDtoList.add(VolunteerDto.toDto(volunteer));
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<List<VolunteerDto>>(volunteerDtoList, httpHeaders, HttpStatus.OK);
	} // userNo 로 VolunteerList 조회
	
	@Operation(summary = "봉사리스트")
	@GetMapping("/volunteers")
	public ResponseEntity<List<VolunteerDto>> volunteerList() {
		List<Volunteer> volunteers = volunteerService.findAllVolunteers();
		List<VolunteerDto> volunteerDtoList = new ArrayList<VolunteerDto>();
		
		for (Volunteer volunteer : volunteers) {
			volunteerDtoList.add(VolunteerDto.toDto(volunteer));			
		}	
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));				
		return new ResponseEntity<List<VolunteerDto>>(volunteerDtoList, httpHeaders, HttpStatus.OK);
	} // 목록 전체 조회
	
	@Operation(summary = "봉사삭제")
	@DeleteMapping("/{volunteerNo}")
	public void VolunteerDelete(@PathVariable(name = "volunteerNo") Long volunteerNo) throws Exception{
		volunteerService.deleteVolunteer(volunteerNo);	
	} // DELETE

	
	/*
	@GetMapping --> 성공
	public ResponseEntity<List<Volunteer>> findAllVolunteers() {		
		List<Volunteer> volunteerList = volunteerService.findAllVolunteers();
		return ResponseEntity.status(HttpStatus.OK).body(volunteerList);
	} // 목록 전체 조회
	
	@GetMapping("/{userNo}") --> 성공
	public ResponseEntity<List<Volunteer>> findVolunteertByUserNo(@PathVariable(name = "userNo") Long no) {
		return ResponseEntity.status(HttpStatus.OK).body(volunteerService.findVolunteertByUserNo(no));
	} // userNo 로 Volunteer 목록 조회

	
	@PostMapping --> 성공
	public ResponseEntity<Volunteer> insertVolunteer(@RequestBody Volunteer volunteer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(volunteerService.insertVolunteer(volunteer));
	} // INSERT
	
	--------------------------------------
	@PutMapping("/{volunteerNo}")
	public ResponseEntity<Volunteer> updateVolunteer(@PathVariable Long volunteerNo, @RequestBody Volunteer updateVolunteer) throws Exception {	
		Volunteer existingVolunteer = volunteerService.findByVolunteerNo(volunteerNo);	
		if (existingVolunteer == null) {
			// volunteerNo 가 존재하지 않으면 notFound() 반환
			return ResponseEntity.notFound().build();
		}
		// volunteerNo 가 존재하면 업데이트 적용 후 저장
		existingVolunteer.setVolunteerTime(updateVolunteer.getVolunteerTime());
		existingVolunteer.setVolunteerStatus(updateVolunteer.getVolunteerStatus());
		existingVolunteer.setCenter(updateVolunteer.getCenter());		
		Volunteer updatedVolunteer = volunteerService.updateVolunteer(existingVolunteer);
		return ResponseEntity.ok(updatedVolunteer);		
	} // UPDATE
	
	@Operation(summary = "봉사수정")
	@PutMapping("/{volunteerNo}")
	public ResponseEntity<VolunteerDto> updateVolunteer(@PathVariable(name = "volunteerNo") Long volunteerNo, @RequestBody Volunteer updateVolunteer, HttpSession httpSession) throws Exception {	
		Volunteer existingVolunteer = volunteerService.findByVolunteerNo(volunteerNo);
		
		if (existingVolunteer == null) {
			
			return ResponseEntity.notFound().build();
		} else {
		existingVolunteer.setVolunteerTime(updateVolunteer.getVolunteerTime());
		existingVolunteer.setVolunteerStatus(updateVolunteer.getVolunteerStatus());
		existingVolunteer.setVolunteerDate(updateVolunteer.getVolunteerDate());
		//existingVolunteer.setCenter(updateVolunteer.getCenter());	
	
		VolunteerDto updatedVolunteerDto = VolunteerDto.formEntity(existingVolunteer);
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    return new ResponseEntity<>(updatedVolunteerDto, httpHeaders, HttpStatus.OK);
		} // UPDATE
	}
	--------------------------------------
	
	@DeleteMapping("/{no}") --> 성공
	public ResponseEntity<Map> deleteVolunteer(@PathVariable(name = "no") Long no) throws Exception {
		volunteerService.deleteVolunteer(no);
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	} // DELETE
	
	
	
	@GetMapping("/{no}") --> 성공
	public ResponseEntity<Volunteer> findByVolunteerNo(@PathVariable(name = "no") Long no) {
		return ResponseEntity.status(HttpStatus.OK).body(volunteerService.findByVolunteerNo(no));
	} // 봉사 목록 찾기
	*/

	
}
