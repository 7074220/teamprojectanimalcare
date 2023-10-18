package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
	
}
