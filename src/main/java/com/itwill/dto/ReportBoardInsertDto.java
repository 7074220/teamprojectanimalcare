package com.itwill.dto;

import java.util.Date;

import com.itwill.entity.ReportBoard;
import com.itwill.entity.Userinfo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.net.aso.b;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportBoardInsertDto {

	private Long boardNo;
	private String boardTitle;
	private Date boardRegisterDate;
	private String boardContent;
	private Date boardFindDate;
	private String boardFindName;
	private String boardFindPhone;
	
	private Userinfo userinfo;
	
	public static ReportBoard toEntity(ReportBoardInsertDto reportBoardInsertDto) {
		ReportBoard reportBoard =ReportBoard.builder()
											.boardContent("")
											.boardFindDate(null)
											.boardFindName(null)
											.boardFindPhone(null)
											.boardNo(null)
											.boardRegisterDate(null)
											.boardTitle(null)
											.userinfo(reportBoardInsertDto.getUserinfo())
											.build();
		return reportBoard;
	}
	
}
