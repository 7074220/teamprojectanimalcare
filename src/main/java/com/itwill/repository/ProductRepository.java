package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// 일부 단어 입력으로 제품 검색
	@Query(value = "select * from product where product_name like '%'||?1||'%'", nativeQuery = true)
	List<Product> findByContains(String productName);
	
	// 높은 가격순 정렬
	//@Query(value = "select * from product order by product_price desc", nativeQuery = true)
	List<Product> findAllByOrderByProductPriceDesc();
	
	// 낮은 가격순 정렬
	List<Product> findAllByOrderByProductPriceAsc();
	
	// 평점높은순 정렬
	List<Product> findAllByOrderByProductStarAvgDesc();
	
	// 최신번호순 정렬
	List<Product> findAllByOrderByProductNoDesc();
}
