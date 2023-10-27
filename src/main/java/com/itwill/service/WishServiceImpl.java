package com.itwill.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.UserInfoDao;
import com.itwill.dao.WishDao;
import com.itwill.entity.Wish;
import com.itwill.repository.WishRepository;

@Service
public class WishServiceImpl implements WishService {

	@Autowired
	private WishRepository wishrepoRepository;
	@Autowired
	private WishDao wishDao;
	@Autowired
	private UserInfoDao userinfoDao;
	
	
	@Override
	public Wish insertWish(Wish insertWish) {
		
		Wish wish1 = wishrepoRepository.findByUserNoProductNo(insertWish.getUserinfo().getUserNo(), insertWish.getProduct().getProductNo());
		System.out.println(">>>>>>>>>>>>>>>>>" + wish1);
		/*
		 * Optional<Wish> wish2 = wishrepoRepository.findById(1L);
		 * System.out.println(wish1.isPresent()); System.out.println(wish2.isPresent());
		 * if (wish1.isPresent() && wish2.isPresent()) {
		 * System.out.println("이미 존재하는 상품입니다."); return null; } else { Wish wish = new
		 * Wish(); wish.setProduct(insertWish.getProduct());
		 * wish.setUserinfo(insertWish.getUserinfo());
		 * 
		 * 
		 * return wishDao.insertWish(wish); }
		 */
		return null;
	}

	@Override
	public void deleteWish(Long no) throws Exception {
		wishDao.deleteWish(no);
		
	}

	@Override
	public List<Wish> findAllWishByUserNo(Long userNo) {
		return wishDao.findAllWishByUserNo(userNo);
	}

	@Override
	public Wish findByWishNo(Long no) {
		Wish selectedWish = wishDao.findByWishNo(no);
		return selectedWish;
	}

	@Override
	public Wish findByUserNoProductNo(Long userNo, Long productNo) {
		Wish selectedWish = wishDao.findByUserNoProductNo(userNo, productNo);
		return selectedWish;
	}


	
}
