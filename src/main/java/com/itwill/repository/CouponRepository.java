package com.itwill.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{
	
	 //List<Coupon> findByExpirationDateBefore(LocalDateTime date);
}
