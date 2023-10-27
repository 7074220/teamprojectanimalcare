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

	@Override
	public Product findByProductNo(Long no) {
		Product selectedProduct = productDao.findByProductNo(no);
		return selectedProduct;
	}
	
	@Override
	public void deleteProduct(Long no) throws Exception {
		Product findProduct = productDao.findByProductNo(no);
		if (findProduct == null) {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		productDao.deleteProduct(no);
	}

	// 일부 단어 입력으로 제품 검색
	@Override
	public List<Product> findByContains(String productName) { 
		return productDao.findByContains(productName);
	}

	// 높은 가격순 정렬
	@Override
	public List<Product> findAllByOrderByProductPriceDesc() {
		return productDao.findAllByOrderByProductPriceDesc();
	}

	// 낮은 가격순 정렬
	@Override
	public List<Product> findAllByOrderByProductPriceAsc () {
		return productDao.findAllByOrderByProductPriceAsc();
	}

	// 평점높은순 정렬
	@Override
	public List<Product> findAllByOrderByProductStarAvgDesc() {
		return productDao.findAllByOrderByProductStarAvgDesc();
	}

	// 최신번호순 정렬
	@Override
	public List<Product> findAllByOrderByProductNoDesc() {
		return productDao.findAllByOrderByProductNoDesc();
	}

	// 낮은번호순 정렬
	@Override
	public List<Product> findAllByOrderByProductNoAsc() {
		return productDao.findAllByOrderByProductNoAsc();
	}
	
	
}
