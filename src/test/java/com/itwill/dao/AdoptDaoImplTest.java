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
	void insertTest() {
		
		Userinfo userinfo1 = userInfoDao.findById("박태환");
		Userinfo userinfo2 = userInfoDao.findById("전아현");
		Userinfo userinfo3 = userInfoDao.findById("김창섭");
		
		Pet pet1 = petDao.petFindById(3L);
		Pet pet2 = petDao.petFindById(4L);
		Pet pet3 = petDao.petFindById(2L);
		
		
		Adopt adopt1 = Adopt.builder() 
							.adoptDate(LocalDate.now())
							.adoptTime(11L)
							.pet(pet1)
							.status("입양중")
							.userinfo(userinfo1)
							.build();
		adoptDao.insertAdopt(adopt1);
		
		Adopt adopt2 = Adopt.builder() 
				.adoptDate(LocalDate.now())
				.adoptTime(10L)
				.pet(pet2)
				.status("입양완료")
				.userinfo(userinfo2)
				.build();
		adoptDao.insertAdopt(adopt2);
		Adopt adopt3 = Adopt.builder() 
				.adoptDate(LocalDate.now())
				.adoptTime(16L)
				.pet(pet3)
				.status("입양완료")
				.userinfo(userinfo3)
				.build();
		adoptDao.insertAdopt(adopt3);
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteTest() throws Exception{
		adoptDao.deleteAdopt(3L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		adoptDao.findAdoptList();
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findById() {
		adoptDao.findByNoAdopt(1L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateTest() throws Exception{
		Adopt adopt=adoptDao.findByNoAdopt(2L);
		adopt.setAdoptDate(null);
		adopt.setAdoptTime(null);
		adopt.setPet(null);
		adopt.setStatus(null);
		adoptDao.updateAdopt(adopt);
		
	}
	
	
	
}
