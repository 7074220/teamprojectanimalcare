package com.itwill.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") 
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") 
	private Date boardDate;
	private Integer boardStar;
	private Long productNo;
	   private double averageRating;
	
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
	
	public static ReviewBoardDto toDto(ReviewBoard reviewBoard) {
		ReviewBoardDto reviewBoardDto = ReviewBoardDto.builder()
									.userNo(reviewBoard.getUserinfo().getUserNo())
									.boardNo(reviewBoard.getBoardNo())
									.boardTitle(reviewBoard.getBoardTitle())
									.boardContent(reviewBoard.getBoardContent())
									.boardDate(reviewBoard.getBoardDate())
									.boardStar(reviewBoard.getBoardStar())
									.productNo(reviewBoard.getProduct().getProductNo())							
									.build(); 		
		return reviewBoardDto;
	}
	
	
	
}
