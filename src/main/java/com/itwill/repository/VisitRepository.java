package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.Userinfo;

public interface VisitRepository extends JpaRepository<Userinfo, String>{
	
}
