package com.itwill.controller;


import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.AdoptDto;
import com.itwill.entity.Adopt;
import com.itwill.service.AdoptService;
import com.itwill.service.PetService;
import com.itwill.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/adopt")
public class AdoptRestController {

	@Autowired
	private AdoptService adoptService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private PetService petService;

	
	@Operation(summary = "입양신청")
	@PostMapping
	public ResponseEntity<AdoptDto> insertAdopt(@RequestBody AdoptDto dto, HttpSession session) throws Exception {
	    Adopt adoptEntity = AdoptDto.toEntity(dto); // AdoptDto를 Adopt 엔티티로 변환

	    adoptService.insertAdopt(adoptEntity); // 변환된 엔티티를 서비스를 통해 저장

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    return new ResponseEntity<>(dto, httpHeaders, HttpStatus.CREATED);
	}
	/*
	@Operation(summary = "no로 입양신청 보기")
	@GetMapping("/{no}")
	public ResponseEntity<AdoptDto> findByAdoptNo(@PathVariable(value = "no") Long no, @RequestBody AdoptDto dto) throws Exception {
		Adopt findAdopt=adoptService.findByAdoptNo(no);
		if(findAdopt.getAdoptNo()==null) {
			throw new Exception();
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
		return new ResponseEntity<AdoptDto>(dto,httpHeaders,HttpStatus.OK);
		
	}
	
	
	@Operation(summary = "no로 입양 수정하기")
	@PutMapping("/{no}")
	public ResponseEntity<AdoptDto> updateAdopt(@PathVariable Long no,@RequestBody AdoptDto dto) throws Exception {
	Adopt findAdopt=adoptService.findByAdoptNo(no);
		findAdopt.setAdoptTime(dto.getAdoptTime());
		findAdopt.setAdoptDate(dto.getAdoptDate());
		findAdopt.setAdoptStatus(dto.getAdoptStatus());
		//findAdopt.setPet(dto.getPet());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
		return new ResponseEntity<AdoptDto>(dto,httpHeaders,HttpStatus.CREATED);
	}

	@DeleteMapping("/{no}")
	public ResponseEntity<Map> deleteAdopt(@PathVariable(name = "no") Long no) throws Exception {
		adoptService.deleteAdopt(no);
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());

	}
	
	
	@GetMapping("/all")
	public ResponseEntity<AdoptDto> findAllAdopts(@RequestBody AdoptDto dto) {
		List<Adopt> adoptList=adoptService.findAdoptList();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
		return new ResponseEntity<AdoptDto>(dto,httpHeaders,HttpStatus.OK);
	}

	@GetMapping("/find/{userNo}")
	public ResponseEntity<List<Adopt>> findAdoptsByUserNo(@PathVariable(name = "userNo") Long userNo) {
		return ResponseEntity.status(HttpStatus.OK).body(adoptService.findAdoptsByUserNo(userNo));
	}
	*/
}
