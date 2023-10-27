package com.itwill.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.itwill.entity.Product;
import com.itwill.entity.ReplyBoard;
import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyCreateDto {
	
	private Long ReplyBoardNo;
	private Date ReplyBoardRegisterDate;
	private String ReplyBoardContent;
	private Integer ReplyBoardGroupNo;
	private Integer ReplyBoardStep;
	private Integer ReplyBoardDepth;
	private Long reportNo;
	private Long userNo;
	
	public static ReplyBoard toEntity(ReplyCreateDto replyCreateDto) {
		ReplyBoard replyBoard = ReplyBoard.builder()
											.ReplyBoardContent(replyCreateDto.getReplyBoardContent())
											.ReplyBoardRegisterDate(replyCreateDto.getReplyBoardRegisterDate())
											.ReplyBoardGroupNo(replyCreateDto.getReplyBoardGroupNo())
											.ReplyBoardStep(replyCreateDto.getReplyBoardStep())
											.ReplyBoardDepth(replyCreateDto.getReplyBoardDepth())
											.build();
		return replyBoard;
	}
	
}
