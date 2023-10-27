package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Pet;

public interface PetDao {

	Pet petFindById(Long petNo); //pk로 찾기
	
	List<Pet> petFindAll(); // 펫 전부 찾기
	
	Pet petInsert(Pet pet); // 펫 추가
	
	void petDelete(Long petNo) throws Exception;
	
	Pet petUpdate(Pet pet) throws Exception;//펫 업데이트
	
	List<Pet> findAllByOrderBypetNoDesc();// 펫 no순으로 최신등록순 정렬
	 List<Pet> findAllByOrderByPetType(String petType);
}
