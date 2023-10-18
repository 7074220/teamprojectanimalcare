package com.itwill.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Userinfo;
import com.itwill.repository.UserinfoRepository;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	UserinfoRepository userinfoRepository;
	
	@Override
	public Userinfo CreateUser(Userinfo userinfo) {
		userinfoRepository.save(userinfo);
		
		return userinfo;
	}
	
	@Override
	public void DeleteUser(String userId) {
		userinfoRepository.deleteById(userId);
	}
	
	@Override
	public List<Userinfo> findAll() {
		return userinfoRepository.findAll();
	}
	
	@Override
	public Userinfo findById(String userId) {
		return userinfoRepository.findById(userId).get();
	}
	
	@Override
	public Userinfo UpdateUser(Userinfo userinfo) {
		return userinfoRepository.save(userinfo);
	}
	
	@Override
	public Integer countByUserId(String userId) {
		return userinfoRepository.countByUserId(userId);
	}
	
	// 이메일로 아이디찾기
	@Override
	public Userinfo findByUserEmail(String userEmail) {
		return userinfoRepository.findByUserEmail(userEmail);
	}
	
	// 아이디,폰번호로 비밀번호찾기
	@Override
	public Userinfo findByUserPassword(String userId, String userPhoneNumber) {
		return userinfoRepository.findByUserPassword(userId, userPhoneNumber);
	}
	
	
	
}
