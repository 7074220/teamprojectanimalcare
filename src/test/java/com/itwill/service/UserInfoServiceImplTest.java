package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;

class UserInfoServiceImplTest extends TeamprojectAnimalcareApplicationTest{

	
	@Autowired
	UserInfoService userInfoService;
	
	@Test
	@Disabled
	void test() throws Exception {
		Userinfo userinfo=Userinfo.builder()
							.userId("장희주")
							.build();
		Userinfo createUser=userInfoService.create(userinfo);
		System.out.println(createUser);
	
	
	
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void test1() throws Exception {
		Userinfo loginUser=userInfoService.login("전아현","3333");
		System.out.println(loginUser);
		
		
		
	}
	
	@Test
	@Disabled
	void test2() throws Exception {
		Userinfo loginUser=userInfoService.findUser("김창섭");
		loginUser.setUserGender("여");
		userInfoService.update(loginUser);
		System.out.println(loginUser);
		
		}
	
	@Test
	@Disabled
	void test3() throws Exception {
		userInfoService.remove("장희주");
		
		
	}
	
	
	@Test
	//@Disabled
	void test4() throws Exception {
		System.out.println(userInfoService.findUserList());
		
	}

	
	
	
	
	
}
