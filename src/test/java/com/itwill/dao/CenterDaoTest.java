package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;

import jakarta.transaction.Transactional;
@SpringBootTest
class CenterDaoTest {
	@Autowired
	CenterDao centerDao;

	@Transactional
	@Rollback(false)
	@Test
	@Disabled
	void insetCenter() {


		Center center = Center.builder()
				.centerNo(null)
				.centerName("가나다보호소")
				.centerPhoneNumber("010-1234-1234")
				.centerOpenCloseTime("09:00~17:00")
				.centerLocal("경상도")
				.build();
		centerDao.createCenter(center);
	}
	
	@Test
	@Disabled
	@Transactional
	void  selectCenter() {
		Center selectCenter = centerDao.findByCenterNo(11L);
		System.out.println(selectCenter);
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	@Disabled
	void deleteCenter()throws Exception {
		centerDao.deleteCenter(1L);
	}
	@Test
	@Transactional
	@Rollback(value = false)
	@Disabled
	void updateCenter() {
		Center findCenter =  centerDao.findByCenterNo(2L);
		findCenter.setCenterName("일이삼보호소");
		System.out.println(findCenter);
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	//@Disabled
	void findByContainsTest() {
		List<Center> findCenter = centerDao.findByContains("이");
		System.out.println(findCenter);
	}
}
