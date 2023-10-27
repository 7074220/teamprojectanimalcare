package com.itwill.entity;



import java.util.Calendar;
import java.util.Date;

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
import jakarta.persistence.PrePersist;
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
     @SequenceGenerator(name = "Coupon_coupon_id_SEQ",allocationSize = 1,initialValue = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Coupon_coupon_id_SEQ")
     private Long couponId;
	 private String couponName;
	 private Integer couponDiscount;
	 @CreationTimestamp
	 private Date couponPayday;
	 private Date couponExpirationDate;
	 
	 @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	 @Builder.Default
	 @JoinColumn(name = "user_no")
	 @ToString.Exclude
	 private Userinfo userinfo = new Userinfo();
	 
		/*
		 * @PrePersist public void setExpirationDate() { Calendar calendar =
		 * Calendar.getInstance(); calendar.setTime(couponPayday);
		 * 
		 * // couponPayday에서 30일을 더하여 couponExpirationDate를 설정합니다.
		 * calendar.add(Calendar.DAY_OF_MONTH, 30);
		 * 
		 * couponExpirationDate = calendar.getTime(); }
		 */
	 
}

