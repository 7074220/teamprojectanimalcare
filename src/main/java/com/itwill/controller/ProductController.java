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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.ProductCatListDto;
import com.itwill.dto.ProductDogListDto;
import com.itwill.dto.ProductInsertDto;
import com.itwill.dto.ProductListDto;
import com.itwill.dto.ProductNameDto;
import com.itwill.dto.ProductPetCategoryDto;
import com.itwill.dto.ProductPriceAscDto;
import com.itwill.dto.ProductPriceDescDto;
import com.itwill.dto.ProductProductNoDescDto;
import com.itwill.entity.MyPet;
import com.itwill.entity.Product;
import com.itwill.service.MyPetService;
import com.itwill.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MyPetService myPetService;
	
	/*
	// 상품 등록
	public String insertProduct(ProductInsertDto dto) {
		
		productService.insertProduct(ProductInsertDto.toEntity(dto));
		
		return "redirect:shop.html";
	}
	*/
	
	// 펫카테고리별로 구분 --> 상품 리스트 출력
		@GetMapping("/productList")
		public String productList(Model model, HttpSession session) {
			List<ProductListDto> productListDto = new ArrayList<>();
			List<Product> productList = new ArrayList<>();
			
			Long userNo = (Long) session.getAttribute("userNo");
			MyPet myPet = MyPet.builder().build();
			
			productList = productService.findAllByOrderByProductNoDesc();
			
			if(userNo != null) {
				myPet = myPetService.findLeaderMyPet(userNo);
				if (myPet == null) {
					myPet = MyPet.builder().build();
				} else {
					productList = productService.findAllProductByPetCategory(myPet.getMypetKind());
				}
			}
			
			for (Product product : productList) {
				productListDto.add(ProductListDto.toDto(product));
			}
			
			model.addAttribute("productList", productListDto);
			model.addAttribute("myPet", myPet);
			// System.out.println(productList.get(0).getProductPetCategory());
			return "shop";
		}
		
		// 펫카테고리별로 구분 --> 상품 리스트 출력
		@GetMapping("/productDogList")
		public String productDogList(Model model, HttpSession session, @RequestParam String category) {
			List<ProductDogListDto> productDogListDto = new ArrayList<>();
			List<Product> productList = new ArrayList<>();
			
			Long userNo = (Long) session.getAttribute("userNo");
			MyPet myPet = MyPet.builder().build();
			
			productList = productService.findAllProductByPetCategory("강아지");
			
			if(category.equals("All")) {
				productList = productService.findAllProductByPetCategory("강아지");
			}
			if(category.equals("사료")) {
				productList = productService.findAllProductByCategory("사료", "강아지");
			}
			if(category.equals("간식")) {
				productList = productService.findAllProductByCategory("간식", "강아지");
			}
			if(category.equals("캔")) {
				productList = productService.findAllProductByCategory("캔", "강아지");
			}
			if(category.equals("위생")) {
				productList = productService.findAllProductByCategory("위생", "강아지");
			}
			if(category.equals("미용")) {
				productList = productService.findAllProductByCategory("미용", "강아지");
			}
			
			myPet.setMypetKind("강아지");
			
			for (Product product : productList) {
				productDogListDto.add(ProductDogListDto.toDto(product));
			}
			
			model.addAttribute("productList", productDogListDto);
			model.addAttribute("myPet", myPet);
			// System.out.println(productList.get(0).getProductPetCategory());
			return "shop";
		}
		
		// 펫카테고리별로 구분 --> 상품 리스트 출력
		@GetMapping("/productCatList")
		public String productCatList(Model model, HttpSession session,@RequestParam String category) {
			List<ProductCatListDto> productCatListDto = new ArrayList<>();
			List<Product> productList = new ArrayList<>();
			
			Long userNo = (Long) session.getAttribute("userNo");
			MyPet myPet = MyPet.builder().build();
			
			productList = productService.findAllProductByPetCategory("고양이");
			
			if(category.equals("All")) {
				productList = productService.findAllProductByPetCategory("고양이");
			}
			if(category.equals("사료")) {
				productList = productService.findAllProductByCategory("사료", "고양이");
			}
			if(category.equals("간식")) {
				productList = productService.findAllProductByCategory("간식", "고양이");
			}
			if(category.equals("캔")) {
				productList = productService.findAllProductByCategory("캔", "고양이");
			}
			if(category.equals("모래")) {
				productList = productService.findAllProductByCategory("모래", "고양이");
			}
			if(category.equals("미용")) {
				productList = productService.findAllProductByCategory("미용", "고양이");
			}
			
			myPet.setMypetKind("고양이");
			
			for (Product product : productList) {
				productCatListDto.add(ProductCatListDto.toDto(product));
			}
			
			model.addAttribute("productList", productCatListDto);
			model.addAttribute("myPet", myPet);
			// System.out.println(productList.get(0).getProductPetCategory());
			return "shop";
		}
	
	@GetMapping("/productPriceDesc")
	// 상품가격 비싼 것부터 --> user의 myPetKind 사용
	public String ProductPriceDesc(Model model, HttpSession session, @RequestParam String path) {
		List<ProductPriceDescDto> productPriceDescDto = new ArrayList<>();
		// 상품가격 비싼 것부터
		List<Product> productList = productService.findAllByOrderByProductPriceDesc();
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();

		if (path.equals("/productDogList")) {
			myPet.setMypetKind("강아지");
			productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("강아지");
		}

		if (path.equals("/productCatList")) {
			myPet.setMypetKind("고양이");
			productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("고양이");
		}

		if (path.equals("/productList")) {
			myPet = myPetService.findLeaderMyPet(userNo);
			if (myPet == null) {
				myPet = MyPet.builder().build();
			} else {
				if (myPet.getMypetKind().equals("강아지")) {
					productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("강아지");
				}
				if (myPet.getMypetKind().equals("고양이")) {
					productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("고양이");
				}
			}
		}
		
		for (Product product : productList) {
			productPriceDescDto.add(ProductPriceDescDto.toDto(product));
		}

		model.addAttribute("productList", productPriceDescDto);
		model.addAttribute("myPet", myPet);

		return "shop";
	}
	
	@GetMapping("/productPriceAsc")
	public String productPriceAsc(Model model, HttpSession session, @RequestParam String path) {
		List<ProductPriceAscDto> productPriceAscDto = new ArrayList<>();
		// 상품가격 싼 것부터
		List<Product> productList = productService.findAllByOrderByProductPriceAsc();
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();

		if (path.equals("/productDogList")) {
			myPet.setMypetKind("강아지");
			productList = productService.findAllByOrderByProductByPetCategoryPriceAsc("강아지");
		}

		if (path.equals("/productCatList")) {
			myPet.setMypetKind("고양이");
			productList = productService.findAllByOrderByProductByPetCategoryPriceAsc("고양이");
		}

		if (path.equals("/productList")) {
			myPet = myPetService.findLeaderMyPet(userNo);
			if (myPet == null) {
				myPet = MyPet.builder().build();
			} else {
				if (myPet.getMypetKind().equals("강아지")) {
					productList = productService.findAllByOrderByProductByPetCategoryPriceAsc("강아지");
				}
				if (myPet.getMypetKind().equals("고양이")) {
					productList = productService.findAllByOrderByProductByPetCategoryPriceAsc("고양이");
				}
			}
		}
		
		for (Product product : productList) {
			productPriceAscDto.add(ProductPriceAscDto.toDto(product));
		}

		model.addAttribute("productList", productPriceAscDto);
		model.addAttribute("myPet", myPet);

		return "shop";
	}
	 
	@GetMapping("/productDateDesc")
	public String productDateDesc(Model model, HttpSession session, @RequestParam String path) {
		List<ProductProductNoDescDto> productProductNoDescDto = new ArrayList<>();
		// 상품가격 등록일순
		List<Product> productList = productService.findAllByOrderByProductNoDesc();
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();

		if (path.equals("/productDogList")) {
			myPet.setMypetKind("강아지");
			productList = productService.findAllByOrderByProductByPetCategoryNoDesc("강아지");
		}

		if (path.equals("/productCatList")) {
			myPet.setMypetKind("고양이");
			productList = productService.findAllByOrderByProductByPetCategoryNoDesc("고양이");
		}

		if (path.equals("/productList")) {
			myPet = myPetService.findLeaderMyPet(userNo);
			if (myPet == null) {
				myPet = MyPet.builder().build();
			} else {
				if (myPet.getMypetKind().equals("강아지")) {
					productList = productService.findAllByOrderByProductByPetCategoryNoDesc("강아지");
				}
				if (myPet.getMypetKind().equals("고양이")) {
					productList = productService.findAllByOrderByProductByPetCategoryNoDesc("고양이");
				}
			}
		}
		
		for (Product product : productList) {
			productProductNoDescDto.add(ProductProductNoDescDto.toDto(product));
		}

		model.addAttribute("productList", productProductNoDescDto);
		model.addAttribute("myPet", myPet);

		return "shop";
	}
	
	@GetMapping(value = "/productDetail", params = "productNo")
	public String productDetail(@RequestParam Long productNo, Model model) {
		Product product = productService.findByProductNo(productNo);
		String findProductName = productService.findByProductNo(productNo).getProductName();
		int firstSpaceIndex = findProductName.indexOf(" ");
		
		
		if (firstSpaceIndex >= 0) {
			findProductName = findProductName.substring(0, firstSpaceIndex);// 첫 번째 공백까지 잘라내기
		}
		List<Product> productNameList = productService.findByContains(findProductName);

		List<ProductListDto> productListDto = new ArrayList<>();
		List<ProductNameDto> productNameDto = new ArrayList<>();
		List<Product> products = productService.findAllProductByCategory(product.getProductCategory(), product.getProductPetCategory());
		
		for (Product productCategory : products) {
			productListDto.add(ProductListDto.toDto(productCategory));
		}

		for (Product productName : productNameList) {
			productNameDto.add(ProductNameDto.toDto(productName));
		}
		
		model.addAttribute("product", product);
		model.addAttribute("products", productListDto);
		model.addAttribute("productName", productNameDto);
		
		return "product-details";
	}
	
	@GetMapping("/findAllProductByCategory")
	public String findAllProductByCategory(Model model, HttpSession session, @RequestParam Integer a) {
		Product product = Product.builder().build();
		List<ProductListDto> productListDto = new ArrayList<>();
		List<Product> productList = productService.findAllProductByCategory(product.getProductCategory(), product.getProductPetCategory());
		
		for (Product products : productList) {
			productListDto.add(ProductListDto.toDto(products));
		}
		
		model.addAttribute("productList", productListDto);
		
		return "shop";
	}
	
	
	
	
}
