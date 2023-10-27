package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ProductInsertDto;
import com.itwill.dto.ProductListDto;
import com.itwill.dto.ProductResponseDto;
import com.itwill.dto.ProductUpdateDto;
import com.itwill.entity.Product;
import com.itwill.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@Operation(summary = "상품 추가")
	@GetMapping
	// insert
	public ResponseEntity<ProductInsertDto> insertProduct(ProductInsertDto dto){
		
		productService.insertProduct(ProductInsertDto.toEntity(dto));
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ProductInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@Operation(summary = "상품 삭제")
	@DeleteMapping("/{no}")
	// delete
	public ResponseEntity deleteProduct(@PathVariable(name = "no") Long no) throws Exception{
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		productService.deleteProduct(no);
		return new ResponseEntity(httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "상품 수정")
	@PutMapping("{productNo}")
	// update
	public ResponseEntity<ProductListDto> updateProduct(@PathVariable(value = "productNo") Long productNo, @RequestBody ProductListDto dto) throws Exception{
		Product findProduct = productService.findByProductNo(productNo);
		
		 findProduct.setProductImage(dto.getProductImage());
		 findProduct.setProductName(dto.getProductName());
		 findProduct.setProductPrice(dto.getProductPrice());
		 productService.updateProduct(findProduct);	
		 
		 ProductListDto updatedDto = ProductListDto.toDto(findProduct);
		 
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ProductListDto>(updatedDto, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "상품 리스트(최신 번호순)")
	@GetMapping("/productNoDescList")
	// productNo 최신번호순
	public ResponseEntity<List<ProductListDto>> productNoDescList(){
		List<Product> products = productService.findAllByOrderByProductNoDesc();
		List<ProductListDto> productsDto = new ArrayList<ProductListDto>();
		
		for (Product product : products) {
			productsDto.add(ProductListDto.toDto(product));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<ProductListDto>>(productsDto, httpHeaders, HttpStatus.OK);
	}
	
	
	
	@Operation(summary = "상품 리스트(낮은 번호순)")
	@GetMapping("/productNoAscList")
	// productNo 낮은번호순
	public ResponseEntity<List<ProductListDto>> productNoAscList(){
		List<Product> products = productService.findAllByOrderByProductNoAsc();
		List<ProductListDto> productsDto = new ArrayList<ProductListDto>();
		
		for (Product product : products) {
			productsDto.add(ProductListDto.toDto(product));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<ProductListDto>>(productsDto, httpHeaders, HttpStatus.OK);
	}
	
	
	
	@Operation(summary = "상품 리스트(높은 가격순 정렬)")
	@GetMapping("/productPriceDescList")
	// productNo 높은 가격순
	public ResponseEntity<List<ProductListDto>> productPriceDescList(){
		List<Product> products = productService.findAllByOrderByProductPriceDesc();
		List<ProductListDto> productsDto = new ArrayList<ProductListDto>();
		
		for (Product product : products) {
			productsDto.add(ProductListDto.toDto(product));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<ProductListDto>>(productsDto, httpHeaders, HttpStatus.OK);
	}
	
	
	
	@Operation(summary = "상품 리스트(낮은 가격순 정렬)")
	@GetMapping("/productPriceAscList")
	// productNo 낮은 가격순
	public ResponseEntity<List<ProductListDto>> productPriceAscList(){
		List<Product> products = productService.findAllByOrderByProductPriceAsc();
		List<ProductListDto> productsDto = new ArrayList<ProductListDto>();
		
		for (Product product : products) {
			productsDto.add(ProductListDto.toDto(product));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<ProductListDto>>(productsDto, httpHeaders, HttpStatus.OK);
	}
	
	
	
	@Operation(summary = "상품 리스트(평점 높은순 정렬)")
	@GetMapping("/productStarAvgDescList")
	// productNo 평점 높은순
	public ResponseEntity<List<ProductListDto>> productStarAvgDescList(){
		List<Product> products = productService.findAllByOrderByProductStarAvgDesc();
		List<ProductListDto> productsDto = new ArrayList<ProductListDto>();
		
		for (Product product : products) {
			productsDto.add(ProductListDto.toDto(product));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<ProductListDto>>(productsDto, httpHeaders, HttpStatus.OK);
	}
	
}


















