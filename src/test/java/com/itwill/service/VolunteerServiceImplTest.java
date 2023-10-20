package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.dao.UserInfoDao;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;


class VolunteerServiceImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	VolunteerService volunteerService;
	@Autowired
	UserInfoDao userInfoDao;

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsertVolunteer() {
		
		Userinfo userinfo = userInfoDao.findById("박태환");
		
		Center center = Center.builder()
							  .centerNo(33L)
							  .centerName("하하보호소")
							  .centerPhoneNumber("010-3333-3333")
							  .centerLocal("강원도")
							  .centerOpenCloseTime("09:00 ~ 23:00")
							  .build();
		
		Volunteer volunteer = Volunteer.builder()
									   .volunteerDate(LocalDate.now())
									   .volunteerNo(5L)
									   .volunteerTime(33L)
									   .volunteerStatus("테스트하는중")
									   .userinfo(userinfo)
									   .center(center)
									   .build();
		Volunteer savedVolunteer = volunteerService.insertVolunteer(volunteer);
		System.out.println(savedVolunteer);
		
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testUpdateVolunteer() {
		Volunteer volunteer = volunteerService.findById(1L);
		volunteer.setVolunteerStatus("심사중");
		
		LocalDate tomorrow = LocalDate.now().plusDays(1); 
		volunteer.setVolunteerDate(tomorrow);
		// [volunteer.setVolunteerDate(LocalDate.now().plusDays(1));]
		
		volunteer.setVolunteerTime(23L); 
	}

	@Test
	@Disabled
	@Transactional
	void testFindById() {
		//System.out.println(volunteerService.findById(1L));
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testDeleteVolunteer() throws Exception{
		volunteerService.deleteVolunteer(1L);
	}

	@Test
	@Disabled
	@Transactional
	void testSelectAllVolunteers() {
		
	}

}
