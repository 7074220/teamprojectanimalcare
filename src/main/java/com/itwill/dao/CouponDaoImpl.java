package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.entity.Coupon;
import com.itwill.repository.CouponRepository;

public class CouponDaoImpl implements CouponDao{
	@Autowired
	CouponRepository couponRepository;
	
	@Override
	public Coupon Create(Coupon coupon) {
		couponRepository.save(coupon);
		return coupon;
	}
	
	// 쿠폰 만료일 자동삭제 구현해야함
	@Override
	public void DelteById(Long couponId) {
		if(couponRepository.findById(couponId).isPresent()) {
			couponRepository.deleteById(couponId);
		}
	}
	
	@Override
	public Coupon findById(Long couponId) {
		return couponRepository.findById(couponId).get();
	}
	
	@Override
	public List<Coupon> findAll() {
		return couponRepository.findAll();
	}
	
}
