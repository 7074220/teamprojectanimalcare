package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;
import com.itwill.repository.VolunteerRepository;

import jakarta.transaction.Transactional;

class VolunteerDaoImplTest {
	
	@Autowired
	VolunteerDao volunteerDao;
	@Autowired
	VolunteerRepository volunteerRepository;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	CenterDao centerDao;
	

	@Test
	@Disabled
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void testInsertVolunteer() {
		
		/*
		 * Userinfo userinfo = Userinfo.builder() .userId("최") .userPassword("8888")
		 * .userPoint(8888) .userGender("여") .userAddress("부산")
		 * .userPhoneNumber("8888-8888") .userEmail("888a") .userResidentNumber("8888")
		 * .userResisterDate(LocalDateTime.now()) .build();
		 */
		
		Volunteer volunteer = Volunteer.builder()
								.volunteerDate(LocalDate.now())
								.volunteerNo(4L)
								.volunteerTime(15L)
								//.userinfo(userinfo)
								.build();
		
		// System.out.println(volunteer);
		
		volunteerDao.insertVolunteer(volunteer);
		
		
	}

	@Test
	@Disabled
	void testSelectVolunteer() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUpdateVolunteer() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteVolunteer() {
		fail("Not yet implemented");
	}

}
