package com.itwill.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.MyPetCreateDto;
import com.itwill.dto.MyPetListDto;
import com.itwill.dto.MypetDto;
import com.itwill.entity.MyPet;
import com.itwill.service.MyPetService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/mypet")
public class MyPetRestController {
	
	@Autowired
	private MyPetService myPetService;
	
	// 로그인 상태에서 펫 등록 누름
	 @Operation(summary = "마이펫등록")
	 @PostMapping("/inserted")
	 public ResponseEntity<MypetDto> MypetCreate(@RequestBody MypetDto mypetDto , HttpSession session) throws Exception{
		 	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>맵핑");
		 	Long userNo = (Long)session.getAttribute("userNo");	
		 	if(userNo==null) {
		 		throw new Exception("로그인을 해주세요");
		 	}
		 	
		 	
		 	
		 	
		 	
		 	myPetService.Create(MypetDto.toEntity(mypetDto));
		 	
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			
			return new ResponseEntity<MypetDto>(mypetDto,httpHeaders ,HttpStatus.OK);
		}
	/*
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
	public void MyPetAllDelete(@PathVariable(name = "userNo")Long userNo) {
		myPetService.deleteMypetAllByUserNo(userNo);
	}
	
	@Operation(summary = "마이펫 1개 삭제")
	@DeleteMapping("/{userNo}/{mypetNo}")
	public void MyPetDeleteByUserNo(@PathVariable(name = "userNo")Long userNo,@PathVariable(name = "mypetNo")Long mypetNo) {
		myPetService.deleteMypetByUserNo(userNo, mypetNo);
	}
	*/
}
