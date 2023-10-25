package com.itwill.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.entity.Adopt;
import com.itwill.service.AdoptService;
import com.itwill.service.PetService;
import com.itwill.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdoptController {

	private UserInfoService userInfoService;
	private AdoptService adoptService;
	private PetService petService;
	
	@PostMapping
	public Adopt create(HttpSession session, Model model ) {
		
	
		// sUserId가 없으면 login페이지로 이동
	
	String user=(String)session.getAttribute("sUserId");
	Adopt adopt = Adopt.builder()
						.adoptTime(11)
						.adoptDate(new Date())
						.adoptStatus("입양신청")
						.build();
		return adoptService.insertAdopt(adopt); // sUserId가 있으면 입양신청 완료
	}
	
	
}
