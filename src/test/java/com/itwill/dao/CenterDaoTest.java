package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

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
	void insetVisit() {


		Center center = Center.builder()
				.centerNo(null)
				.centerName("가나다보호소")
				.centerPhoneNumber("010-1234-1234")
				.centerOpenCloseTime("09:00~17:00")
				.centerLocal("경상도")
				.build();
		centerDao.createCenter(center);
	}

}
