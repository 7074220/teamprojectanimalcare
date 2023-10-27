package com.itwill.dto;

import java.util.Date;

import com.itwill.entity.Userinfo;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class UserWriteActionDto {
	
	private Long userNo;
	private String userId;
	private String userPassword;
	private String userName;
	private Integer userGender;
	private String userAddress;
	private String userPhoneNumber;
	private String userResidentNumber;
	private Date userRegisterDate;
	private Integer userPoint;
	
	public static Userinfo toEntity(UserWriteActionDto dto) {
		Userinfo userinfo = Userinfo.builder()
				.userId(dto.getUserId())
				.userPassword(dto.getUserPassword())
				.userName(dto.getUserName())
				.userGender(dto.getUserGender())
				.userAddress(dto.getUserAddress())
				.userPhoneNumber(dto.getUserPhoneNumber())
				.userResidentNumber(dto.getUserResidentNumber())
				.userRegisterDate(dto.getUserRegisterDate())
				.userPoint(dto.getUserPoint())
				.build();
		return userinfo;
	}
	
}
