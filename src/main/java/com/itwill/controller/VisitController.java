package com.itwill.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.VisitDto;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;
import com.itwill.service.CenterService;
import com.itwill.service.UserInfoService;
import com.itwill.service.VisitService;

import groovy.transform.AutoImplement;
import jakarta.servlet.http.HttpSession;

@Controller
public class VisitController {

	@Autowired
	private VisitService visitService;
	@Autowired
	private CenterService centerService;
	@Autowired
	private UserInfoService userInfoService;

	// 견학신청
	@GetMapping(value = "/visit", params = "centerNo")
	public String apply(Model model, @RequestParam Long centerNo) {
		Center center = centerService.findByCenterNo(centerNo);
	
		model.addAttribute("center", center);
		return "visit";
	}

	@PostMapping("/create-visit")
	public String createVisit(@RequestParam("visitDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date visitDate,
			@RequestParam("visitTime") int selectedHour, @RequestParam Long centerNo, HttpSession session, Model model)
			throws Exception {

		Long userNo = (Long)session.getAttribute("userNo");
		if (userNo!=null) {
			Visit visit = new Visit();
			visit.setVisitDate(visitDate);
			visit.setVisitTime(selectedHour);
			visit.setVisitStatus("접수중");

			Center center = centerService.findByCenterNo(centerNo);
			Userinfo userinfo = userInfoService.findUserByNo(userNo);
			visit.setUserinfo(userinfo);
			visit.setCenter(center);
			visitService.createVisit(visit);
			model.addAttribute("userinfo", userinfo);
		} else {
			throw new Exception("로그인을 해주세요.");
		}
		return "center-list"; // 뷰 페이지의 이름을 반환
	}

	/*
	 * // 관리자 견학리스트 전체출력
	 * 
	 * @GetMapping("/visitList") public String centerList(Model model) { List<Visit>
	 * visits = visitService.selectAllVisits(); model.addAttribute("visits",
	 * visits); return "my-account"; }
	 */

	// 관리자,유저 견학리스트 전체출력
	@GetMapping("/visitByUserNo")
	public String findByUserNoVisitList(Model model, HttpSession session) throws Exception {
		Long userNo = (Long) session.getAttribute("userNo");
		Userinfo user = userInfoService.findUserByNo(userNo);
		List<Visit> visitList;

		if (user.getUserNo().equals(57L)) {
			// userNo가 57인 경우 전체 견학 리스트를 가져옴
			visitList = visitService.selectAllVisits();
		} else {
			// 그 외의 경우 로그인한 회원의 견학 리스트를 가져옴
			visitList = visitService.getVisitsByUserNo(user.getUserNo());
		}

		// 람다 표현식 visitList에서 visit1, visit2 두 개의 요소를 나타내며 compareTo로 두 개의 번호를 비교해서 정렬
		visitList.sort((visit1, visit2) -> visit2.getVisitDate().compareTo(visit1.getVisitDate()));
		model.addAttribute("visitList", visitList);
		return "my-account-visit";
	}

}
