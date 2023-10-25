package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.CartDao;
import com.itwill.dao.UserInfoDao;
import com.itwill.dao.WishDao;
import com.itwill.entity.Wish;
import com.itwill.repository.WishRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class WishServiceImpl implements WishService {

	@Autowired
	private WishRepository wishrepoRepository;
	@Autowired
	private WishDao wishDao;
	@Autowired
	private UserInfoDao userinfoDao;
	
	@Override
	public Wish insertWish(Wish wish) {
		Wish insert = wishDao.insertWish(wish);
		return insert;
	}

	@Override
	public void deleteWish(Long no) throws Exception {
		wishDao.deleteWish(no);
		
	}

	@Override
	public List<Wish> findAllWishByUserNo(Long userNo) {
		return wishDao.findAllWishByUserNo(userNo);
	}

	
}
