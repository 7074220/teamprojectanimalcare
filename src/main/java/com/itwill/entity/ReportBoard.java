package com.itwill.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
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


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ReportBoard {
    
	@Id
	@SequenceGenerator(name = "BOARD_NO_SEQ", sequenceName = "BOARD_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_NO_SEQ")
	private Integer boardNo;
	private String boardTitle;
	private LocalDateTime boardResisterDate;
	private String boardContent;
	private LocalDateTime boardDate;
	private Integer boardReadCount;
	private Integer boardGroupNo;
	private Integer boardStep;
	private Integer boardDepth;
	private String boardName;
	private Integer boardPhone;
	
	@ManyToOne
	private String userId;



}