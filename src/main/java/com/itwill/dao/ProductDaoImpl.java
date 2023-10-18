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
	ProductRepository productRepository;

	@Override
	public Product insertProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	// 관리자 ~
	@Override
	public Product updateProduct(Product updateProduct) throws Exception {
		Optional<Product> findProductOptional = productRepository.findById(updateProduct.getProductNo());
		Product updatedProduct = null;
		if (findProductOptional.isPresent()) {
			Product product = findProductOptional.get();
			product.setProductName(updateProduct.getProductName());
			product.setProductPrice(updateProduct.getProductPrice());
			product.setProductImage(updateProduct.getProductImage());
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

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByProductNameLike(String productName) {
		return productRepository.findByProductNameLike(productName);
	}

	@Override
	public List<Product> findByProductOrderByProductPriceDesc(Integer productPrice) {
		return productRepository.findByProductOrderByProductPriceDesc(productPrice);
	}

	@Override
	public List<Product> findByProductOrderByProductPriceAsc(Integer productPrice) {
		return productRepository.findByProductOrderByProductPriceAsc(productPrice);
	}

	@Override
	public List<Product> findByProductOrderByProductStarAvgDesc(Integer productStarAvg) {
		return productRepository.findByProductOrderByProductStarAvgDesc(productStarAvg);
	}

	@Override
	public List<Product> findByProductOrderByProductNoDesc(Integer productNo) {
		return productRepository.findByProductOrderByProductNoDesc(productNo);
	}

}
