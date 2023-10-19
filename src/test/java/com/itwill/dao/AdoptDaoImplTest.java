package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Adopt;
import com.itwill.entity.Center;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;


@SpringBootTest
class AdoptDaoImplTest {

	@Autowired
	AdoptDao adoptDao;
	@Autowired
	PetDao petDao;
	@Autowired
	UserInfoDao userInfoDao;

	
	
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test() {
		
		Userinfo userinfo1 = userInfoDao.findById("박태환");
		Pet pet = Pet.builder()
				.petNo(null)
				.petLocal("서울")
				.petType("포메")
				.petgender("여")
				.petCharacter("귀여움")
				.petFindPlace("서울")
				.petRegisterDate(LocalDate.now())
				.center(null)
				.build();
		petDao.petInsert(pet);
		
		
		
		Adopt adopt = Adopt.builder() 
							.adoptNo(1L)
							.adoptDate(LocalDate.now())
							.adoptTime(11L)
							.pet(pet)
							.status("입양완료")
							.userinfo(userinfo1)
							.build();
		adoptDao.insertAdopt(adopt);
		
	}

}
