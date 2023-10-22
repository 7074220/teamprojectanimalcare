package com.itwill.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Userinfo {

	@Id
	@SequenceGenerator(name = "userinfo_user_no_seq", allocationSize = 1, initialValue = 1, sequenceName = "userinfo_user_no_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userinfo_user_no_seq")
	private Long userNo;
	// 아이디는 이메일로 사용함.
	@Column(name = "user_id")
	private String userId;
	private String userPassword;
	private String userName;
	private Integer userGender;
	private String userAddress;
	@Column(unique = true)
	private String userPhoneNumber;
	@Column(unique = true)
	private String userResidentNumber;
	private Date userRegisterDate;
	private Integer userPoint;

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Coupon> coupons = new ArrayList<Coupon>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<MyPet> myPets = new ArrayList<MyPet>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	List<Cart> carts = new ArrayList<Cart>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Orders> orders = new ArrayList<Orders>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<ReportBoard> reportBoards = new ArrayList<ReportBoard>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<ReviewBoard> reviewBoards = new ArrayList<ReviewBoard>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Visit> visits = new ArrayList<Visit>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Volunteer> volunteers = new ArrayList<Volunteer>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Adopt> adopts = new ArrayList<Adopt>();

	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<ReplyBoard> replyBoards = new ArrayList<ReplyBoard>();

	public Userinfo() {
		// TODO Auto-generated constructor stub
	}

	public Userinfo(String userId, String password, String userName) {

	}

	@Override
	public String toString() {
		return "Userinfo [userNo=" + userNo + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userGender=" + userGender + ", userAddress=" + userAddress + ", userPhoneNumber="
				+ userPhoneNumber + ", userResidentNumber=" + userResidentNumber + ", userRegisterDate="
				+ userRegisterDate + ", userPoint=" + userPoint + ", coupons=" + coupons + ", myPets=" + myPets
				+ ", carts=" + carts + ", orders=" + orders + ", reportBoards=" + reportBoards + ", reviewBoards="
				+ reviewBoards + ", visits=" + visits + ", volunteers=" + volunteers + ", adopts=" + adopts
				+ ", replyBoards=" + replyBoards + "]";
	}

	
}
