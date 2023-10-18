package com.itwill.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Coupon {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE )
	 private Long couponId;
     
	 private String couponName;
	 private String couponDiscount;
	 private String couponExpirationDate;
	 private String couponPayday;
	 
	 @ManyToOne()
	 private Userinfo userinfo = new Userinfo();
}
