package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;

import jakarta.transaction.Transactional;

@SpringBootTest
class VisitDaoTest {
	@Autowired
	VisitDao visitDao;

	@Transactional
	@Rollback(false)
	@Test
	void insetVisit() {
		
		Visit visit = Visit.builder()
				.visitNo(1L)
				.visitDate(LocalDate.now())
				.visitstatus("준비중")
				.visitTime(5L)
				//.userinfo(null)
				//.center(11)
				.build();
		visitDao.createVisit(visit);

	}
}