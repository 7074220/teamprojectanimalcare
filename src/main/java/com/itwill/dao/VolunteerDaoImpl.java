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
	public List<Volunteer> findAll() {		
		return volunteerRepository.findAll();
	}
	
	@Override
	public Volunteer insertVolunteer(Volunteer volunteer) {
		volunteerRepository.save(volunteer);
		return volunteer;
	}

	@Override
	public Volunteer selectVolunteer(Long no) {
		Volunteer selectVolunteer = volunteerRepository.findById(no).get();
		return selectVolunteer;
	}

	@Override
	public Volunteer updateVolunteer(Volunteer updateVolunteer) throws Exception {
		Optional<Volunteer> findVolunteerOptional = volunteerRepository.findById(updateVolunteer.getVolunteerNo());
		Volunteer updatedVolunteer = null;
		if(findVolunteerOptional.isPresent()) {
			Volunteer volunteer = findVolunteerOptional.get();
			updateVolunteer = volunteerRepository.save(volunteer);
		} else {
			throw new Exception("존재안함" + updateVolunteer.getVolunteerNo());
		}
		
		return updatedVolunteer;
	}

	@Override
	public void deleteVolunteer(Long no) throws Exception {
		Optional<Volunteer> selectedVolunteerOptional = volunteerRepository.findById(no);
		
		volunteerRepository.delete(selectedVolunteerOptional.get());
		
	}

	
	
	 
	
	
}
