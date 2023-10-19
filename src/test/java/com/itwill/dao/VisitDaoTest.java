package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

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
	void insetVisit() {
		userInfoDao.findById("김창섭");	

		Visit visit = Visit.builder()
				.visitNo(null)
				.visitDate(LocalDate.now())
				.visitstatus("접수완료")
				.visitTime(7L)
			
				.build();
		visitDao.createVisit(visit);
	

	}
}