package com.itwill.entity;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Coupon {
     @Id
     @SequenceGenerator(name = "coupon_coupon_id_seq",sequenceName = "coupon_coupon_id_seq",allocationSize = 1,initialValue = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "coupon_coupon_id_seq")
	 private Long couponId;
     
	 private String couponName;
	 private Integer couponDiscount;
	 
	 private LocalDateTime couponExpirationDate;
	 
	 @CreationTimestamp
	 private LocalDateTime couponPayday;
	 
	 @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	 @Builder.Default
	 @JoinColumn(name = "user_id")
	 @ToString.Exclude
	 private Userinfo userinfo = new Userinfo();
}
