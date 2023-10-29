package com.itwill.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	
	@Scheduled(cron = "0 58 17 * * ?")
	public void CreateBirthdayCoupon() throws Exception {
		List<Userinfo> userinfoList = userInfoService.findUserList();
		Coupon birthCoupon = Coupon.builder()
									.couponDiscount(30)
									.couponName("생일쿠폰")
									.build();
		birthCoupon.setCouponDate(30L);
		
		/*for (Userinfo userinfo : userinfoList) {
			MyPet myPetLeader = myPetService.findLeaderMyPet(userinfo.getUserNo());
			couponService.Create(birthCoupon);
			//if(myPetLeader.getMypetBirthday().equals(LocalDateTime.now())){
			//}
			
		}
		
		
	}*/
		
		 for (Userinfo userinfo : userinfoList) {
		        MyPet myPetLeader = myPetService.findLeaderMyPet(userinfo.getUserNo());
		        if (myPetLeader.getMypetBirthday() != null && myPetLeader.getMypetBirthday().equals(LocalDate.now())) {
		            // 생일인 경우에만 쿠폰 생성 및 저장
		            Coupon createdCoupon = couponService.Create(birthCoupon);
		            // 생성된 쿠폰을 사용자에게 지급할 수 있습니다.
		            // 예: userinfo 또는 myPetLeader에 쿠폰 정보 추가
		        }
		    }
		}
	
	
}
