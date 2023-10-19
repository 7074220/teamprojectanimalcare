package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;


class VolunteerDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	VolunteerDao volunteerDao;
	@Autowired
	UserInfoDao userInfoDao;

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsertVolunteer() { // 정보 등록
		
		//Userinfo userinfo = Userinfo.builder().userId("박태환").build();
		
		Userinfo userinfo = userInfoDao.findById("박태환");
		
		Center center = Center.builder()
							  .centerNo(11L)
							  .centerName("안녕보호소")
							  .centerPhoneNumber("010-1111-1111")
							  .centerLocal("서울시")
							  .centerOpenCloseTime("1시")
							  .build();
		
		Volunteer volunteer1 = Volunteer.builder()
									   .volunteerDate(LocalDate.now())
									   .volunteerNo(4L)
									   .volunteerTime(15L)
									   .volunteerStatus("방문신청완료")
									   .userinfo(userinfo)
									   .center(center)
									   .build();
		
		Volunteer volunteer2 = Volunteer.builder()
				   					   .volunteerDate(LocalDate.now())
				   					   .volunteerNo(5L)
				   					   .volunteerTime(18L)
				   					   .volunteerStatus("방문신청접수")
				   					   .userinfo(userinfo)
				   					   .center(center)
				   					   .build();
		
		volunteerDao.insertVolunteer(volunteer1);
		volunteerDao.insertVolunteer(volunteer2);
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testUpdatVolunteer() { // 정보 수정
		Volunteer volunteer = volunteerDao.findById(7L);
		volunteer.setVolunteerTime(00L);
		volunteer.setVolunteerDate(LocalDate.now());
		volunteer.setVolunteerStatus("수정테스트");
		
	}
	
	
	@Test
	//@Disabled
	void selectAll() {
		System.out.println(volunteerDao.selectAll());
	}


	@Test
	@Disabled
	void testSelectVolunteer() {
		
	}
	

	@Test
	@Disabled
	void testDeleteVolunteer() {
		fail("Not yet implemented");
	
	}

}
