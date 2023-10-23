package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;

@SpringBootTest
class VolunteerDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	VolunteerDao volunteerDao;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	CenterDao centerDao;
	

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testInsertVolunteer() {
		
		Userinfo userinfo = userInfoDao.findById("김창섭");
		
		Center center = centerDao.findByCenterNo(2L);	
	
		Volunteer volunteer = Volunteer.builder()
									   .userinfo(userinfo)
									   .center(center)
									   .volunteerDate(new Date())
									   .volunteerTime(11)
									   .volunteerStatus("심사중t")
									   .build();	
		volunteerDao.insertVolunteer(volunteer);
		
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void selectVolunteer() {
		Volunteer selectVolunteer = volunteerDao.findByVolunteerNo(2L);
		System.out.println(selectVolunteer);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testUpdateVolunteer() throws Exception{
		Volunteer volunteer = volunteerDao.findByVolunteerNo(2L);
		volunteer.setVolunteerTime(12);
		volunteer.setVolunteerStatus("봉사완료a");
		volunteerDao.updateVolunteer(volunteer);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testDeleteVolunteer() throws Exception{
		volunteerDao.deleteVolunteer(1L);
	}
	
	
	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testFindVolunteerByUserId() {
		List<Volunteer> selectVolunteer = volunteerDao.findVolunteertByUserId("전아현");
		System.out.println(selectVolunteer);
	}
	
}
