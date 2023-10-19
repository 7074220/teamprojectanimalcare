package com.itwill.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

	
	  //쿠폰만료일이 되면 자동소멸 되는 기능
	  
	  @Query(value="select * from coupon where ?1 < TRUNC(sysdate)",nativeQuery =
	  true ) List<Coupon> findByExpirationDateBefore(LocalDateTime
	  couponExpirationDate);
	  
	 
	//void deleteByExpirationDateBefore(LocalDateTime date);

}