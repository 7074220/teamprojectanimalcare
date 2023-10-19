package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.entity.Volunteer;
import com.itwill.repository.CenterRepositoty;
import com.itwill.repository.UserinfoRepository;
import com.itwill.repository.VolunteerRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

class VolunteerDaoImplTest {
	
	@Autowired
	VolunteerRepository volunteerRepository;
	@Autowired
	UserinfoRepository userinfoRepository;
	@Autowired
	CenterRepositoty centerRepositoty;

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
		Volunteer volunteer = Volunteer.builder()
								.volunteerNo(1L)
								.volunteerTime(11L)
								.volunteerDate(LocalDate.now())
								.userinfo(null)
								.build();
		
		// System.out.println(volunteer);
		
		// volunteerRepository.save(volunteer);
		
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
