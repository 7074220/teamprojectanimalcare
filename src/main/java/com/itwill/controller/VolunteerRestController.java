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

import com.itwill.dto.AdoptDto;
import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Center;
import com.itwill.entity.Volunteer;
import com.itwill.service.CenterService;
import com.itwill.service.VolunteerService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/volunteer")
public class VolunteerRestController {
	
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private CenterService centerService;
	
	
	// 봉사버튼 클릭시 로그인이면 저장, 비회원이면 메인 이동
	@Operation(summary = "봉사신청")
	@PostMapping("/create-volunteer")
	public ResponseEntity<VolunteerDto> insertVolunteer(@RequestBody VolunteerDto dto, HttpSession session) throws Exception {
        Long userNo = (Long) session.getAttribute("userNo");
        
        Integer status = 0;
        if (userNo == null) {
            // 로그인하지 않은 사용자에 대한 처리
        	status = 1;
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        dto.setUserNo(userNo);
        Volunteer volunteer = VolunteerDto.toEntity(dto);
        volunteerService.insertVolunteer(volunteer);        
        HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<VolunteerDto>(dto, httpHeaders, HttpStatus.CREATED);
    }
	
	
	/*
	@Operation(summary = "봉사신청") 
	@PostMapping
	public ResponseEntity<VolunteerDto> insertVolunteer(@RequestBody VolunteerDto dto, HttpSession httpSession) throws Exception{
		Volunteer volunteerEntity = VolunteerDto.toEntity(dto);		
		volunteerService.insertVolunteer(volunteerEntity);	
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));		
		return new ResponseEntity<>(dto, httpHeaders, HttpStatus.CREATED);		
	} // INSERT
	*/

	
	@Operation(summary = "봉사삭제")
	@DeleteMapping("/{volunteerNo}")
	public ResponseEntity<Map> VolunteerDelete(@PathVariable(name = "volunteerNo") Long volunteerNo) throws Exception{
		volunteerService.deleteVolunteer(volunteerNo);	
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	} // DELETE
	
	
	@Operation(summary = "봉사 부분 업데이트") 
	@PutMapping("/{volunteerNo}")
	public ResponseEntity<VolunteerDto> updateVolunteer(@PathVariable(name = "volunteerNo") Long volunteerNo, @RequestBody VolunteerDto dto) throws Exception {
	    Volunteer existingVolunteer = volunteerService.findByVolunteerNo(volunteerNo);

	    if (existingVolunteer == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        if (dto.getVolunteerTime() != null) {
	            existingVolunteer.setVolunteerTime(dto.getVolunteerTime());
	        }
	        if (dto.getVolunteerDate() != null) {
	            existingVolunteer.setVolunteerDate(dto.getVolunteerDate());
	        }
	        if (dto.getVolunteerStatus() != null) {
	            existingVolunteer.setVolunteerStatus(dto.getVolunteerStatus());
	        }	
	        if (dto.getCenterNo() != null) {
	        	Center center = centerService.findByCenterNo(dto.getCenterNo());
	            existingVolunteer.setCenter(center);
	        }
  
	        volunteerService.updateVolunteer(existingVolunteer);
	        VolunteerDto updatedVolunteerDto = VolunteerDto.toDto(existingVolunteer);
	        return new ResponseEntity<>(updatedVolunteerDto, HttpStatus.OK);
	    }
	} // UPDATE


	
	@Operation(summary = "volunteerNo로 봉사신청 보기") 
	@GetMapping("/{volunteerNo}") 
	public ResponseEntity<VolunteerDto> findByVolunteerNo(@PathVariable(name = "volunteerNo") Long no,  HttpSession httpSession) throws Exception{		
		Volunteer findVolunteer = volunteerService.findByVolunteerNo(no);		
		if(findVolunteer == null) {
			throw new Exception("정보를 찾을 수 없습니다.");
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
	public ResponseEntity<List<VolunteerDto>> findAllVolunteers() {
		List<Volunteer> volunteerList = volunteerService.findAllVolunteers();
		List<VolunteerDto> volunteerDtoList = new ArrayList<VolunteerDto>();
		
		for (Volunteer volunteer : volunteerList) {
			volunteerDtoList.add(VolunteerDto.toDto(volunteer));			
		}	
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));				
		return new ResponseEntity<List<VolunteerDto>>(volunteerDtoList, httpHeaders, HttpStatus.OK);
	} // 목록 전체 조회
	
	
}
