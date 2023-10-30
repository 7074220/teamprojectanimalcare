package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ProductInsertDto;
import com.itwill.dto.ProductListDto;
import com.itwill.entity.Product;
import com.itwill.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// 상품 등록
	public String insertProduct(ProductInsertDto dto) {
		
		productService.insertProduct(ProductInsertDto.toEntity(dto));
		
		return "redirect:shop.html";
	}
	
	// 상품 리스트
	@GetMapping("/list")
	public String ProductList(Model model) {
		List<ProductListDto> productListDto = new ArrayList<>();
		List<Product> productList = productService.findAllByOrderByProductNoDesc();
		
		for (Product product : productList) {
			productListDto.add(ProductListDto.toDto(product));
		}
		
		model.addAttribute("productList", productListDto);
		return "forward:shop.html";
	}
	
	
	@PostMapping("/delete/{productNo}")
	public String deleteProduct(@PathVariable(name = "productNo") Long productNo) throws Exception{
		Optional<Product> product = Optional.of(productService.findByProductNo(productNo));
		if(product.isEmpty()) {
			throw new Exception("존재하지 않는 상품입니다.");
		}
		productService.deleteProduct(productNo);
		return "redirect:shop.html";
	}
	
	/*
	@PostMapping
	public String updateProduct() {
		
	}
	*/
}
