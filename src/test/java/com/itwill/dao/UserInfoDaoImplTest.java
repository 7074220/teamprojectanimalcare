package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Userinfo;




class UserInfoDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	UserInfoDao userinfoDao;
	
	//@Disabled
	void test1() {
		Userinfo userinfo = Userinfo.builder().userId("장").build();
		userinfoDao.CreateUser(userinfo);
	}
	
	
	
	

}
