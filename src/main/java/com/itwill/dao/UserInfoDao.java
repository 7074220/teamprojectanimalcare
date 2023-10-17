package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Userinfo;

public interface UserInfoDao {
	
	public Userinfo CreateUser(Userinfo userinfo);
	
	public void DeleteUser(String userId);
	
	public Userinfo UpdateUser();
	
	public List<Userinfo> findAll();
	
	public Userinfo findById(String userId);
	
	
}
