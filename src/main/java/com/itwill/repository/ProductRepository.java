package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// 일부 단어 입력으로 제품 검색
	
	//List<Product> findByProductNameLike(String productName);
	
	// 높은 가격순 정렬
	//List<Product> findByProductOrderByProductPriceDesc(Integer productPrice);
	
	// 낮은 가격순 정렬
	//List<Product> findByProductOrderByProductPriceAsc(Integer productPrice);
	
	// 평점순 정렬
	//List<Product> findByProductOrderByProductStarAvgDesc(Integer productStarAvg);
	
	// 최신번호순 정렬
	//List<Product> findByProductOrderByProductNoDesc(Integer productNo);
}
