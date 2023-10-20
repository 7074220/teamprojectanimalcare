package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;
import com.itwill.repository.VolunteerRepository;

class VolunteerServiceImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	VolunteerService volunteerService;
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	CenterService centerService;
	@Autowired
	VolunteerRepository volunteerRepository;
	
	@Test
	@Disabled
	void testFindByVolunteerNo() {
		System.out.println(volunteerService.findByVolunteerNo(2L));
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsertVolunteer() throws Exception{
		
		Userinfo userinfo = userInfoService.findUser("박태환");
		Center center = centerService.findByCenterNo(22L);
		
		Volunteer volunteer = Volunteer.builder()
										.volunteerDate(LocalDate.now())
										.volunteerTime(20L)
										.volunteerStatus("서비스테스트")
										.center(center)
										.userinfo(userinfo)
										.build();
		volunteerService.insertVolunteer(volunteer);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(value = false)
	void testUpdateVolunteer() throws Exception{
		Volunteer volunteer = volunteerService.findByVolunteerNo(1L);
		volunteer.setVolunteerStatus("테스트진행중");
		volunteerService.updateVolunteer(volunteer);
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
	void testFindAllVolunteers() {
		System.out.println(volunteerService.findAllVolunteers());
	}

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testFindVolunteertByUserId() {
		System.out.println(volunteerRepository.findVolunteertByUserId("전아현"));
	}

}
