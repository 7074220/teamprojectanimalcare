package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Product;
import com.itwill.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insertProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	// 관리자 ~
	@Override
	public Product updateProduct(Product updateProduct) throws Exception {
		return productRepository.save(updateProduct);
	}

	@Override
	public Product findByProductNo(Long no) {
		return productRepository.findById(no).get();
	}
	
	@Override
	public void deleteProduct(Long no) throws Exception {
		productRepository.deleteById(no);
	}

	// 일부 단어 입력으로 제품 검색
	@Override
	public List<Product> findByContains(String productName) { 
		return productRepository.findByContains(productName);
	}

	@Override
	// 선택된 상품의 카테고리와 펫카테고리가 일치하는 모든 상품 출력
	public List<Product> findAllProductByCategory(String productCategory, String productPetCategory) {
		return productRepository.findAllProductByCategory(productCategory, productPetCategory);
	}

	@Override
	public List<Product> findAllProductByPetCategory(String productPetCategory) {
		return productRepository.findAllProductByPetCategory(productPetCategory);
	}
	
	// 높은 가격순 정렬
	@Override
	public List<Product> findAllByOrderByProductPriceDesc() {
		return productRepository.findAllByOrderByProductPriceDesc();
	}

	// 낮은 가격순 정렬
	@Override
	public List<Product> findAllByOrderByProductPriceAsc () {
		return productRepository.findAllByOrderByProductPriceAsc();
	}

	// 평점높은순 정렬
	@Override
	public List<Product> findAllByOrderByProductStarAvgDesc() {
		return productRepository.findAllByOrderByProductStarAvgDesc();
	}

	// 최신번호순 정렬
	@Override
	public List<Product> findAllByOrderByProductNoDesc() {
		return productRepository.findAllByOrderByProductNoDesc();
	}

	// 낮은번호순 정렬
	@Override
	public List<Product> findAllByOrderByProductNoAsc() {
		return productRepository.findAllByOrderByProductNoAsc();
	}


	
	

}
