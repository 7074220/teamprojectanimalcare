package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
	
	/*
	@Query(value = "SELECT * FROM volunteer WHERE user_id = :userId", nativeQuery = true)
	List<Volunteer> findVolunteerByUserId(@Param("userId") String userId);
	*/

	List<Volunteer> findVolunteertByUserId(String userId);
	
}
