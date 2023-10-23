package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Volunteer;

public interface VolunteerDao {

	public Volunteer insertVolunteer(Volunteer volunteer);
	
	public Volunteer findByVolunteerNo(Long no);

	public Volunteer updateVolunteer(Volunteer volunteer) throws Exception;
	
	public void deleteVolunteer(Long no) throws Exception;
	
	// 전체조회
	public List<Volunteer> findVolunteerList();

	// userNo 로 Volunteer 조회
	public List<Volunteer> findVolunteertByUserNo(Long no);	
	
	
}
