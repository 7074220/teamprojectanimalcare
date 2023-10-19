package com.itwill.service;

import java.util.List;

import com.itwill.entity.MyPet;

public interface MyPetService {
	
	// 마이펫 등록
	public MyPet Create(MyPet myPet);
	
	// 마이펫 업데이트
	public MyPet Update(MyPet myPet);
	
	// 마이펫 삭제
	public void Delete(Long myPetNo);
	
	// 마이펫 리스트
	public List<MyPet> findAll();
	
}
