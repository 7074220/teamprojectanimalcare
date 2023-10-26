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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.sym.Name;
import com.itwill.dto.PetDto;
import com.itwill.dto.UserWriteActionDto;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;
import com.itwill.service.PetService;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
@RequestMapping("/pet")
@Controller
public class PetController {
@Autowired
PetService petService;
@Autowired
UserInfoService userInfoService;
//팻 등록
	@PostMapping("/insert_action")
	public String insert_action(@RequestBody PetDto petDto) throws Exception {
		
		petService.petSave(petDto.toEntity(petDto));
		
		return "redirect:pet-list.html";
	}
	//펫 리스트
	@GetMapping()
	public String petList(Model model) {
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.petFindAll();
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
		}
		
		model.addAttribute("petList",petDtoList);
		return "forward:pet-list.html" ;
	}
	//펫 삭제 관리자만
	@PostMapping("/delete_action")
	public String delete_action(@PathVariable(name = "petNo") Long petNo) throws Exception{
		try {
			petService.petRemove(petNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:pet-list.html";
	}
	//펫 업데이트
	@PostMapping("/update_action")
	public String update_action(@RequestBody PetDto updatepetDto) throws Exception{
		try {
			petService.petUpdate(updatepetDto.toEntity(updatepetDto));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:pet-list.html";
	}
	
	

}
