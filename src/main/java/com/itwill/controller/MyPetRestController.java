package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.MyPetListDto;
import com.itwill.entity.MyPet;
import com.itwill.service.MyPetService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mypet")
public class MyPetRestController {
	
	@Autowired
	private MyPetService myPetService;
	
	@Operation(summary = "마이펫리스트")
	@GetMapping("/{userNo}")
	public ResponseEntity<List<MyPetListDto>> MypetList(@PathVariable(name = "userNo")Long userNo) {
		List<MyPet> mypets = myPetService.findMyPetListByuserNo(userNo);
		List<MyPetListDto> myPetListDtoList = new ArrayList<MyPetListDto>();
		
		for (MyPet myPet : mypets) {
			myPetListDtoList.add(MyPetListDto.toDto(myPet));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<MyPetListDto>>(myPetListDtoList,httpHeaders ,HttpStatus.OK);
	}
	
	@Operation(summary = "마이펫 전체삭제")
	@DeleteMapping("/{userNo}")
	public void MyPetDelete(@PathVariable(name = "userNo")Long userNo) {
		myPetService.Delete(userNo);
	}
	
}
