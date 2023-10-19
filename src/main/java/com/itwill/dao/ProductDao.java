package com.itwill.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.itwill.entity.Product;

public interface ProductDao {

	Product insertProduct(Product product);
/*
	Product updateProduct(Product updateProduct) throws Exception;
	
	Product findByProductNo(Long no);
	
	void deleteProduct(Long no) throws Exception;

	// 전체 상품 출력
	List<Product> findAll();
	*/
	// 일부 단어 입력으로 제품 검색
	List<Product> findByContains(String productName);

	// 높은 가격순 정렬
	List<Product> findAllByOrderByProductPriceDesc();

	// 낮은 가격순 정렬
	List<Product> findAllByOrderByProductPriceAsc();

	// 평점높은순 정렬
	List<Product> findAllByOrderByProductStarAvgDesc();

	// 최신번호순 정렬
	List<Product> findAllByOrderByProductNoDesc();

	
	
}



