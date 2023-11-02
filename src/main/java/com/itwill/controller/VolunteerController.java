package com.itwill.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Center;
import com.itwill.entity.Volunteer;
import com.itwill.service.CenterService;
import com.itwill.service.VolunteerService;

import io.swagger.v3.oas.annotations.Operation;



@Controller
public class VolunteerController {
	
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private CenterService centerService;
	
	
	@GetMapping(value = "/volunteer", params = "centerNo") // 봉사 신청
	public String insert_action(Model model, @RequestParam Long centerNo) throws Exception {				
		Center center = centerService.findByCenterNo(centerNo);
		model.addAttribute("center", center);
		return "volunteer";
	}
	
	@PostMapping("/create-volunteer")
	public String createVolunteer(@RequestParam("volunteerDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date volunteerDate, 
			@RequestParam("volunteerTime") int selectedHour, @RequestParam Long centerNo, Model model) {
		
		Volunteer volunteer = new Volunteer();
		volunteer.setVolunteerDate(volunteerDate);
		volunteer.setVolunteerStatus("접수중");
		volunteer.setVolunteerTime(selectedHour);
		
		Center center = centerService.findByCenterNo(centerNo);
		volunteer.setCenter(center);
		volunteerService.insertVolunteer(volunteer);
		
		return "center-list";
	}
	
	
	@GetMapping("/volunteerList") // 봉사 목록 전체 조회. 관리자
	public String volunteerList(Model model) {
		List<Volunteer> volunteers = volunteerService.findAllVolunteers();
		/*
		List<VolunteerDto> volunteerDtoList = new ArrayList<>();
	    for (Volunteer volunteer : volunteerList) {
	        volunteerDtoList.add(VolunteerDto.toDto(volunteer));
	    }
	    */	    
	    model.addAttribute("volunteers", volunteers);
	    return "my-account";
	}
	
	
	// userNo 로 봉사 목록 조회. 로그인한 회원
	@GetMapping("/volunteerList/{userNo}")
	public String findByUserNoVolunteerList(Model model, @PathVariable(name = "userNo") Long userNo) throws Exception{		
		List<Volunteer> volunteerList = volunteerService.findVolunteertByUserNo(userNo);
		/*
		List<VolunteerDto> volunteerDtoUserNoList = new ArrayList<>();		
		for (Volunteer volunteer : volunteerList) {
			volunteerDtoUserNoList.add(VolunteerDto.toDto(volunteer));
		}
		*/
		model.addAttribute("volunteerList", volunteerList);
		return "my-account"; 
	}
	
}
