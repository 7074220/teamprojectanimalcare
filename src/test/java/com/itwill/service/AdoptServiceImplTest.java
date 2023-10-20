package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Adopt;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;

class AdoptServiceImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	AdoptService adoptService;
	@Autowired
	PetService petService;
	@Autowired
	UserInfoService userInfoService;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void insertTest() throws Exception {
		Userinfo user=userInfoService.findUser("박태환");
		Pet pet=petService.petFindById(1L);
		
		Adopt insertAdopt = Adopt.builder()
				.adoptDate(LocalDate.now())
				.adoptTime(13L)
				.status("입양신청")
				.pet(pet)
				.userinfo(user)
				.build();
		adoptService.insertAdopt(insertAdopt);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void updateTest() {
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteTest() throws Exception {
		adoptService.deleteAdopt(null);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findByNoTest() {
		adoptService.findByNoAdopt(null);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAllTest() {
		adoptService.findAdoptList();
	}
	
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findByUserinfoUserIdTest() {
		adoptService.findByUserinfoUserId("박태환");
	}
	
	

}
