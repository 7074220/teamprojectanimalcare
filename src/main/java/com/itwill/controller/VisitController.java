package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.entity.Center;
import com.itwill.entity.Visit;
import com.itwill.service.CenterService;
import com.itwill.service.VisitService;

@Controller
public class VisitController {

	@Autowired
	private VisitService visitService;
	@Autowired
	private CenterService centerService;

	// 견학신청
	@GetMapping(value = "/visit", params = "centerNo")
	public String apply(Model model,@RequestParam Long centerNo) throws Exception {
		Center center = centerService.findByCenterNo(centerNo);
		model.addAttribute("center", center);
		return "visit";
	}
	

	// 관리자 견학리스트 전체출력
	@GetMapping("/visitList")
	public String centerList(Model model) {
		List<Visit> visits  = visitService.selectAllVisits();
		model.addAttribute("visits", visits);
		return "my-account";
	}

	// 회원의 견학 리스트 출력
	@GetMapping("/visitList/{userNo}")
	public String memberVisitList(@PathVariable("userNo") Long userNo, Model model) {
		List<Visit> memberVisitList = visitService.getVisitsByUserNo(userNo);
		model.addAttribute("memberVisits", memberVisitList);
		return "my-account";
	}
	
}
