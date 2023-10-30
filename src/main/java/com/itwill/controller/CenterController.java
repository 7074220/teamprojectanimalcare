//package com.itwill.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.itwill.dto.CenterDto;
//import com.itwill.service.CenterService;
//
//@Controller
//public class CenterController {
//
//	@Autowired
//	CenterService centerService;
//
//	@PostMapping("/insert_action")
//	public String insert_action(@RequestBody CenterDto centerDto) {
//
//		centerService.createCenter(CenterDto.toEntity(centerDto));
//		return "redirect:center-list.html";
//	}
//
//	public String centerList() {
//		return null;
//
//	}
//
//}
