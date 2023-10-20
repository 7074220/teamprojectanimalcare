package com.itwill.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@SequenceGenerator(name = "ReplyBoard_ReplyBoard_NO_SEQ", sequenceName = "ReplyBoard_ReplyBoard_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReplyBoard_ReplyBoard_NO_SEQ")
	private Long ReplyBoardNo;
	@CreationTimestamp
	private LocalDateTime ReplyBoardResisterDate;
	private String ReplyBoardContent;
	private Integer ReplyBoardGroupNo;
	private Integer ReplyBoardStep;
	private Integer ReplyBoardDepth;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_Id")
	@Builder.Default
	Userinfo userinfo = new Userinfo();
	
}
