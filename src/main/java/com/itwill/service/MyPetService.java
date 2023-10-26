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

	// 마이펫 전체 리스트
	public List<MyPet> findAll();

	// 마이펫 리스트
	public List<MyPet> findMyPetListByuserNo(Long userNo);

	//마이펫 하나만 삭제
	public void deleteMypetNoByUserNo(Long userNo, Long mypetNo);
}
