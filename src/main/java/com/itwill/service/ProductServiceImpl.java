package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.ProductDao;
import com.itwill.entity.Product;
import com.itwill.repository.ProductRepository;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	@Override
	public Product updateProduct(Product updateProduct) throws Exception {
		Product findProduct = productDao.findByProductNo(updateProduct.getProductNo());
		if (findProduct!=null) {
			findProduct.setProductName(updateProduct.getProductName());
			findProduct.setProductPrice(updateProduct.getProductPrice());
			findProduct.setProductImage(updateProduct.getProductImage());
			productDao.updateProduct(findProduct);
		} else {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		return findProduct;
	}
/*
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
	*/

	@Override
	public Product findByProductNo(Long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long no) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findByContains(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllByOrderByProductPriceDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllByOrderByProductPriceAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllByOrderByProductStarAvgDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllByOrderByProductNoDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllByOrderByProductNoAsc() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
