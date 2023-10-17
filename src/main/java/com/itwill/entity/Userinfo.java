package com.itwill.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Userinfo {
	
	@Id
	private String userId;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Integer point;
	@Column(nullable = false)
	private Integer gender;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private Integer phoneNo;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String residentNo;
	@Column(nullable = false)
	private LocalDateTime resisterDate;
	
	
	
	
}
