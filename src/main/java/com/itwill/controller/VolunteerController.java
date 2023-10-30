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
	
	@PostMapping("/update_action") // 봉사 일부분 수정
	public String update_action(@RequestBody VolunteerDto dto) throws Exception {
		Optional<Volunteer> volunteerOptional = Optional.of(volunteerService.findByVolunteerNo(dto.getVolunteerNo()));
		//Volunteer volunteer =volunteerService.findByVolunteerNo(dto.getVolunteerNo());
		if(volunteerOptional.isPresent()) {
			Volunteer volunteer = volunteerOptional.get();
			volunteer.setVolunteerTime(dto.getVolunteerTime());
			volunteer.setVolunteerDate(dto.getVolunteerDate());
			volunteer.setVolunteerStatus(dto.getVolunteerStatus());
			volunteer.setCenter(Center.builder().centerNo(dto.getCenterNo()).build());
			
			volunteerService.updateVolunteer(volunteer);
		}
		
		return "redirect:volunteer_list.html"; // 링크수정하기	
	}
	
	
	@PostMapping("/delete_action/{volunteerNo}") // 봉사 삭제
	public String delete_action(@PathVariable(name = "volunteerNo") Long volunteerNo) throws Exception {
		Optional<Volunteer> volunteerOptional = Optional.of(volunteerService.findByVolunteerNo(volunteerNo));
		//Volunteer volunteer = volunteerService.findByVolunteerNo(volunteerNo);
		if(volunteerOptional.isEmpty()) {
			throw new Exception("존재하지 않는 게시물입니다.");
		}
		volunteerService.deleteVolunteer(volunteerNo);
		return "redirect:volunteer_list.html"; // 링크수정하기	
	}
	
	
	
	
	
}
