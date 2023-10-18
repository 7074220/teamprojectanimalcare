package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTests;
import com.itwill.entity.Userinfo;
import com.itwill.repository.UserinfoRepository;

class UserInfoDaoImplTest extends TeamprojectAnimalcareApplicationTests{
	
	@Autowired
	UserInfoDao userinfoDao;
	
	@Transactional
	@Rollback(false)
	@Test
	void test1() {
		Userinfo userinfo = Userinfo.builder().userId("장").build();
		userinfoDao.CreateUser(userinfo);
	}

}
