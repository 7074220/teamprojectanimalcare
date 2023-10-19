package com.itwill.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import com.itwill.dao.CouponDao;
import com.itwill.entity.Coupon;


public interface CouponService {
	
	// 쿠폰지급
	public Coupon Create();
	// 쿠폰삭제
	public void Delete();
	// 쿠폰 리스트
	public List<Coupon> findAll();
	// 쿠폰 찾기
	public Coupon findById(Long couponId);
	
}
