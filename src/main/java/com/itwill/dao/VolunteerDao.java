package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Volunteer;

public interface VolunteerDao {

	public Volunteer insertVolunteer(Volunteer volunteer);

	public Volunteer findByVolunteerNo(Long volunteerNo);

	public Volunteer updateVolunteer(Volunteer volunteer) throws Exception;
	
	public void deleteVolunteer(Long no);
	
	public List<Volunteer> findAllVolunteer();	
	
	//public Volunteer selectVolunteer(Long no);
	
	
	
}
