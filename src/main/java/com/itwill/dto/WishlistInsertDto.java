package com.itwill.dto;

import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Wish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WishlistInsertDto {

	private Long wishNo;
	private Long productNo;
	private Long userNo;
	
	public static Wish toEntity(WishlistInsertDto dto) {
		Wish insertWishlist = Wish.builder()
				.wishNo(dto.getWishNo())
				.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
				.product(Product.builder().productNo(dto.getProductNo()).build())
				.build();
		return insertWishlist;
	}
}
