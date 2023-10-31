package com.itwill.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.itwill.entity.Product;

public interface ProductDao {

	// 상품등록 (관리자 모드)
	Product insertProduct(Product product);
	
	// 상품정보 수정 (관리자 모드)
	Product updateProduct(Product updateProduct) throws Exception;
	
	Product findByProductNo(Long no);
	
	void deleteProduct(Long no) throws Exception;

	// 일부 단어 입력으로 제품 검색
	List<Product> findByContains(String productName);

	// 선택된 상품의 카테고리와 펫카테고리가 일치하는 모든 상품 출력
	List<Product> findAllProductByCategory(String productCategory, String productPetCategory);
	
	
	// 높은 가격순 정렬
	//List<Product> findByProductPriceDesc();
	List<Product> findAllByOrderByProductPriceDesc();

	// 낮은 가격순 정렬
	List<Product> findAllByOrderByProductPriceAsc();

	// 평점높은순 정렬
	List<Product> findAllByOrderByProductStarAvgDesc();

	// 최신번호순 정렬
	List<Product> findAllByOrderByProductNoDesc();
	
	// 낮은번호순 정렬
	List<Product> findAllByOrderByProductNoAsc();

	
	
}



