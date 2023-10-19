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
	@Autowired
	CenterDao centerDao;

	/*
	@Test
	@Disabled
	void testFindAll() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	
	void testInsertVolunteer() {

		/*
		Userinfo userinfo = Userinfo.builder() 
							.userId("최") .userPassword("8888")
							.userPoint(8888) .userGender("여") .userAddress("부산")
							.userPhoneNumber("8888-8888") .userEmail("888a") .userResidentNumber("8888")
							.userResisterDate(LocalDateTime.now()) .build();
		 */
		
		Userinfo userinfo = userInfoDao.findById("김");
		
		Center center = Center.builder()
							  .centerNo(88L)
							  .centerName("안녕보호소")
							  .centerPhoneNumber("000-1111-2222")
							  .centerLocal("서울시 강남구")
							  .centerOpenCloseTime("24시")
							  .build();
		
		Volunteer volunteer = Volunteer.builder()
									   .volunteerDate(LocalDate.now())
									   .volunteerNo(4L)
									   .volunteerTime(15L)
									   .volunteerStatus("입양완료")
									   .userinfo(userinfo)
									   .center(center)
									   .build();

		Volunteer savedVolunteer1 = volunteerDao.insertVolunteer(volunteer);
		System.out.println(savedVolunteer1);
		
		/*
		 * volunteer.setCenter(center); volunteer.setUserinfo(userinfo);
		 * 
		 * volunteerDao.insertVolunteer(savedVolunteer1);
		 */

	}

	/*
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
	*/
}
