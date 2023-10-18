package com.itwill.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long volunteerNo; // PK
	
	private Long volunteerTime;
	
	private LocalDate volunteerDate;
	
	private String volunteerCenter;
	
	
	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();
	
	
}
