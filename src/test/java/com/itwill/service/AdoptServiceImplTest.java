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
	@Disabled
	void insertTest() throws Exception {
		Userinfo user=userInfoService.findUser("박태환");
		Pet pet1=petService.petFindById(10L);
		Pet pet2=petService.petFindById(11L);
		
		Adopt insertAdopt1 = Adopt.builder()
				.adoptDate(LocalDate.now())
				.adoptTime(13L)
				.status("입양신청")
				.pet(pet1)
				.userinfo(user)
				.build();
		adoptService.insertAdopt(insertAdopt1);
		Adopt insertAdopt2 = Adopt.builder()
				.adoptDate(LocalDate.now())
				.adoptTime(16L)
				.status("입양완료")
				.pet(pet2)
				.userinfo(user)
				.build();
		adoptService.insertAdopt(insertAdopt2);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void updateTest() throws Exception{
		Adopt adopt=adoptService.findByNoAdopt(9L);
			adopt.setStatus("입양중");
			adoptService.updateAdopt(adopt);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteTest() throws Exception {
		adoptService.deleteAdopt(9L);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findByNoTest() {
		adoptService.findByNoAdopt(9L);
		System.out.println(adoptService.findByNoAdopt(9L));
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findAllTest() {
		System.out.println(adoptService.findAdoptList());
	}
	
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void findByUserinfoUserIdTest() {
		System.out.println(	adoptService.findByUserinfoUserId("박태환"));
	}
	
	

}
