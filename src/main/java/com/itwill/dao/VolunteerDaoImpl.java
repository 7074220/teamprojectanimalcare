package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Volunteer;
import com.itwill.repository.VolunteerRepository;

@Repository
public class VolunteerDaoImpl implements VolunteerDao{
	@Autowired
	VolunteerRepository volunteerRepository;

	@Override
	public Volunteer insertVolunteer(Volunteer volunteer) {
		volunteerRepository.save(volunteer);
		return volunteer;
	}

	@Override
	public Volunteer findByVolunteerNo(Long no) {
		return volunteerRepository.findById(no).get();
	}

	@Override
	public Volunteer updateVolunteer(Volunteer updateVolunteer) throws Exception {
		Optional<Volunteer> findVolunteerOptional = volunteerRepository.findById(updateVolunteer.getVolunteerNo());
		
		if(findVolunteerOptional.isPresent()) {
			Volunteer volunteer = findVolunteerOptional.get();
			return volunteerRepository.save(volunteer);
			
		} else {
			throw new Exception("존재안함" + updateVolunteer.getVolunteerNo());
		}
		
		
	}
	
	/*
	@Override
	public void deleteVolunteer(Long no) {
		volunteerRepository.deleteById(no);		
	}
	*/
	
	@Override
	public void deleteVolunteer(Long no) throws Exception{
		Optional<Volunteer> selectVolunteer = volunteerRepository.findById(no);
		if(selectVolunteer.isPresent()) {
			volunteerRepository.delete(selectVolunteer.get());
		}
		
	}
	

	@Override
	public List<Volunteer> findVolunteerList() {
		return volunteerRepository.findAll();
	}

	
	@Override
	public List<Volunteer> findVolunteertByUserNo(Long no) {
		return volunteerRepository.findVolunteertByUserNo(no);
	}
	
	
}
