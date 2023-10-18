package com.itwill.entity;



import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class MyPet {
	
	@Id
	@SequenceGenerator(name = "mypet_no_seq",sequenceName = "mypet_no_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mypet_no_seq")
	private Long mypetNo;
	@Column(nullable = false)
	private String mypetName;
	@Column(nullable = false)
	private LocalDateTime mypetBirthday;
	@Column(nullable = false)
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Builder.Default
	private Userinfo userinfo = new Userinfo();

	

}
