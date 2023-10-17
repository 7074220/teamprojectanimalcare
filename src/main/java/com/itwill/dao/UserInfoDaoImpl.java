package com.itwill.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		
		return null;
	}
	
	@Override
	public Userinfo UpdateUser() {
		
		return null;
	}
	
	
	

}
