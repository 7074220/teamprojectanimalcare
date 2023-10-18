package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.MyPet;

public interface MyPetRepository extends JpaRepository<MyPet, Long>{
	
}
