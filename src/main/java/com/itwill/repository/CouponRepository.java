package com.itwill.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

  @Query(value="select * from coupon where ?1 < TRUNC(sysdate)",nativeQuery = true ) 
  List<Coupon> findByExpirationDateBefore(Date couponExpirationDate);

  
}

	 
