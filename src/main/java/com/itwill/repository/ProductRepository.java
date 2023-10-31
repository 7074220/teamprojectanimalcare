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
	
	// 선택된 상품의 카테고리와 펫카테고리가 일치하는 모든 상품 출력
	@Query(value = "select * from product where product_category = ?1 and product_pet_category = ?2", nativeQuery = true)
	List<Product> findAllProductByCategory(String productCategory, String productPetCategory);
	
	// 높은 가격순 정렬
	//@Query(value = "select * from product order by product_price desc", nativeQuery = true)
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
