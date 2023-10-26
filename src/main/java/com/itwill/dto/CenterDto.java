package com.itwill.dto;

import com.itwill.entity.Center;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CenterDto {

	
	private String centerName; 
	//센터이름
	private String centerPhoneNumber;
	//센터전화번호
	private String centerLocal;
	//센터지역
	private String centerOpenCloseTime;
	//센터영업시간
	
	public static Center toEntity(CenterDto entity) {
		return Center.builder()
				.centerName(entity.getCenterName())
				.centerPhoneNumber(entity.getCenterPhoneNumber())
				.centerLocal(entity.getCenterLocal())
				.centerOpenCloseTime(entity.getCenterOpenCloseTime())
				.build();
	}
}
