package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;

class VolunteerServiceImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	VolunteerService volunteerService;
	
	@Test
	@Disabled
	void testFindByVolunteerNo() {
		
	}

	@Test
	@Disabled
	void testInsertVolunteer() {
		
	}

	@Test
	@Disabled
	void testUpdateVolunteer() {
		
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
	void testFindVolunteertByUserId() {
		
	}

}
