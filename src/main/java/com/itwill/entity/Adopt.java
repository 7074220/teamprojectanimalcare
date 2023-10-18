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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
public class Adopt {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long adoptNo; // pk
	private Long adoptTime;
	private LocalDate adoptDate;
	
	/*
	 * 1:1
	 */
	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_no")
	@ToString.Exclude
	private Pet pet = new Pet();
	
	/*
	 * N:1
	 */
	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();
}
