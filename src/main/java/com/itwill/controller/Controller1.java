package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.dto.PetDto;
import com.itwill.entity.Pet;
import com.itwill.entity.ReportBoard;
import com.itwill.service.PetService;
import com.itwill.service.ReportBoardService;



@Controller
public class Controller1 {
	
	@Autowired
	private PetService petService;
	@Autowired
	private ReportBoardService reportBoardService;
	/*
	@GetMapping(value = "/")
	public String main() {
		return "index";
	}

	@GetMapping(value = "/index")
	public String index() {
		
		return "index";
	}
*/
	
	@GetMapping(value = "/myAccount")
	public String myAccount() {
		return "my-account";
	}
	
	@GetMapping(value = "/reportview")
	public String reportview() {
		return "reportBoardView";
	}
	
	@GetMapping(value = "/")
	public String indexPetList(Model model) {
		
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.petFindAll();
		
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
			model.addAttribute("petList", petDtoList);
		}
		List<ReportBoard> reportBoards = reportBoardService.findAll();
		model.addAttribute("reportBoardList", reportBoards);

		return "index";
	}
	
	
	@GetMapping(value = "/index")
	public String indexPetList2(Model model) {
		
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.petFindAll();
		
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
			model.addAttribute("petList", petDtoList);
		}
		
		List<ReportBoard> reportBoards = reportBoardService.findAll();
		model.addAttribute("reportBoardList", reportBoards);
		
		return "index";
	}

	
}
