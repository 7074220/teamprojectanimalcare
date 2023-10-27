package com.itwill.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {

	private Long productNo;
	private String productName;
	private Integer productPrice;
	private String productImage;
}
