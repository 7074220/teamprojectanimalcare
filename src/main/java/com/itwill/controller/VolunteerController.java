package com.itwill.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;
import com.itwill.service.CenterService;
import com.itwill.service.ReviewBoardService;
import com.itwill.service.UserInfoService;
import com.itwill.service.VolunteerService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;



@Controller
public class VolunteerController {
	
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private CenterService centerService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private ReviewBoardService reviewBoardService;
	
	@GetMapping(value = "/volunteer", params = "centerNo") // 봉사 신청
	public String insert_action(Model model, @RequestParam Long centerNo) throws Exception {				
		Center center = centerService.findByCenterNo(centerNo);
		model.addAttribute("center", center);
		return "volunteer";
	}
	
	
	// 봉사버튼 클릭시 로그인이면 신청완료, 비회원이면 로그인 페이지 이동
	@PostMapping("/create-volunteer")
	public String createVolunteer(@RequestParam("volunteerDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date volunteerDate,
	        @RequestParam("volunteerTime") int selectedHour, @RequestParam Long centerNo, HttpSession session, Model model) throws Exception {
	    Long userNo = (Long) session.getAttribute("userNo");
	    
	    if (userNo != null) {
	        Volunteer volunteer = new Volunteer();
	        volunteer.setVolunteerDate(volunteerDate);
	        volunteer.setVolunteerStatus("봉사신청");
	        volunteer.setVolunteerTime(selectedHour);

	        Center center = centerService.findByCenterNo(centerNo);
	        Userinfo userinfo = userInfoService.findUserByNo(userNo);
	        volunteer.setUserinfo(userinfo);
	        volunteer.setCenter(center);
	        
	        model.addAttribute("userinfo", userinfo);

	        // 봉사신청이 성공한 경우 모델에 추가
	        model.addAttribute("message", "신청이 완료되었습니다.");
	    } else {
	        // 로그인이 필요한 경우 모델에 추가
	        model.addAttribute("error", "로그인이 필요합니다.");
	    }
	    return "centerList"; // 뷰 페이지의 이름을 반환
	    
	}
	
	
	@GetMapping("/volunteerList") // 봉사 목록 전체 조회. 관리자
	public String volunteerList(Model model) {
		List<Volunteer> volunteers = volunteerService.findAllVolunteers();    
	    model.addAttribute("volunteers", volunteers);
	    return "my-account-volunteer";
	}
	
	/*
	// userNo 로 봉사 목록 조회. 로그인한 회원
	@GetMapping("/volunteerList/{userNo}")
	public String findByUserNoVolunteerList(Model model, HttpSession httpSession, @PathVariable(name = "userNo") Long userNo) throws Exception{		
		List<Volunteer> volunteerList = volunteerService.findVolunteertByUserNo(userNo);
		
		List<VolunteerDto> volunteerDtoUserNoList = new ArrayList<>();		
		for (Volunteer volunteer : volunteerList) {
			volunteerDtoUserNoList.add(VolunteerDto.toDto(volunteer));
		}
		
		model.addAttribute("volunteerList", volunteerList);
		return "my-account-volunteer"; 
	}
	*/
	
	
	
	// userNo 로 봉사 리스트 조회. 로그인한 회원
	@GetMapping("/volunteerByUserNo") 
	public String findByVolunteerListUserNo(Model model, HttpSession session) throws Exception {
		Long userNo=(Long)session.getAttribute("userNo");
		Userinfo user=userInfoService.findUserByNo(userNo);
		
		List<Volunteer> volunteerList = volunteerService.findVolunteertByUserNo(user.getUserNo());		
		// volunteerNo를 내림차순으로 정렬
	    volunteerList.sort((v1, v2) -> v2.getVolunteerNo().compareTo(v1.getVolunteerNo()));
	    model.addAttribute("userNo", userNo);
		model.addAttribute("volunteerList", volunteerList);
		return "my-account-volunteer";
	}
		
	/*
	@GetMapping("/volunteerUpdate")
    public String getVolunteerPage(@RequestParam Long volunteerNo, @RequestParam Long centerNo, Model model) {

        Volunteer volunteer = volunteerService.findByVolunteerNo(volunteerNo);
        Center center = centerService.findByCenterNo(centerNo);
        //System.out.println(">>>>>>>>>>"+volunteerNo);
        //System.out.println(">>>>>>>>>>"+centerNo);

        model.addAttribute("volunteer", volunteer);
        model.addAttribute("volunteerNo", volunteerNo);
        model.addAttribute("center", center);

        return "volunteerUpdate";
    }
	

    @PutMapping("/update-volunteer")
    public String updateVolunteer(@ModelAttribute Volunteer volunteer, @RequestParam(value = "volunteerNo") Long volunteerNo, 
            HttpSession session, Model model) throws Exception {
        Long userNo = (Long) session.getAttribute("userNo");
        if (userNo != null) {
            Volunteer findVolunteer = volunteerService.findByVolunteerNo(volunteerNo);

            //findVolunteer.setCenter(volunteer.getCenter());
            findVolunteer.setVolunteerDate(volunteer.getVolunteerDate());
            findVolunteer.setVolunteerTime(volunteer.getVolunteerTime());

            volunteerService.updateVolunteer(findVolunteer);
        }
        return "my-account-volunteer"; // 수정 실패 페이지로 이동
    }
	*/

	
}