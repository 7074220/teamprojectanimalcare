package com.itwill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Volunteer;

public interface VolunteerService {
	
	Volunteer findByVolunteerNo(Long no); // 봉사 목록 찾기
	
	Volunteer insertVolunteer(Volunteer volunteer);
	
	Volunteer updateVolunteer(Volunteer volunteer) throws Exception;

	void deleteVolunteer(Long no) throws Exception;
	
	List<Volunteer> findAllVolunteers(); // 봉사 목록 전체 찾기

	List<Volunteer> findVolunteertByUserNo(Long no); // userNo 로 목록 검색

	
}
