package com.itwill.entity;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.ToStringExclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pet {
	@SequenceGenerator(name = "pet_pet_no_seq",sequenceName = "pet_pet_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pet_pet_no_seq")
	@Id
	 private Long petNo;
	 private String petLocal;
	 private String petType;
	 private String  petgender;
	 private LocalDate  petRegisterDate;
	 private String petFindPlace;
	 private String petCharacter;
	 private String petCenter;
	 
	 
	 @ManyToOne
	 @ToStringExclude
	 @JoinColumn(name = "pet_no")
	 private Adopt adopt = new Adopt();
}
