package com.itwill.dao;


import java.util.List;

import com.itwill.entity.Userinfo;

public interface UserInfoDao {
	
	public Userinfo CreateUser(Userinfo userinfo);
	
	public void DeleteUser(Long userNo);
	
	public Userinfo UpdateUser(Userinfo userinfo);
	
	public List<Userinfo> findAll();
	
	public Userinfo findByNo(Long userNo);
	
	public Integer countByUserId(String userId);

	public Userinfo findByUserEmail(String userEmail);
	
	public Userinfo findByUserPassword(String userId , String userPhoneNumber);
	
	public Userinfo findByUserId(String userId);
	
}