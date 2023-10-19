package com.itwill.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Local {
	@Id
	@SequenceGenerator(name = "local_no_seq",sequenceName = "local_no_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "local_no_seq")
	
	private Long localNo;
	private Long localCity;
	private Long localGu;
	
	@OneToMany(mappedBy = "local", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<Pet> pet = new ArrayList<>();
	
	@OneToMany(mappedBy = "local", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<Center> center = new ArrayList<>();
	
	
}
