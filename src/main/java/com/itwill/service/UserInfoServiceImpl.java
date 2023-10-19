package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.UserInfoDao;
import com.itwill.entity.Userinfo;
import com.itwill.exception.ExistedUserException;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	UserInfoDao userInfoDao;
	
	// 회원가입
	@Override
	public Userinfo create(Userinfo user) throws Exception {
		// 아이디 중복확인
		if(userInfoDao.countByUserId(user.getUserId()) > 0 ){
			 ExistedUserException exception=
					new ExistedUserException(user.getUserId()+" 는 이미 존재하는아이디입니다.");
			exception.setData(user);
			throw exception;
		}
		// 가입성공
		return user;
	}
	
	@Override
	public Userinfo update(Userinfo user) throws Exception {

		return null;
	}
	
	@Override
	public int remove(String userId) throws Exception {

		return 0;
	}
	
	@Override
	public Userinfo findUser(String userId) throws Exception {

		return null;
	}
	
	@Override
	public List<Userinfo> findUserList() throws Exception {

		return null;
	}
	
	@Override
	public boolean isDuplicateId(String userId) throws Exception {

		return false;
	}
	
	@Override
	public Userinfo login(String userId, String password) throws Exception {

		return null;
	}
	
}
