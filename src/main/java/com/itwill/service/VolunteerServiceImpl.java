package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.entity.Volunteer;
import com.itwill.repository.VolunteerRepository;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	
	@Autowired
	private VolunteerRepository volunteerRepository;

	@Override
	public Volunteer insertVolunteer(Volunteer volunteer) {
		return volunteerRepository.save(volunteer);
	}

	@Override
	public Volunteer updateVolunteer(Volunteer volunteer) throws Exception {
		// TODO Auto-generated method stub 
		return null;
	}

	@Override
	public Volunteer findById(Long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVolunteer(Long no) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Volunteer> selectAllVolunteers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}
