package com.itwill.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Userinfo {
	
	@Id
	private String userId;
	private String userPassword;
	private Integer userPoint;
	private String userGender;
	private String userAddress;
	private String userPhoneNumber;
	private String userEmail;
	private String userResidentNumber;
	//@CreationTimestamp
	private LocalDateTime userResisterDate;
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<Coupon> coupons = new ArrayList<Coupon>();
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<MyPet> myPets = new ArrayList<MyPet>();
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<Cart> carts = new ArrayList<Cart>(); 
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<Orders> orders = new ArrayList<Orders>();
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<ReportBoard> reportBoards = new ArrayList<ReportBoard>();
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<ReviewBoard> reviewBoards = new ArrayList<ReviewBoard>();
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<Visit> visits = new ArrayList<Visit>();
	
	@OneToMany(mappedBy = "userinfo",cascade = CascadeType.PERSIST)
	@Builder.Default
	List<Volunteer> volunteers = new ArrayList<Volunteer>(); 
	
}
