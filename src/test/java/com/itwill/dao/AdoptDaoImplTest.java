package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Adopt;
import com.itwill.entity.Center;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;


@SpringBootTest
class AdoptDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	AdoptDao adoptDao;
	@Autowired
	PetDao petDao;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	CenterDao centerDao;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void insertTest() {
		
		Userinfo userinfo1 = userInfoDao.findByNo(1L);
		Userinfo userinfo2 = userInfoDao.findByNo(2L);
		
		
		//Pet pet1 = petDao.petFindById(1L);
		//Pet pet2 = petDao.petFindById(2L);
		
		Pet pet1 = Pet.builder()
				.petType("포메")
				.petCharacter("귀여움")
				.petFindPlace("서울")
				.petGender("여")
				.petLocal("인천")
				.petRegisterDate(new Date())
				.center(centerDao.findByCenterNo(1L))
				.build();
		petDao.petInsert(pet1);
		
		Pet pet2 = Pet.builder()
				.petType("푸들")
				.petCharacter("사나움")
				.petFindPlace("부산")
				.petGender("남")
				.petLocal("광주")
				.petRegisterDate(new Date())
				.center(centerDao.findByCenterNo(2L))
				.build();
		petDao.petInsert(pet2);
		
		
		
		
		Adopt adopt1 = Adopt.builder() 
							.adoptDate(new Date())
							.adoptTime(11)
							.pet(pet1)
							.adoptStatus("입양중")
							.userinfo(userinfo1)
							.build();
		adoptDao.insertAdopt(adopt1);
		
		Adopt adopt2 = Adopt.builder() 
				.adoptDate(new Date())
				.adoptTime(10)
				.pet(pet2)
				.adoptStatus("입양중")
				.userinfo(userinfo2)
				.build();
		adoptDao.insertAdopt(adopt2);
		
		
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteTest() throws Exception{
		adoptDao.deleteAdopt(6L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		System.out.println(adoptDao.findAdoptList());
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findById() {
		System.out.println(adoptDao.findByNoAdopt(6L));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateTest() throws Exception{
		Adopt adopt=adoptDao.findByNoAdopt(6L);
		//adopt.setAdoptTime(12L);
		adopt.setAdoptStatus("입양완료");
		adoptDao.updateAdopt(adopt);
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void selectByUserId() {
		System.out.println(adoptDao.findByUserinfoUserId("박태환"));
	}
	
}
