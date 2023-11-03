package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
	
	@GetMapping(value = "/")
	public String main() {
		return "index";
	}

	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/myAccount")
	public String myAccount() {
		return "my-account";
	}
	
	@GetMapping(value = "/reportview")
	public String reportview() {
		return "reportBoardView";
	}
	
}
