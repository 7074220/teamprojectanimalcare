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
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.AdoptDto;
import com.itwill.entity.Adopt;
import com.itwill.service.AdoptService;

@Controller
@RequestMapping("/adopt")
public class AdoptController {

	@Autowired
	private AdoptService adoptService;
/*
	// 입양신청
	@GetMapping("/re/insert_action")
	public String insert_action(@RequestBody AdoptDto dto) {
		return "my-account";
	}
*/
	// 입양 리스트 조회
	@GetMapping("/adoptList")
	public String adoptList(Model model) {
		List<AdoptDto> adoptDtoList = new ArrayList<>();
		List<Adopt> adoptList = adoptService.findAdoptList();
		for (Adopt adopt : adoptList) {
			adoptDtoList.add(AdoptDto.fromEntity(adopt));
		}
		model.addAttribute("adoptDtoList", adoptDtoList);
		return "my-account";
	}

	//userNo에 따른 입양리스트 조회
	@GetMapping("/adoptList/{userNo}")
	public String findByUserNoAdoptList(Model model, @PathVariable(name = "userNo") Long userNo) {
		List<Adopt> adoptList=adoptService.findAdoptsByUserNo(userNo);
		List<AdoptDto> adoptDtoUserNoList = new ArrayList<>();
		for (Adopt adopt : adoptList) {
			adoptDtoUserNoList.add(AdoptDto.fromEntity(adopt));
		}
		model.addAttribute("adoptDtoUserNoList", adoptDtoUserNoList);
		return "my-account";
	}

	// adoptNo 입양 조회
	@GetMapping("/adoptList/{adoptNo}")
	public String findByAdoptNoAdopt(Model model, @PathVariable(name = "adoptNo") Long adoptNo) {
		Adopt adopt=adoptService.findByAdoptNo(adoptNo);
		model.addAttribute("adopt", adopt);
		return "my-account";
	}
	

	
	
}
