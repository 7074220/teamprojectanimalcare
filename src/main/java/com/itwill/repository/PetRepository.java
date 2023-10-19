package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Pet;
@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
	//최신 등록순으로 정렬
	List<Pet> findAllByOrderByPetNoDesc();
	
	
}
