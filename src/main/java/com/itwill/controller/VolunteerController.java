package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Center;
import com.itwill.entity.Volunteer;
import com.itwill.service.VolunteerService;

import io.swagger.v3.oas.annotations.Operation;



@Controller
public class VolunteerController {
	
	@Autowired
	private VolunteerService volunteerService;

	
	@GetMapping("/volunteer") // 봉사 신청
	public String insert_action(Model model) throws Exception {				
		return "volunteer";
	}
	
	/*
	@GetMapping("/volunteer") // 봉사 신청
	public String insert_action(@RequestBody VolunteerDto dto) throws Exception {		
		volunteerService.insertVolunteer(dto.toEntity(dto));		
		return "volunteer";
	}
	*/
	
	// 봉사 전체 리스트 조회. 관리자?
	@GetMapping("/volunteerList") 
	public String volunteerList(Model model) {
		List<Volunteer> volunteerList = volunteerService.findAllVolunteers();
		List<VolunteerDto> volunteerDtoList = new ArrayList<>();
		
		for (Volunteer volunteer : volunteerList) {
			volunteerDtoList.add(VolunteerDto.toDto(volunteer));
		}
		model.addAttribute("volunteerDtoList", volunteerDtoList);
		return "volunteerList"; // 일반적으로 뷰 템플릿의 경로를 지정. 링크수정하기
	}

	
	// userNo 로 봉사 목록 조회. 로그인한 회원
	@GetMapping("/volunteerList/{userNo}")
	public String findByUserNoVolunteerList(Model model, @PathVariable(name = "userNo") Long userNo) throws Exception{
		List<Volunteer> volunteerList = volunteerService.findVolunteertByUserNo(userNo);
		List<VolunteerDto> volunteerDtoUserNoList = new ArrayList<>();
		
		for (Volunteer volunteer : volunteerList) {
			volunteerDtoUserNoList.add(VolunteerDto.toDto(volunteer));
		}
		model.addAttribute("volunteerDtoUserNoList", volunteerDtoUserNoList);
		return "my-account"; 
	}
	
	/*
	// volunteerNo 로 봉사 목록 조회. 관리자?
	@GetMapping("/volunteerList/{volunteerNo}")
	public String findByVolunteerNoVolunteer(Model model, @PathVariable(name = "volunteerNo") Long volunteerNo) throws Exception{
		Volunteer volunteer = volunteerService.findByVolunteerNo(volunteerNo);
		model.addAttribute("volunteer", volunteer);
		return "redirect:volunteer_list"; // 링크수정하기	
	}
	*/
}
