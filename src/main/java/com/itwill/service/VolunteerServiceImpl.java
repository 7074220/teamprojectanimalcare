package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.VolunteerDao;
import com.itwill.entity.Center;
import com.itwill.entity.Volunteer;
import com.itwill.repository.VolunteerRepository;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	
	@Autowired
	VolunteerDao volunteerDao;
	VolunteerRepository volunteerRepository;

	@Override
	public Volunteer findByVolunteerNo(Long no) {
		return volunteerDao.findByVolunteerNo(no);
	} //봉사 목록 찾기

	@Override
	public Volunteer insertVolunteer(Volunteer volunteer) {
		return volunteerDao.insertVolunteer(volunteer);
	}

	@Override
	public Volunteer updateVolunteer(Volunteer volunteer) throws Exception {
		return volunteerDao.updateVolunteer(volunteer);
	}

	@Override
	public void deleteVolunteer(Long no) throws Exception {
		volunteerDao.deleteVolunteer(no);
	}

	@Override
	public List<Volunteer> findAllVolunteers() {
		return volunteerDao.findVolunteerList();
	} //봉사목록 전체

	@Override
	public List<Volunteer> findVolunteertByUserId(String userId) {
		return volunteerRepository.findVolunteertByUserId(userId);
	} // 유저아이디로 봉사 목록
	
	
	
}
