package com.itwill.entity;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MyPet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long mypetNo;
	@Column(nullable = false)
	private String mypetName;
	@Column(nullable = false)
	private LocalDateTime mypetBirthday;
	@Column(nullable = false)
	@OneToOne(mappedBy = "userinfo")
	private String userId;

	

}
