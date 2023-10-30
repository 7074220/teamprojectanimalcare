package com.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwill.service.MyPetService;

@Controller
public class MyPetController {

	@Autowired 
	private MyPetService myPetService;
	
	
	
	
}
