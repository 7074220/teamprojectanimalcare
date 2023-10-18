package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.TeamprojectAnimalcareApplicationTest;

class UserInfoDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
	
	@Test
	void test() {
		userInfoDaoImpl.findById("장");
	}

}
