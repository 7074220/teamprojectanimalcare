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
		Volunteer savedVolunteer = volunteerRepository.save(volunteer);
		return savedVolunteer;
	}

	@Override
	public Volunteer findByVolunteerNo(Long volunteerNo) {
		return volunteerRepository.findById(volunteerNo).get();
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

	@Override
	public void deleteVolunteer(Long volunteerNo) {
		volunteerRepository.deleteById(volunteerNo);
		
	}

	@Override
	public List<Volunteer> findAllVolunteer() {
		return volunteerRepository.findAll();
	}

	
}
