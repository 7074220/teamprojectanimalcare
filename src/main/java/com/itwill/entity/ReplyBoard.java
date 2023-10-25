package com.itwill.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="replyboard")
public class ReplyBoard {
	
	@Id
	@SequenceGenerator(name = "ReplyBoard_reply_board_no_SEQ", sequenceName = "ReplyBoard_reply_board_no_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReplyBoard_reply_board_no_SEQ")
	private Long ReplyBoardNo;
	@CreationTimestamp
	private Date ReplyBoardRegisterDate;
	private String ReplyBoardContent;
	private Integer ReplyBoardGroupNo;
	@Builder.Default
	private Integer ReplyBoardStep = 1;
	@Builder.Default
	private Integer ReplyBoardDepth = 0;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_no")
	@Builder.Default
	ReportBoard reportBoard=new ReportBoard();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_no") 
	@Builder.Default
	Userinfo userinfo = new Userinfo();
	
	
	
}
