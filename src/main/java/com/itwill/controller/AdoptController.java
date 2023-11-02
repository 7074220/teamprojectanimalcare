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
			@RequestParam("adoptTime") int selectedHour, @RequestParam Long petNo, Model model) {
		Adopt adopt = new Adopt();
		adopt.setAdoptDate(adoptDate);
		adopt.setAdoptTime(selectedHour);
		adopt.setAdoptStatus("입양신청접수");

		Pet pet = petService.petFindById(petNo);
		adopt.setPet(pet);
		adoptService.insertAdopt(adopt);
		model.addAttribute("msg", "신청이 완료되었습니다.");
		return "pet-list";
	}

	// 입양 리스트 조회(관리자)
	@GetMapping("/adoptList")
	public String adoptList(Model model) {
		// List<AdoptDto> adoptDtoList = new ArrayList<>();
		List<Adopt> adoptList = adoptService.findAdoptList();
		/*
		 * for (Adopt adopt : adoptList) { adoptDtoList.add(AdoptDto.fromEntity(adopt));
		 * } model.addAttribute("adoptDtoList", adoptDtoList);
		 */
		model.addAttribute("adoptList", adoptList);
		return "my-account";
	}

	// userNo에 따른 입양리스트 조회
	@GetMapping("/adoptByUserNo")
	public String findByUserNoAdoptList(Model model,HttpSession session) throws Exception{
		Long userNo=(Long)session.getAttribute("userNo");
		Userinfo user=userInfoService.findUserByNo(userNo);
		
		List<Adopt> adoptList = adoptService.findAdoptsByUserNo(user.getUserNo());
		/*
		 * List<AdoptDto> adoptDtoUserNoList = new ArrayList<>();
		 * 
		 * for (Adopt adopt : adoptList) {
		 * adoptDtoUserNoList.add(AdoptDto.fromEntity(adopt)); }
		 */
	
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
