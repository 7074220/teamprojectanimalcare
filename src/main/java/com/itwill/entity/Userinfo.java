package com.itwill.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@Builder.Default
	List<Coupon> coupons = new ArrayList<Coupon>();
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@Builder.Default
	List<MyPet> myPets = new ArrayList<MyPet>();
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@Builder.Default
	List<Product> products = new ArrayList<Product>();
	
}
