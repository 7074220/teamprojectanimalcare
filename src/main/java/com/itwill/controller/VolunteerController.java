package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwill.dto.VolunteerDto;
import com.itwill.service.VolunteerService;

@Controller
public class VolunteerController {

	@PostMapping("/insert_action")
	public String insert_action(@RequestBody VolunteerDto volunteerDto) throws Exception {
		
		//VolunteerService.(volunteerDto.toEntity(volunteerDto));
		
		return "redirect:volunteer-list.html";
		
	}
	
	
	
}
