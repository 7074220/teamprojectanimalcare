package com.itwill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Volunteer;

public interface VolunteerService {
	
	Volunteer insertVolunteer(Volunteer volunteer);
	
	Volunteer updateVolunteer(Volunteer volunteer) throws Exception;
	
	Volunteer findById(Long no);

	void deleteVolunteer(Long no) throws Exception;
	
	List<Volunteer> selectAllVolunteers();
	
	
}
