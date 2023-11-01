package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.itwill.entity.Center;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;
import com.itwill.service.PetService;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
@Controller
public class PetController {
@Autowired
PetService petService;
//@Autowired
//팻 등록
	@PostMapping("/insert_action")
	public String insert_action(@RequestBody PetDto petDto) throws Exception {
		
		petService.petSave(petDto.toEntity(petDto));
		
		return "pet-list";
	}
	//펫 리스트
	//center dto가져와야함.
	@GetMapping("/petList")
	public String petList(Model model) {
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.petFindAll();
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
		}
		
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+petDtoList.get(0).getPetType());
		model.addAttribute("petList",petDtoList);
		return "pet-list" ;
	}
	//펫 삭제 관리자만
	@PostMapping("/delete_action")
	public String delete_action(@PathVariable(name = "petNo") Long petNo) throws Exception{
		Optional<Pet> petOptional = Optional.of(petService.petFindById(petNo));
		if(petOptional.isEmpty()) {
			throw new Exception("존재하지 않는 동물입니다.");
		
			}
			petService.petRemove(petNo);
		return "pet-list";
	}
	//펫 업데이트
	@PostMapping("/update_action")
	public String update_action(@RequestBody PetDto updatepetDto) throws Exception{
		Optional<Pet> petOptional = Optional.of(petService.petFindById(updatepetDto.getPetNo()));
		if(petOptional.isPresent()) {
			Pet pet1 = petOptional.get();
			pet1.setPetLocal(updatepetDto.getPetLocal());
			pet1.setPetType(updatepetDto.getPetType());
			pet1.setPetGender(updatepetDto.getPetGender());
			pet1.setPetRegisterDate(updatepetDto.getPetRegisterDate());
			pet1.setPetFindPlace(updatepetDto.getPetFindPlace());
			pet1.setPetCharacter(updatepetDto.getPetCharacter());
			pet1.setCenter(updatepetDto.getCenter());
			
			
			petService.petUpdate(pet1);
	}
		return "pet-list";
	
	}

	

}
