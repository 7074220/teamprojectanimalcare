package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.entity.Product;
import com.itwill.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product updateProduct) throws Exception {
		Optional<Product> findProductOptional = productRepository.findById(updateProduct.getProductNo());
		Product updatedProduct = null;
		if (findProductOptional.isPresent()) {
			Product product = findProductOptional.get();
			product.setProductName(updateProduct.getProductName());
			product.setProductPrice(updateProduct.getProductPrice());
			product.setProductImage(updateProduct.getProductImage());
			updatedProduct = productRepository.save(updateProduct);
		} else {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		return updatedProduct;
	}

	@Override
	public Product findByProductNo(Long no) {
		Product selectedProduct = productRepository.findById(no).get();
		return selectedProduct;
	}
	
	@Override
	public void deleteProduct(Long no) throws Exception {
		Optional<Product> selectedProdcuOptional = productRepository.findById(no);
		if (selectedProdcuOptional.isEmpty()) {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		productRepository.delete(selectedProdcuOptional.get());
	}

	// 일부 단어 입력으로 제품 검색
	@Override
	public List<Product> findByContains(String productName) { 
		return productRepository.findByContains(productName);
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
