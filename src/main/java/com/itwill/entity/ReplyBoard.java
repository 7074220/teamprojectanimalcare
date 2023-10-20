package com.itwill.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReplyBoard {
	
	@Id
	@SequenceGenerator(name = "ReplyBoard_NO_SEQ", sequenceName = "ReplyBoard_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReplyBoard_NO_SEQ")
	private Long ReplyBoardNo;
	@CreationTimestamp
	private LocalDateTime ReplyBoardResisterDate;
	private String ReplyBoardContent;
	private String ReplyBoardWriter;
	private Integer ReplyBoardGroupNo;
	private Integer ReplyBoardStep;
	private Integer ReplyBoardDepth;
	
}
