package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;

import jakarta.transaction.Transactional;

@SpringBootTest
class VolunteerDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Autowired
	VolunteerDao volunteerDao;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	CenterDao centerDao;

	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void testInsertVolunteer() {
		
		//Userinfo userinfo = Userinfo.builder().userId("박태환").build();
		
		/*
		Userinfo userinfo1 = userInfoDao.findById("박태환");
		Userinfo userinfo2 = userInfoDao.findById("전아현");

		Center center = Center.builder()
							  .centerNo(11L)
							  .centerName("안녕보호소")
							  .centerPhoneNumber("010-1111-1111")
							  .centerLocal("서울시")
							  .centerOpenCloseTime("09:00 ~ 21:00")
							  .build();
		*/
		
		Volunteer volunteer1 = Volunteer.builder()
									   .volunteerDate(LocalDate.now())
									   .volunteerNo(2L)
									   .volunteerTime(11L)
									   .volunteerStatus("봉사접수중t")
									   .userinfo(userInfoDao.findById("박태환"))
									   .center(centerDao.findByCenterNo(11L))
									   .build();
		
		Volunteer volunteer2 = Volunteer.builder()
				   					   .volunteerDate(LocalDate.now())
				   					   .volunteerNo(3L)
				   					   .volunteerTime(13L)
				   					   .volunteerStatus("심사중t")
				   					   .userinfo(userInfoDao.findById("전아현"))
				   					   .center(centerDao.findByCenterNo(22L))
				   					   .build();
		
		volunteerDao.insertVolunteer(volunteer1);
		volunteerDao.insertVolunteer(volunteer2);
		
	}
	
	
	@Test
	@Disabled
	@Transactional
	void testSelectVolunteer() {
		Volunteer selectVolunteer = volunteerDao.findByVolunteerNo(3L);
		System.out.println(selectVolunteer);
		//System.out.println(volunteerDao.selectVolunteer(7L));
	}

	
	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testUpdatVolunteer() {
		Volunteer volunteer = volunteerDao.findByVolunteerNo(3L);
		volunteer.setVolunteerTime(99L);
		
		LocalDate tomorrow = LocalDate.now().plusDays(1); 
		volunteer.setVolunteerDate(tomorrow);
		
		//volunteer.setVolunteerDate(LocalDate.now());
		volunteer.setVolunteerStatus("리셋테스트");
		
		System.out.println(volunteer);
		
	}

	

	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testDeleteVolunteer() throws Exception {
		volunteerDao.deleteVolunteer(5L);
		
	}

}
