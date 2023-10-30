package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Volunteer;
import com.itwill.service.VolunteerService;



@Controller
public class VolunteerController {
	
	@Autowired
	private VolunteerService volunteerService;

	@PostMapping("/insert_action") // 봉사 신청
	public String insert_action(@RequestBody VolunteerDto dto) throws Exception {		
		volunteerService.insertVolunteer(dto.toEntity(dto));		
		return "redirect:volunteer_list.html"; // 링크수정하기	
	}
	
	@GetMapping("/volunteerList") // 봉사 리스트
	public String volunteerList(Model model) {
		List<Volunteer> volunteerList = volunteerService.findAllVolunteers();
		List<VolunteerDto> volunteerDtoList = new ArrayList<>();
		
		for (Volunteer volunteer : volunteerList) {
			volunteerDtoList.add(VolunteerDto.toDto(volunteer));
		}
		model.addAttribute("volunteerDtoList", volunteerDtoList);
		return "forward:volunteer_list.html"; // 일반적으로 뷰 템플릿의 경로를 지정	
	}
	
	
	
	
}
