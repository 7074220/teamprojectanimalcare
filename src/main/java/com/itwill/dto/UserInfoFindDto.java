package com.itwill.dto;

import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoFindDto {

	private String userId;
	private String userPassword;
	private String userName;
	private String userPhoneNumber;
	
}
