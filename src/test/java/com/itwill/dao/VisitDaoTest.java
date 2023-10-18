package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;

class VisitDaoTest {

	@Test
	void test() {
		VisitDao visitDao = new VisitDaoImpl();
		Visit visit = new Visit();
		visit.setVisitNo(1L);
		visit.setVisitDate(LocalDate.now());
		visit.setCenter(new Center()); // Center 객체 생성 필요
		visit.setVisitstatus("예약완료");
		visit.setVisitTime(12345L);
		visit.setUserinfo(new Userinfo()); // Userinfo 객체 생성 필요

		visitDao.createVisit(visit);

	
	}
}