package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Optional<Wish> findProductNo = wishrepoRepository.findById(insertWish.getProduct().getProductNo());
		Optional<Wish> findUserNo = wishrepoRepository.findById(insertWish.getUserinfo().getUserNo());
		if (findUserNo.isPresent()  && findProductNo.isEmpty()) {
			System.out.println("이미 존재하는 상품입니다.");
		} else {
			Wish wish = new Wish(); // Wish 객체를 생성
	        wish.setProduct(insertWish.getProduct()); // 또는 필요한 다른 설정을 수행
	        wish.setUserinfo(insertWish.getUserinfo());
	        wishrepoRepository.save(wish);
		}
		
		return insertWish;
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
