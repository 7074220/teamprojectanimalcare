package com.itwill.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

  @Query(value="select * from coupon where ?1 < TRUNC(sysdate)",nativeQuery = true ) 
  List<Coupon> findByExpirationDateBefore(Date couponExpirationDate);

  //유저에 대한 쿠폰 리스트 뽑기
  @Query(value="select * from coupon where user_no=?1",nativeQuery = true)
  List<Coupon> findAllByUserNo(Long userNo);
  
  @Query(value="select * from coupon where ?1 < TRUNC(sysdate) and user_no=?2",nativeQuery = true ) 
  List<Coupon> findExpireCouponByUserNo(Date date , Long userNo);
  
}

	 
