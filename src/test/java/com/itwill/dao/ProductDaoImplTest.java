package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.TeamprojectAnimalcareApplication;
import com.itwill.TeamprojectAnimalcareApplicationTest;

import com.itwill.entity.Product;
import com.itwill.repository.ProductRepository;

class ProductDaoImplTest extends TeamprojectAnimalcareApplicationTest {

	@Autowired
	ProductDao productDao;
	
	@Test
	//@Disabled
	void insertProductTest() {
		Product product1 = Product.builder()
				.productName("츄르")
				.productPrice(3000)
				.productCategory("간식")
				.productAmount(1)
				.productImage("cat.jpg")
				.build();
		Product savedProduct1 = productDao.insertProduct(product1);
		System.out.println(savedProduct1);
	}
}
