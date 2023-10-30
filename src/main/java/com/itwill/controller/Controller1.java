package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
	
	@GetMapping(value = "/")
	public String main() {
		return "layout/layout";
	}
	
	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}
	@GetMapping(value = "/my-account")
	public String myAccount() {
		return "my-account";
	}
	@GetMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
	
	

}
