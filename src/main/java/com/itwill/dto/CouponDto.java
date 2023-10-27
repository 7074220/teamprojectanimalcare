package com.itwill.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.itwill.entity.Coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CouponDto {

	private Long couponId;
	private String couponName;
	private Integer couponDiscount;
	private Date couponPayday;
	private Date couponExpirationDate;
	
	public static CouponDto toDto(Coupon coupon) {
		
		CouponDto couponDto=CouponDto.builder()
				.couponId(coupon.getCouponId())
				.couponName(coupon.getCouponName())
				.couponDiscount(coupon.getCouponDiscount())
				.couponExpirationDate(coupon.getCouponExpirationDate())
				.couponPayday(coupon.getCouponPayday())
				.build();
		return couponDto;
	}
	
	
}
