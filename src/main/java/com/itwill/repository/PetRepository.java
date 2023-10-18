package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{
	List<Pet> findAllByOrderByPetNoDesc(Long petNo);
	
	
}
