package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Coupon;

class CouponDaoImplTest extends TeamprojectAnimalcareApplicationTest{
	
	@Autowired
	CouponDao couponDao;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test() {
		Coupon coupon = Coupon.builder()
							.couponDiscount(30)
							.couponExpirationDate(null)
							.couponId(null)
							.couponName(null)
							.couponPayday(null)
							.build();
		couponDao.Create(null);
	}

}
