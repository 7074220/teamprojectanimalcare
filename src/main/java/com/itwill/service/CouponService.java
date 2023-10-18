package com.itwill.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import com.itwill.dao.CouponDao;


public class CouponService {
	
	@Autowired
	private CouponDao couponDao;

	
}
