package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.MyPet;

public interface MyPetRepository extends JpaRepository<MyPet, Long>{
	
	@Query(value = "select * from mypet where user_no=?1",nativeQuery = true)
	public List<MyPet> findMyPetListByuserNo(Long userNo);
	
	
	@Query(value="delete from mypet where user_no=?1 and mypet_no=?2",nativeQuery = true)
	public MyPet deleteMypetNoByUserNo(Long userNo,Long mypetNo);
	
	
	
	
	
	
	
}
