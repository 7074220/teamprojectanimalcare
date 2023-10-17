package com.itwill.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Userinfo {
	
	@Id
	private String userId;
	@Column(nullable = false)
	private String userPassword;
	
	private Integer userPoint;
	@Column(nullable = false)
	private Integer userGender;
	@Column(nullable = false)
	private String userAddress;
	@Column(nullable = false)
	private Integer userPhoneNumber;
	@Column(nullable = false)
	private String userEmail;
	@Column(nullable = false)
	private String userResidentNumber;
	@Column(nullable = false)
	private String userResisterDate;
	

	
}
