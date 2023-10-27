package com.itwill.dto;

import com.itwill.entity.Cart;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;

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
public class CartDto {

	private Long cartNo;
	private Integer cartQty;
	private Long productNo;
	private Long userNo;
	
	public static Cart toEntity(CartDto dto) {
		Cart inserCart = Cart.builder()
				.cartNo(dto.getCartNo())
				.cartQty(dto.getCartQty())
				.product(Product.builder().productNo(dto.getProductNo()).build())
				.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
				.build();
		return inserCart;
	}
	
	public static CartDto toDto(Cart cart) {
		
		return CartDto.builder()
				.cartNo(cart.getCartNo())
				.cartQty(cart.getCartQty())
				.productNo(cart.getProduct().getProductNo())
				.userNo(cart.getUserinfo().getUserNo())
				.build();
	}
}
