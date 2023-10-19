package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Coupon;
import com.itwill.entity.Userinfo;

class CouponDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	CouponDao couponDao;
	@Autowired
	UserInfoDao userInfoDao;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test() {
		Userinfo userinfo = userInfoDao.findById("전아현");
		Coupon coupon = Coupon.builder()
							.couponDiscount(30)
							.couponExpirationDate(LocalDateTime.now().plusDays(60))
							.couponId(null)
							.couponName("가입쿠폰")
							.couponPayday(LocalDateTime.now())
							.userinfo(userinfo)
							.build();
		couponDao.Create(coupon);
		
		 userinfo = userInfoDao.findById("전아현");
		 coupon = Coupon.builder()
				.couponDiscount(30)
				.couponExpirationDate(LocalDateTime.now().plusDays(30))
				.couponId(null)
				.couponName("생일쿠폰")
				.couponPayday(LocalDateTime.now())
				.userinfo(userinfo)
				.build();
		couponDao.Create(coupon);
		
		
	}

}
