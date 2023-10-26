package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.PetDto;
import com.itwill.dto.UserWriteActionDto;
import com.itwill.entity.Pet;
import com.itwill.service.PetService;

import io.swagger.v3.oas.annotations.Operation;
@RequestMapping("/pet")
@Controller
public class PetController {
@Autowired
PetService petService;
//팻 등록
	@PostMapping("/insert_action")
	public String insert_action(@RequestBody PetDto petDto) throws Exception {
		
		petService.petSave(petDto.toEntity(petDto));
		
		return "redirect:pet-list.html";
	}
	//펫 리스트
	@GetMapping("/petList")
	public String petList(Model model) {
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.petFindAll();
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
		}
		
		model.addAttribute("petList",petDtoList);
		return "forward:pet-list.html" ;
	}
	//펫 삭제
	@PostMapping("/petDelete")
	public String petDelete(Model model) {
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.petFindAll();
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
		}
		return "redirect:pet-list.html";
	}
	
	
	

}
