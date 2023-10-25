package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.dao.CartDao;
import com.itwill.dao.UserInfoDao;
import com.itwill.dao.WishDao;
import com.itwill.entity.Wish;
import com.itwill.repository.WishRepository;

public class WishServiceImpl implements WishService {

	@Autowired
	private WishRepository wishrepoRepository;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private UserInfoDao userinfoDao;
	
	@Override
	public Wish insertWish(Wish wish) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWish(Long no) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Wish> findAllWishByUserNo(Long userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
