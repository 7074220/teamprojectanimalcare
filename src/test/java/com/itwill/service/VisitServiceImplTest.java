package com.itwill.service;

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
class VisitServiceImplTest {
	@Autowired
	VisitService visitService;
	
	@Autowired
	CenterService centerService;
	
	@Autowired
	UserInfoService userInfoService;
	
	@Transactional
	@Rollback(value = false)
	@Disabled
	@Test
	void insertVisit() throws Exception {
		Visit insertVisit = Visit.builder()
				.visitNo(null)
				.userinfo(userInfoService.findUser("김창섭"))
				.visitTime(3L)
				.visitDate(LocalDate.now())
				.center(centerService.findByCenterNo(4L))
				.visitstatus("접수중")
				.build();
		visitService.createVisit(insertVisit);
	}
	
	@Test
	@Transactional
	//@Disabled
	void selectVisit() {
		Visit selectVisit = visitService.findByVisitNo(1L);

	    
		    System.out.println(selectVisit);
		 
	}

}
