package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.MyPetDao;
import com.itwill.entity.MyPet;

@Service
public class MyPetServiceImpl implements MyPetService{
	
	@Autowired
	MyPetDao myPetDao;
	
	// 마이펫 입력
	@Override
	public MyPet Create(MyPet myPet) {
		return myPetDao.CreatePet(myPet);
	}
	
	// 마이펫 삭제
	@Override
	public void Delete(Long myPetNo) {
		myPetDao.DeletePet(myPetNo);
	}
	
	// 마이펫 수정
	@Override
	public MyPet Update(MyPet myPet) {
		return myPetDao.UpdatePet(myPet);
	}
	
	// 마이펫 전체 리스트
	@Override
	public List<MyPet> findAll() {
		return myPetDao.findAll();
	}

	@Override
	public List<MyPet> findMyPetListByuserNo(Long userNo) {
		return myPetDao.findMyPetListByuserNo(userNo);
	}

	@Override
	public void deleteMypetNoByUserNo(Long userNo, Long mypetNo) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
