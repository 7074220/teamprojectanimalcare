package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.MyPet;
import com.itwill.entity.Userinfo;

class MyPetDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	MyPetDao myPetDao;
	@Autowired
	UserInfoDao userInfoDao;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test() {
		
		Userinfo userinfo = userInfoDao.findById("박태환");
		MyPet myPet = MyPet.builder()
							.mypetNo(null)
							.mypetName("보리")
							.mypetKind("강아지")
							.mypetBirthday(new Date())
							.userinfo(userinfo)
							.build();
		
		myPetDao.CreatePet(myPet);
		
		
		userinfo = userInfoDao.findById("전아현");
		myPet = MyPet.builder()
					.mypetNo(null)
					.mypetName("율무")
					.mypetKind("강아지")
					.mypetBirthday(new Date())
					.userinfo(userinfo)
					.build();
		
		myPetDao.CreatePet(myPet);
		
		userinfo = userInfoDao.findById("김창섭");
		myPet = MyPet.builder()
					.mypetNo(null)
					.mypetName("나비")
					.mypetKind("고양이")
					.mypetBirthday(new Date())
					.userinfo(userinfo)
					.build();
		
		myPetDao.CreatePet(myPet);
	}
	@Disabled
	void test2() {
		
	}

}
