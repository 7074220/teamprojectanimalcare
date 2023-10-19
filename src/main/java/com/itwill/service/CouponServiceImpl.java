package com.itwill.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.itwill.dao.CouponDao;
import com.itwill.entity.Coupon;

@Service
public class CouponServiceImpl implements CouponService{
	
	@Autowired
	CouponDao couponDao;
	
	@Override
	public Coupon Create() {
		return  couponDao.Create(null);
		
	}
	
	@Override
	public void Delete() {
		
		
	}
	
	@Override
	public List<Coupon> findAll() {
		return null;
	}
	@Override
	public Coupon findById(Long couponId) {
		return couponDao.findById(couponId);
				
			
				
	}
	
	
	
}
