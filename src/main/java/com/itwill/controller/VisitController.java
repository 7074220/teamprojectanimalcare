package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.entity.Center;
import com.itwill.entity.Visit;
import com.itwill.service.CenterService;
import com.itwill.service.VisitService;

@Controller
@RequestMapping()
public class VisitController {
	
	@Autowired
	VisitService visitService;
	
	//견학신청
	@GetMapping("/visitApply")
	public String apply(Model model) throws Exception {
		return "";
	}
	
	//견학 수정
	
	//visitlist 전체출력(미완성)
    @GetMapping("/visitList")
    public String centerList(Model model) {
        List<Visit> visitList = visitService.selectAllVisits();
        model.addAttribute("visiits", visitList);
        return "";
	}
    
     
}
