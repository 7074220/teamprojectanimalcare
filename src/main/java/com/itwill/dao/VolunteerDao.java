package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Volunteer;

public interface VolunteerDao {
	
	public List<Volunteer> findAll();
	
	public Volunteer findById(Long volunteerNo);

	public Volunteer createVolunteer(Volunteer volunteer);
	
	public Volunteer updateVolunteer(Volunteer volunteer) throws Exception;
	
	public void DeleteVolunteer(Long volunteerNo);
	
	
}
