package com.itwill.dto;

import java.util.Date;

import com.itwill.entity.Product;
import com.itwill.entity.ReviewBoard;
import com.itwill.entity.Userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class ReviewBoardDto {
	
	private Long userNo;
	private Long boardNo; 
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private Integer boardStar;
	private Long productNo;
	
	public static ReviewBoard toEntity(ReviewBoardDto dto) {
		ReviewBoard reviewBoard = ReviewBoard.builder()
								.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
								.boardNo(dto.getBoardNo())
								.boardTitle(dto.getBoardTitle())
								.boardContent(dto.getBoardContent())
								.boardDate(dto.getBoardDate())
								.boardStar(dto.getBoardStar())
								.product(Product.builder().productNo(dto.getProductNo()).build())
								.build();
		return reviewBoard;
	}
	
	
	
	
	
}
