package com.itwill.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Coupon;
import com.itwill.repository.CouponRepository;

@Repository
public class CouponDaoImpl implements CouponDao {

	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Coupon Create(Coupon coupon) {
		couponRepository.save(coupon);
		return coupon;
	}

	// 쿠폰 만료일 자동삭제 구현해야함
	@Override
	public void DelteById(Long couponId) {
		if (couponRepository.findById(couponId).isPresent()) {
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

	// 만료된 쿠폰찾기
	@Override
	public List<Coupon> autoDeleteExpiredCoupons(Date couponExpirationDate) {
		return couponRepository.findByExpirationDateBefore(couponExpirationDate);
	}

	@Override
	public List<Coupon> findAllByUserNo(Long userNo) {
		return couponRepository.findAllByUserNo(userNo);
	}

	@Override
	public List<Coupon> findExpireCouponByUserNo(Date date, Long userNo) {
		
		return couponRepository.findExpireCouponByUserNo(date, userNo);
	}

}
