package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Userinfo;




class UserInfoDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	UserInfoDao userinfoDao;
	
	@Test

	//@Disabled
	void test1() {
		Userinfo userinfo = new Userinfo("email", "1111", "테스트");
		System.out.println(userinfo);
		userinfoDao.CreateUser(userinfo);
	}
	@Test
	@Disabled
	void test2() {
		
		userinfoDao.DeleteUser("장");
	}
	
	@Test
	@Disabled
	void test3() {
		System.out.println(userinfoDao.findAll());
	}
	@Test
	@Disabled
	void test4() {
		System.out.println(userinfoDao.findById("김"));
	}
	@Test
	@Disabled
	void test5() {
		Userinfo userinfo = userinfoDao.findById("김");
		//userinfo.setUserAddress("제주도");
		System.out.println(userinfoDao.UpdateUser(userinfo));
	}
	@Test
	@Disabled
	void test6() {
		 
		 System.out.println(userinfoDao.countByUserId("김"));
		
	}
	@Test
	@Disabled
	void test7() {
		
		System.out.println(userinfoDao.findByUserEmail("222a"));
		
	}
	
	@Test
	@Disabled
	void test8() {
		
		System.out.println(userinfoDao.findByUserPassword("전", "3333"));
		
	}
	
	
	
	

}
