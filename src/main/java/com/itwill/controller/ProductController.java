package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ProductListDto;
import com.itwill.entity.Product;
import com.itwill.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/")
	public String productlist() {
		return "TestProductList";
	}
	
	// 상품 리스트
	/*
	@GetMapping("/list")
	public String ProductList(Model model) {
		List<Product> products = productService.findAllByOrderByProductNoDesc();
		model.addAttribute("productList", products);
		return "TestProductList";
	}
	*/
	
}
