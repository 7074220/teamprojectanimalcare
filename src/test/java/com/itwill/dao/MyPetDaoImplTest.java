package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
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
		
		myPetDao.CreatePet(null);
	}

}
