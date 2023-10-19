package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

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
	
	@Test
	@Transactional
	@Rollback(value = false)
	@Disabled
	void deleteVisit()throws Exception {
		visitDao.deleteVisit(1L);
	}
	@Test
	@Transactional
	@Rollback(value = false)
	@Disabled
	void updateVisit() {
		Visit findVisit = visitDao.findByVisitNo(1L);
		findVisit.setVisitstatus("승인완료");
		System.out.println(findVisit);
	}
	
//	@Test
//	@Transactional
//	@Rollback(value = false)
//	@Disabled
//	void findByUserUserId() {
//		 List<Userinfo> userinfos = userInfoDao.findByUserUserId("아무개");
//	System.out.println(userinfos);
//	}
}



