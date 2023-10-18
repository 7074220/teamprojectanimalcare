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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long visitNo;//PK

	private Long visitTime;

	private LocalDate visitDate;

	private String visitCenter;
	
	
	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_Id")
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();
			

}
