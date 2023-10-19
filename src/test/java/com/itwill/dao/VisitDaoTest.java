package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;

import jakarta.transaction.Transactional;

@SpringBootTest
class VisitDaoTest {
	@Autowired
	VisitDao visitDao;

	@Autowired
	UserInfoDao userInfoDao;

	@Autowired
	CenterDao centerDao;

	@Transactional
	@Rollback(false)
	@Test
	//@Disabled
	void insetVisit() {
		Visit visit = Visit.builder()
				.visitNo(null)
				.visitDate(LocalDate.now())
				.visitstatus("접수완료")
				.visitTime(7L)
				.userinfo(userInfoDao.findById("김창섭"))
				.center(centerDao.findByCenterNo(2L))
				.build();
		visitDao.createVisit(visit);
	}
	
	@Test
	@Transactional
	@Disabled
	void selectVisit() {
		Visit selectVisit = visitDao.findByVisitNo(2L);
		System.out.println(selectVisit);
	}
	
}



