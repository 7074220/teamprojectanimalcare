package com.itwill.entity;



import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
	private String mypetName;
	private LocalDateTime mypetBirthday;
	private String mypetKind; //고양이인지 강아지인지 구별
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Builder.Default
	@JoinColumn(name = "user_id")
	private Userinfo userinfo = new Userinfo();

	

}
