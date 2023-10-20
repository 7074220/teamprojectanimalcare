package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Volunteer;

public interface VolunteerDao {

	public Volunteer insertVolunteer(Volunteer volunteer);

	public Volunteer findByVolunteerNo(Long no);

	public Volunteer updateVolunteer(Volunteer volunteer) throws Exception;
	
	public void deleteVolunteer(Long no) throws Exception;
	
	public List<Volunteer> findVolunteerList();

	public List<Volunteer> findVolunteertByUserId(String userId);	
	
	//public List<Volunteer> findVolunteertByUserId(String userId);
	
	
}
