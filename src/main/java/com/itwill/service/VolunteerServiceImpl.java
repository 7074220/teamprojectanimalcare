package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.entity.Center;
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
		Optional<Volunteer> optionalVolunteer = volunteerRepository.findById(volunteer.getVolunteerNo());
		
		if (optionalVolunteer.isPresent()) {
			Volunteer findVolunteer = optionalVolunteer.get();
			
			findVolunteer.setVolunteerDate(volunteer.getVolunteerDate());
			findVolunteer.setVolunteerTime(volunteer.getVolunteerTime());
			findVolunteer.setVolunteerStatus(volunteer.getVolunteerStatus());
			findVolunteer.setCenter(volunteer.getCenter());
			
			return findVolunteer;
		} else {
			
			throw new Exception("정보를 찾을 수 없습니다.");
		}
		
		/*
		Volunteer updateVolunteer = Volunteer.builder()
											 .volunteerDate(volunteer.getVolunteerDate())
											 .volunteerTime(volunteer.getVolunteerTime())
											 .volunteerStatus(volunteer.getVolunteerStatus())
											 .center(volunteer.getCenter())
											 .build();
		*/
	}

	@Override
	public Volunteer findById(Long no) {
		Volunteer findVolunteer = volunteerRepository.findById(no).get();
		return findVolunteer;
	}

	@Override
	public void deleteVolunteer(Long no) throws Exception {
		volunteerRepository.deleteById(no);
		
	}

	@Override
	public List<Volunteer> selectAllVolunteers() {
		return volunteerRepository.findAll();
	}
	
	
}
