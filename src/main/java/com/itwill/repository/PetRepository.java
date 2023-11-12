package com.itwill.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Center;
import com.itwill.entity.Pet;
@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
	//최신 등록순으로 정렬
	List<Pet> findAllByOrderByPetNoDesc();
	
	//펫 타입으로 정렬
	@Query(value = "select * from Pet where pet_type like %:petType%", nativeQuery = true)
	List<Pet> findByPetType(@Param("petType") String petType);
	
	
	//지역으로 정렬
		@Query(value = "select * from Pet where pet_local =:petLocal", nativeQuery = true)
		List<Pet> findByPetLocal(@Param("petLocal") String petLocal);
		
}
