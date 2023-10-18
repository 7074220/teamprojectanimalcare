package com.itwill.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Volunteer {
	
	@Id
	//@SequenceGenerator(name = "volunteer_no_seq",sequenceName = "volunteer_no_seq",allocationSize = 1,initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "volunteer_no_seq")
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
