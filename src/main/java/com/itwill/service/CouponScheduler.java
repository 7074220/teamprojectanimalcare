package com.itwill.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Coupon;
import com.itwill.entity.MyPet;
import com.itwill.entity.Userinfo;

@Component
@Service
public class CouponScheduler {
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private MyPetService myPetService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Scheduled(cron = "0 1 11 * * ?")
	@Transactional
	public void CreateBirthdayCoupon() throws Exception {
		
		System.out.println("스케줄 되니?");
		
		List<Userinfo> userinfoList = userInfoService.findUserList();
		Coupon birthCoupon = Coupon.builder()
									.couponDiscount(30)
									.couponName("생일쿠폰")
									.build();
		birthCoupon.setCouponDate(30L);
		
		for (Userinfo userinfo : userinfoList) {
			MyPet myPetLeader = myPetService.findLeaderMyPet(userinfo.getUserNo());
			birthCoupon.setUserinfo(userinfo);
			couponService.Create(birthCoupon);
			if(myPetLeader.getMypetBirthday().equals(LocalDateTime.now())){
			}
			
		}
		
		
	}
		
}
