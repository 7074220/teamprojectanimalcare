package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.entity.Product;
import com.itwill.repository.ProductRepository;

class ProductDaoImplTest extends TeamprojectAnimalcareApplicationTests {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	//@Disabled
	void insertProductTest() {
		Product product1 = Product.builder()
				.productName("츄르")
				.productPrice(3000)
				.productCategory("간식")
				.productImage("")
				.build();
	}
}
