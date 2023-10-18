package com.itwill.entity;

import java.sql.Date;

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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long boardNo; // PK
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private Long boardStar;
	
	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();
}

