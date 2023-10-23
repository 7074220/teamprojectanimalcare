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
import jakarta.persistence.Table;
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
@Table(name = "volunteer")
//@ToString(callSuper = true)
public class Volunteer {
 
	@Id
	@SequenceGenerator(name = "Volunteer_volunteer_no_SEQ",sequenceName ="Volunteer_volunteer_no_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Volunteer_volunteer_no_SEQ")
	private Long volunteerNo; // PK
	private Long volunteerTime;
	private LocalDate volunteerDate;
	private String volunteerStatus;
	
	/*
	 * N : 1
	 */
	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_no")
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
