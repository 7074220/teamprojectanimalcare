
package com.itwill.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Center {

	@Id
	@SequenceGenerator(name = "center_center_no_seq", sequenceName = "center_center_no_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_center_no_seq")
	private Long centerNo;
	private String centerName;
	private String centerPhoneNumber;
	private String centerLocal;
	private String centerOpenCloseTime;

	@OneToMany(mappedBy = "center", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Visit> visits = new ArrayList<Visit>();

	@OneToMany(mappedBy = "center", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Volunteer> volunteers = new ArrayList<Volunteer>();

	@OneToMany(mappedBy = "center", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	List<Pet> pets = new ArrayList<Pet>();

}
