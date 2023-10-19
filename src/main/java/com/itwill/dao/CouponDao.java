package com.itwill.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.itwill.entity.Coupon;

public interface CouponDao {
	
	public Coupon Create(Coupon coupon);
	
	public void DelteById(Long couponId);
	
	public void customDeleteExpiredCoupons(LocalDateTime date);
	
	public List<Coupon> findAll();
	
	public Coupon findById(Long couponId);
	
}
