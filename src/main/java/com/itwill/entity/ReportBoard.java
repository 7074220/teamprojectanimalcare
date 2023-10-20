package com.itwill.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class ReportBoard {
    
	@Id
	@SequenceGenerator(name = "ReportBoard_board_NO_SEQ", sequenceName = "ReportBoard_board_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReportBoard_board_NO_SEQ")
	private Long boardNo;
	private String boardTitle;
	@CreationTimestamp
	private LocalDateTime boardResisterDate;
	private String boardContent;
	private LocalDateTime boardDate;
	private Integer boardReadCount;
	private Integer boardGroupNo;
	private Integer boardStep;
	private Integer boardDepth;
	private String boardName;
	
	@Column(unique = true)
	private String boardPhone;
	
	@ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY) // ManyToOne 확실한가?
	@JoinColumn(name = "user_id")
	@Builder.Default
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();



}