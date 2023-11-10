package com.itwill.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Adopt;
import com.itwill.entity.Center;
import com.itwill.entity.Pet;
import com.itwill.entity.Volunteer;
import com.itwill.service.AdoptService;
import com.itwill.service.CartService;
import com.itwill.service.CenterService;
import com.itwill.service.MyPetService;
import com.itwill.service.OrderService;
import com.itwill.service.PetService;
import com.itwill.service.ProductService;
import com.itwill.service.UserInfoService;
import com.itwill.service.VolunteerService;
import com.itwill.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

public class AdminRestController {

	@Autowired
	private CenterService centerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AdoptService adoptService;
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private PetService petService;
	
	

	/******************************* Adopt ************************************/
	
	
	@Operation(summary = "no로 삭제")
	@DeleteMapping("/{adoptNo}")
	public ResponseEntity<Map> deleteAdopt(@PathVariable(value = "adoptNo") Long adoptNo) throws Exception {
		try {
			adoptService.deleteAdopt(adoptNo);
			return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("adoptNo", adoptNo));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
	
	
	@Operation(summary = "봉사삭제")
	@DeleteMapping("/{volunteerNo}")
	public ResponseEntity<Map> VolunteerDelete(@PathVariable(name = "volunteerNo") Long volunteerNo) throws Exception{
		volunteerService.deleteVolunteer(volunteerNo);	
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	} // DELETE
	
	

	
	
	@Operation(summary = "봉사 부분 업데이트") 
	@PutMapping("/{volunteerNo}")
	public ResponseEntity<VolunteerDto> updateVolunteer(@PathVariable(name = "volunteerNo") Long volunteerNo, @RequestBody VolunteerDto dto) throws Exception {
	    Volunteer existingVolunteer = volunteerService.findByVolunteerNo(volunteerNo);

	    if (existingVolunteer == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        if (dto.getVolunteerTime() != null) {
	            existingVolunteer.setVolunteerTime(dto.getVolunteerTime());
	        }
	        if (dto.getVolunteerDate() != null) {
	            existingVolunteer.setVolunteerDate(dto.getVolunteerDate());
	        }
	        if (dto.getVolunteerStatus() != null) {
	            existingVolunteer.setVolunteerStatus(dto.getVolunteerStatus());
	        }	
	        if (dto.getCenterNo() != null) {
	        	Center center = centerService.findByCenterNo(dto.getCenterNo());
	            existingVolunteer.setCenter(center);
	        }
  
	        volunteerService.updateVolunteer(existingVolunteer);
	        VolunteerDto updatedVolunteerDto = VolunteerDto.toDto(existingVolunteer);
	        return new ResponseEntity<>(updatedVolunteerDto, HttpStatus.OK);
	    }
	} // UPDATE
	
	
	
	
	
	/******************************* Pet ************************************/
	
	
	@Operation(summary = "펫 삭제")	
	@DeleteMapping("/{petNo}")
	public ResponseEntity<Map> petDelete(@PathVariable(name = "petNo") Long petNo) throws Exception{
		Optional<Pet> petOptional = Optional.of(petService.petFindById(petNo));
		if(petOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
			}
			petService.petRemove(petNo);
			return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
		}
	
	
	
	
	
	/******************************* Product ************************************/
	
	
	
	@Operation(summary = "상품 삭제 (관리자)")
	@DeleteMapping("/{no}")
	// delete
	public ResponseEntity deleteProduct(@PathVariable(name = "no") Long no, HttpSession session) throws Exception{
	
		HttpHeaders httpHeaders = new HttpHeaders();
		
		productService.deleteProduct(no);
		return new ResponseEntity(httpHeaders, HttpStatus.OK);
	}
	
}
