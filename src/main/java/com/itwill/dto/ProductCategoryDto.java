package com.itwill.dto;

import com.itwill.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategoryDto {

	private String productCategory;
	private String productPetCategory;
	
	public static ProductCategoryDto toDto(Product product) {
		ProductCategoryDto productListDto = ProductCategoryDto.builder()
				.productCategory(product.getProductCategory())
				.productPetCategory(product.getProductPetCategory())
				.build();
		return productListDto;
	}
}
