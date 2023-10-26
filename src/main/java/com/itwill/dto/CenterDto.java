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

	private Long centerNo;
	//센터번호
	private String centerName; 
	//센터이름
	private String centerPhoneNumber;
	//센터전화번호
	private String centerLocal;
	//센터지역
	private String centerOpenCloseTime;
	//센터영업시간
	
	public static Center toEntity(CenterDto dto) {
		return Center.builder()
				.centerNo(dto.getCenterNo())
				.centerName(dto.getCenterName())
				.centerPhoneNumber(dto.getCenterPhoneNumber())
				.centerLocal(dto.getCenterLocal())
				.centerOpenCloseTime(dto.getCenterOpenCloseTime())
				.build();
	}

	public static CenterDto toEntity(Center center) {
		  return CenterDto.builder()
		            .centerNo(center.getCenterNo())
		            .centerName(center.getCenterName())
		            .centerPhoneNumber(center.getCenterPhoneNumber())
		            .centerLocal(center.getCenterLocal())
		            .centerOpenCloseTime(center.getCenterOpenCloseTime())
		            .build();
	}
}
