package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.Adopt;


public interface AdoptRepository extends JpaRepository<Adopt, Long>{
	
}
