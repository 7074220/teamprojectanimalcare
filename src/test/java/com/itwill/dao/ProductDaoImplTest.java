package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.TeamprojectAnimalcareApplication;
import com.itwill.TeamprojectAnimalcareApplicationTests;
import com.itwill.entity.Product;
import com.itwill.repository.ProductRepository;

class ProductDaoImplTest extends TeamprojectAnimalcareApplicationTests {

	@Autowired
	ProductDao productDao;
	
	
	@Test
	@Disabled
	void insertProductTest() {
		Product product1 = Product.builder()
				.productName("고양이밥")
				.productPrice(3000)
				.productCategory("간식")
				.productAmount(1)
				.productImage("cat.jpg")
				.build();
		Product savedProduct1 = productDao.insertProduct(product1);
		System.out.println(savedProduct1);
	}
	
	
	@Test
	//@Disabled
	void findByContainsTest() {
		List<Product> findProduct = productDao.findByContains("츄");
		System.out.println(findProduct);
	}
}
