package com.itwill.entity;


import java.util.Date;

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
import jakarta.persistence.Table;
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
@Table(name = "reportboard")
public class ReportBoard {
    
	@Id
	@SequenceGenerator(name = "ReportBoard_board_NO_SEQ", sequenceName = "ReportBoard_board_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReportBoard_board_NO_SEQ")
	private Long boardNo;
	private String boardTitle;
	private Date boardRegisterDate;
	private String boardContent;
	private Date boardDate;
	private Integer boardReadCount;
	private Integer boardGroupNo;
	private Integer boardStep;
	private Integer boardDepth;
	private String boardName;
	
	@Column(unique = true)
	private String boardPhone;
	
	@ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY) // ManyToOne 확실한가?
	@JoinColumn(name = "user_no")
	@Builder.Default
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();



}