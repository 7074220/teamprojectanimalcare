package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.UserInfoDao;
import com.itwill.entity.Userinfo;
import com.itwill.exception.ExistedUserException;
import com.itwill.exception.PasswordMismatchException;
import com.itwill.exception.UserNotFoundException;

@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserInfoDao userInfoDao;
	
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
		return userInfoDao.CreateUser(user);
	}
	/*
	 * 회원수정
	 */
	@Override
	public Userinfo update(Userinfo user) throws Exception {
		return userInfoDao.UpdateUser(user);
	}
	/*
	 * 회원탈퇴
	 */
	@Override
	public void remove(Long userNo) throws Exception {
		userInfoDao.DeleteUserByNo(userNo);
	}
	
	// 아이디로 찾기
	public Userinfo findByUserId(String userId) {
		return userInfoDao.findByUserId(userId); 
	}
	
	// 상세보기
	@Override
	public Userinfo findUserByNo(Long userNo) throws Exception {
		return userInfoDao.findByNo(userNo);
	}
	
	// 전체회원리스트
	@Override
	public List<Userinfo> findUserList() throws Exception {
		return userInfoDao.findAll();
	}
	
	@Override
	public Userinfo login(String userId, String password) throws Exception {
		Userinfo userinfo = userInfoDao.findByUserId(userId);
		Userinfo fUser= Userinfo.builder().userId(userId).userPassword(password).build();
		
		if(userinfo == null) {
			UserNotFoundException exception = 
					new UserNotFoundException(userId+" 는 존재하지않는 아이디입니다.");
			exception.setData(fUser);
			throw exception;
		}
		String userPassword = userinfo.getUserPassword();
		if(!userPassword.equals(password)) {
			//패쓰워드불일치
			PasswordMismatchException exception=
				new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
			exception.setData(fUser);
			throw exception;
		}
		
		return userinfo;
	}
	
}
