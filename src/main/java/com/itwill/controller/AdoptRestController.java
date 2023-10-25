package com.itwill.controller;

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

import com.itwill.entity.Adopt;
import com.itwill.service.AdoptService;

@RestController
@RequestMapping("/adopt")
public class AdoptRestController {

	@Autowired
	private AdoptService adoptService;

	@PostMapping
	public ResponseEntity<Adopt> insertAdopt(@RequestBody Adopt adopt) {
		return ResponseEntity.status(HttpStatus.OK).body(adoptService.insertAdopt(adopt));
	}

	@GetMapping("/{no}")
	public ResponseEntity<Adopt> findByAdoptNo(@PathVariable(value = "no") Long no) {
		return ResponseEntity.status(HttpStatus.OK).body(adoptService.findByAdoptNo(no));
	}

	@PutMapping
	public ResponseEntity<Adopt> updateAdopt(@PathVariable Long no,@RequestBody Adopt adopt) throws Exception {
	Adopt findAdopt=adoptService.findByAdoptNo(no);
		findAdopt.setAdoptTime(adopt.getAdoptTime());
		findAdopt.setAdoptDate(adopt.getAdoptDate());
		findAdopt.setAdoptStatus(adopt.getAdoptStatus());
		findAdopt.setPet(adopt.getPet());
		
		return ResponseEntity.status(HttpStatus.OK).body(adoptService.updateAdopt(findAdopt));
	}

	@DeleteMapping("/{no}")
	public ResponseEntity<Map> deleteAdopt(@PathVariable(name = "no") Long no) throws Exception {
		adoptService.deleteAdopt(no);
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());

	}
	
	/*
	@GetMapping
	public ResponseEntity<List<Adopt>> findAdoptList() {
		return ResponseEntity.status(HttpStatus.OK).body(adoptService.findAdoptList());
	}

	@GetMapping("/find/{userNo}")
	public ResponseEntity<List<Adopt>> findAdoptsByUserNo(@PathVariable(name = "userNo") Long userNo) {
		return ResponseEntity.status(HttpStatus.OK).body(adoptService.findAdoptsByUserNo(userNo));
	}
	*/
}
