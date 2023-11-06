package com.itwill.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.dto.AdoptDto;
import com.itwill.entity.Adopt;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;
import com.itwill.service.AdoptService;
import com.itwill.service.PetService;
import com.itwill.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdoptController {

	@Autowired
	private AdoptService adoptService;
	@Autowired
	private PetService petService;
	@Autowired
	private UserInfoService userInfoService;
	// 입양신청
	@GetMapping(value = "/adopt", params = "petNo")
	public String apply(Model model, @RequestParam Long petNo) {
		Pet pet = petService.petFindById(petNo);
		model.addAttribute("pet", pet);
		return "adopt";
	}


	@PostMapping("/create-adopt")
	public String createAdopt(@RequestParam("adoptDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date adoptDate,
			@RequestParam("adoptTime") int selectedHour, @RequestParam Long petNo, Model model, HttpSession session) throws Exception {
		Long userNo = (Long)session.getAttribute("userNo");
		
		// 시간 문자열을 LocalTime으로 파싱
	   // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	    //LocalTime adoptTime = LocalTime.parse(selectedHour, formatter);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>시작");
		if(userNo!=null) {
		
			Adopt adopt = new Adopt();
			adopt.setAdoptDate(adoptDate);
			adopt.setAdoptTime(selectedHour);
			// adopt.setAdoptTime(adoptTime);
			 
			adopt.setAdoptStatus("입양신청접수");
	
			Pet pet = petService.petFindById(petNo);
			Userinfo userinfo=userInfoService.findUserByNo(userNo);
			adopt.setUserinfo(userinfo);
			adopt.setPet(pet);
			adoptService.insertAdopt(adopt);
			model.addAttribute("userinfo", userinfo);
		}else {
			throw new Exception("로그인을 해주세요.");
		}
		return "pet-list";
	}
	
	
	
	
	
	// 입양 리스트 조회(관리자)
	@GetMapping("/adoptList")
	public String adoptList(Model model) {
		
		List<Adopt> adoptList = adoptService.findAdoptList();
		
		model.addAttribute("adoptList", adoptList);
		return "my-account";
	}

	// userNo에 따른 입양리스트 조회
	@GetMapping("/adoptByUserNo")
	public String findByUserNoAdoptList(Model model,HttpSession session) throws Exception{
		Long userNo=(Long)session.getAttribute("userNo");
		Userinfo user=userInfoService.findUserByNo(userNo);
		
		List<Adopt> adoptList = adoptService.findAdoptsByUserNo(user.getUserNo());
		adoptList.sort((v1,v2)->v2.getAdoptDate().compareTo(v1.getAdoptDate()));
		
		
		model.addAttribute("adoptList", adoptList);
		return "my-account-adopt";
	}

	// adoptNo 입양 조회
	@GetMapping("/adopt/{adoptNo}")
	public String findByAdoptNoAdopt(Model model, @PathVariable(name = "adoptNo") Long adoptNo) {
		Adopt adopt = adoptService.findByAdoptNo(adoptNo);
		model.addAttribute("adopt", adopt);
		return "my-account";
	}

}
