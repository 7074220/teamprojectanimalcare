package com.itwill.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString(callSuper = true)
public class Volunteer {
 
	@Id
	@SequenceGenerator(name = "volunteer_no_seq",sequenceName ="volunteer_no_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "volunteer_no_seq")
	private Long volunteerNo; // PK
	private Long volunteerTime;
	private LocalDate volunteerDate;
	private String volunteerStatus;
	
	/*
	 * N : 1
	 */
	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();
	
	/*
	 * N : 1
	 */
	@Builder.Default
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "center_no")
	@ToString.Exclude
	private Center center = new Center();
	

}
