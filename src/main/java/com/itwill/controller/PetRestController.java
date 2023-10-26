package com.itwill.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.PetDto;
import com.itwill.entity.Pet;
import com.itwill.service.PetService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/pet")
public class PetRestController {

	@Autowired
	private PetService petService;
@Operation(summary = "펫 리스트")	
@GetMapping()
public ResponseEntity<List<PetDto>> petList(){
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.petFindAll();
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(petDtoList);
	}
@Operation(summary = "펫 등록")	
@PostMapping()
public ResponseEntity<PetDto> petSave(@RequestBody PetDto petdto){
		petService.petSave(petdto.toEntity(petdto));
		return ResponseEntity.status(HttpStatus.OK).body(petdto);
	}


@Operation(summary = "펫 삭제")	
@DeleteMapping("/{petNo}")
public ResponseEntity<Map> petDelete(@PathVariable(name = "petNo") Long petNo) throws Exception{
		petService.petRemove(petNo);
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	}

@Operation(summary = "펫 업데이트")
@PutMapping()
public ResponseEntity<PetDto> petDelete(@RequestBody PetDto petdto) throws Exception{
	petService.petUpdate(petdto.toEntity(petdto));
	
	return ResponseEntity.status(HttpStatus.OK).body(petdto);
}
@Operation(summary = "펫 리스트 최신등록순")	
@GetMapping()
public ResponseEntity<List<PetDto>> petDescList(){
		List<PetDto> petDtoList = new ArrayList<>();
		List<Pet> petList = petService.findAllByOrderBypetNoDesc();
		for (Pet pet : petList) {
			petDtoList.add(PetDto.toDto(pet));
		}

		return ResponseEntity.status(HttpStatus.OK).body(petDtoList);
	
	
}
}
