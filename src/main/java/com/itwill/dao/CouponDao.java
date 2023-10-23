package com.itwill.dao;


import java.util.Date;
import java.util.List;

import com.itwill.entity.Coupon;

public interface CouponDao {
	
	public Coupon Create(Coupon coupon);
	
	public void DelteById(Long couponId);
	
	public void autoDeleteExpiredCoupons(Date couponExpirationDate);
	
	public List<Coupon> findAll();
	
	public Coupon findById(Long couponId);
	
}

