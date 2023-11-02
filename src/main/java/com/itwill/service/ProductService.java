package com.itwill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Product;

@Transactional
public interface ProductService {

	Product insertProduct(Product product);
	
	Product updateProduct(Product updateProduct) throws Exception;
	
	Product findByProductNo(Long no);
	
	void deleteProduct(Long no) throws Exception;
	
	// 일부 단어 입력으로 제품 검색
	List<Product> findByContains(String productName);

	// 선택된 상품의 카테고리와 펫카테고리가 일치하는 모든 상품 출력
	List<Product> findAllProductByCategory(String productCategory, String productPetCategory);
	
	// 펫카테고리별로 상품 출력
	List<Product> findAllProductByPetCategory(String productPetCategory);
	
	// 높은 가격순 정렬
	List<Product> findAllByOrderByProductPriceDesc();

	// 낮은 가격순 정렬
	List<Product> findAllByOrderByProductPriceAsc();

	// 평점높은순 정렬
	List<Product> findAllByOrderByProductStarAvgDesc();

	// 최신번호순 정렬
	// default
	List<Product> findAllByOrderByProductNoDesc();
	
	// 낮은번호순 정렬
	List<Product> findAllByOrderByProductNoAsc();
	
	/*************** 펫 카테고리별 정렬 ****************/
	// 높은 가격순 정렬
	List<Product> findAllByOrderByProductByPetCategoryPriceDesc(String productPetCategory);
	
	// 낮은 가격순 정렬
	List<Product> findAllByOrderByProductByPetCategoryPriceAsc(String productPetCategory);
	
	// 평점높은순 정렬
	List<Product> findAllByOrderByProductByPetCategoryStarAvgDesc(String productPetCategory);
	
	// 최신번호순 정렬
	List<Product> findAllByOrderByProductByPetCategoryNoDesc(String productPetCategory);
	
}
