package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

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
		/*
		Userinfo userinfo = userInfoDao.findById("박태환");
		MyPet myPet = MyPet.builder()
							.mypetNo(null)
							.mypetName("보리")
							.mypetKind("강아지")
							.mypetBirthday(LocalDateTime.of(2021, 5, 17, 0, 0))
							.userinfo(userinfo)
							.build();
		
		myPetDao.CreatePet(myPet);
		*/
		/*
		Userinfo userinfo = userInfoDao.findById("전성기");
		MyPet myPet = MyPet.builder()
					.mypetNo(null)
					.mypetName("율무")
					.mypetKind("강아지")
					.mypetBirthday(LocalDateTime.of(2022, 11, 11, 0, 0))
					.userinfo(userinfo)
					.build();
		
		myPetDao.CreatePet(myPet);
		*/
		Userinfo userinfo = userInfoDao.findById("김창섭");
		MyPet myPet = MyPet.builder()
					.mypetNo(null)
					.mypetName("나비")
					.mypetKind("고양이")
					.mypetBirthday(LocalDateTime.of(2023, 5, 5, 0, 0))
					.userinfo(userinfo)
					.build();
		
		myPetDao.CreatePet(myPet);
	}
	@Disabled
	void test2() {
		
	}

}
