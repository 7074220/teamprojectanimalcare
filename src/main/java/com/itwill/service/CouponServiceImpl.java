package com.itwill.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.CouponDao;
import com.itwill.entity.Coupon;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{
	
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public Coupon Create(Coupon coupon,Integer period) {
		// 60일을 더할 Calendar 객체 생성
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(coupon.getCouponPayday());
	    calendar.add(Calendar.DAY_OF_MONTH, period);

	    // Calendar 객체에서 Date로 변환하여 couponExpirationDate 필드에 설정
	    coupon.setCouponExpirationDate(calendar.getTime());
		return couponDao.Create(coupon);
	}
	
	@Override
	public void Delete(Long couponId) {
		couponDao.DelteById(couponId);
	}
	
	@Override
	public List<Coupon> findAll() {
		return couponDao.findAll();
	}
	@Override
	public Coupon findById(Long couponId) {
		return couponDao.findById(couponId);
	}

	@Override
	public List<Coupon> findAllByUserNo(Long userNo) {
		return couponDao.findAllByUserNo(userNo);
	}
	
	@Override
	public List<Coupon> autoDeleteExpiredCoupons(Date couponExpirationDate) {
		return couponDao.autoDeleteExpiredCoupons(couponExpirationDate);
	}
	
	@Override
	public List<Coupon> findExpireCouponByUserNo(Date date, Long userNo) {
		
		return couponDao.findExpireCouponByUserNo(date, userNo);
	}
	
}
