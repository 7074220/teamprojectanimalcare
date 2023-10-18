package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Userinfo;
import com.itwill.repository.UserinfoRepository;

class UserInfoDaoImplTest {
	
	@Autowired
	UserInfoDaoImpl userInfoDaoImpl;
	
	@Transactional
	@Rollback(false)
	@Test
	void test1() {
		Userinfo userinfo = Userinfo.builder().userId("장").build();
		userInfoDaoImpl.CreateUser(userinfo);
	}

}
