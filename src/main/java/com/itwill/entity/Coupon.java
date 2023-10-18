package com.itwill.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
     @SequenceGenerator(name = "coupon_id_seq",sequenceName = "coupon_id_seq",allocationSize = 1,initialValue = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "coupon_id_seq")
	 private Long couponId;
     
	 private String couponName;
	 private String couponDiscount;
	 private String couponExpirationDate;
	 private String couponPayday;
	 
	 @ManyToOne(cascade = CascadeType.PERSIST)
	 @Builder.Default
	 private Userinfo userinfo = new Userinfo();
}
