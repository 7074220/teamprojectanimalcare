package com.itwill.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptItem {
	
	@Id
	@SequenceGenerator(name = "ai_no_seq" , sequenceName = "ai_no_seq",allocationSize = 1,initialValue = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ai_no_seq")
	private Long ai_no;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Builder.Default
	private Adopt adopt = new Adopt();
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@Builder.Default
	private Pet pet = new Pet();
	
	
}
