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
import com.itwill.entity.MyPet;
import com.itwill.entity.Product;
import com.itwill.service.MyPetService;
import com.itwill.service.ProductService;
import com.itwill.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired 
	private MyPetService myPetService;
	
	/*
	// 상품 등록
	public String insertProduct(ProductInsertDto dto) {
		
		productService.insertProduct(ProductInsertDto.toEntity(dto));
		
		return "redirect:shop.html";
	}
	*/
	
	
	// 상품 리스트
	/*
	 * @GetMapping("/productList") public String ProductList(Model model) {
	 * List<ProductListDto> productListDto = new ArrayList<>();
	 * 
	 * 
	 * // 상품번호 큰것부터(최신등록순) List<Product> productList =
	 * productService.findAllByOrderByProductNoDesc();
	 * 
	 * for (Product product : productList) {
	 * productListDto.add(ProductListDto.toDto(product)); }
	 * 
	 * model.addAttribute("productList", productListDto);
	 * 
	 * //System.out.println(productList.get(0).getProductPetCategory()); return
	 * "shop"; }
	 */
	
	
	/*
	 * @GetMapping("/productPriceDesc") public String ProductPriceDesc(Model model)
	 * { List<ProductPriceDescDto> productPriceDescDto = new ArrayList<>(); // 상품가격
	 * 비싼 것부터 List<Product> productPriceDescList =
	 * productService.findAllByOrderByProductPriceDesc();
	 * 
	 * for (Product productPrice : productPriceDescList) {
	 * productPriceDescDto.add(ProductPriceDescDto.toDto(productPrice)); }
	 * 
	 * model.addAttribute("productList", productPriceDescDto);
	 * 
	 * return "shop"; }
	 */
	
	
	@GetMapping("/productPriceDesc")
	// 상품가격 비싼 것부터 --> user의 myPetKind 사용
	public String ProductPriceDesc(Model model, HttpSession session,@RequestParam String path) {
		List<ProductPriceDescDto> productPriceDescDto = new ArrayList<>();
		// 상품가격 비싼 것부터
		List<Product> productList = productService.findAllByOrderByProductPriceDesc();
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();
		
		System.out.println(">>>>>>>>>>>>>"+path);
		if(path.equals("productDogList") ) {
			System.out.println(">>>>>>>>>>>>>강아지");
			myPet.setMypetKind("강아지");
			productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("강아지");
		}
		
		if(path.equals("productCatList")) {
			System.out.println(">>>>>>>>>>>>>고양이");
			myPet.setMypetKind("고양이");
			productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("고양이");
		}
		
		for (Product product : productList) {
			productPriceDescDto.add(ProductPriceDescDto.toDto(product));
		}
		
		model.addAttribute("productList", productPriceDescDto);
		model.addAttribute("myPet", myPet);
		
		return "shop";
	}
	 
	
	/*
	@GetMapping("/productPriceDesc")
	// 상품가격 비싼 것부터 --> user의 myPetKind 사용
	public String ProductDogPriceDesc(Model model, HttpSession session) {
		List<ProductPriceDescDto> productPriceDescDto = new ArrayList<>();
		// 상품가격 비싼 것부터
		//List<Product> productList = productService.findAllByOrderByProductPriceDesc();
		
	
		List<Product> productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("강아지");
		
		
		for (Product product : productList) {
			productPriceDescDto.add(ProductPriceDescDto.toDto(product));
		}
		
		model.addAttribute("productList", productPriceDescDto);
		// System.out.println(productList.get(0).getProductPetCategory());
		return "shop";
	}
	*/
	
	@GetMapping("/productCatPriceDesc")
	// 상품가격 비싼 것부터 --> user의 myPetKind 사용
	public String ProductCatPriceDesc(Model model, HttpSession session) {
		List<ProductPriceDescDto> productPriceDescDto = new ArrayList<>();
		// 상품가격 비싼 것부터
		List<Product> productList = productService.findAllByOrderByProductPriceDesc();
		
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();
		
		productList = productService.findAllByOrderByProductByPetCategoryPriceDesc("고양이");
		
		for (Product product : productList) {
			productPriceDescDto.add(ProductPriceDescDto.toDto(product));
		}
		
		model.addAttribute("productList", productPriceDescDto);
		model.addAttribute("myPet", myPet);
		// System.out.println(productList.get(0).getProductPetCategory());
		return "shop";
	}
	
	
	
	@GetMapping("/productPriceAsc")
	// 상품가격 싼 것부터 --> user의 myPetKind 사용
	public String ProductPriceAsc(Model model, HttpSession session) {
		List<ProductPriceAscDto> productPriceAscDto = new ArrayList<>();
		// 상품가격 비싼 것부터
		List<Product> productList = productService.findAllByOrderByProductPriceAsc();
		
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();
		
		if(userNo != null) {
			myPet = myPetService.findLeaderMyPet(userNo);
			if (myPet == null) {
				myPet = MyPet.builder().build();
				productList = productService.findAllByOrderByProductPriceDesc();
			} else {
				productList = productService.findAllProductByPetCategory(myPet.getMypetKind());
				
			}
		} else {
			productList = productService.findAllByOrderByProductPriceDesc();
			myPet = MyPet.builder().build();
		}
		
		for (Product product : productList) {
			productPriceAscDto.add(ProductPriceAscDto.toDto(product));
		}
		
		model.addAttribute("productList", productPriceAscDto);
		model.addAttribute("myPet", myPet);
		// System.out.println(productList.get(0).getProductPetCategory());
		return "shop";
	}
	
	
	
	/*
	 * @GetMapping("/productPetCategoryList") public String
	 * productPetCategoryList(Model model, String productPetCategory) {
	 * List<ProductListDto> productListDto = new ArrayList<>(); List<Product>
	 * productList = productService.findAllProductByPetCategory(productPetCategory);
	 * 
	 * for (Product product : productList) {
	 * productListDto.add(ProductListDto.toDto(product)); }
	 * 
	 * return ""; }
	 */

	/*
	@PostMapping("/delete/{productNo}")
	public String deleteProduct(@PathVariable(name = "productNo") Long productNo) throws Exception{
		Optional<Product> product = Optional.of(productService.findByProductNo(productNo));
		if(product.isEmpty()) {
			throw new Exception("존재하지 않는 상품입니다.");
		}
		productService.deleteProduct(productNo);
		return "redirect:shop.html";
	}
	*/
	
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
	public String productDogList(Model model, HttpSession session) {
		List<ProductDogListDto> productDogListDto = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();
		
		productList = productService.findAllProductByPetCategory("강아지");
		myPet.setMypetKind("강아지");
		
		
		/*
		if(userNo != null) {
			myPet = myPetService.findLeaderMyPet(userNo);
			if (myPet == null) {
				myPet = MyPet.builder().build();
				productList = productService.findAllByOrderByProductNoDesc();
			} else {
				productList = productService.findAllProductByPetCategory("강아지");
			}
		} else {
			productList = productService.findAllByOrderByProductNoDesc();
			myPet = MyPet.builder().build();
		}
		*/
		
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
	public String productCatList(Model model, HttpSession session) {
		List<ProductCatListDto> productCatListDto = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		
		Long userNo = (Long) session.getAttribute("userNo");
		MyPet myPet = MyPet.builder().build();
		
		productList = productService.findAllProductByPetCategory("고양이");
		myPet.setMypetKind("고양이");
		
		/*
		if(userNo != null) {
			myPet = myPetService.findLeaderMyPet(userNo);
			if (myPet == null) {
				myPet = MyPet.builder().build();
				productList = productService.findAllByOrderByProductNoDesc();
			} else {
				productList = productService.findAllProductByPetCategory("고양이");
			}
		} else {
			productList = productService.findAllByOrderByProductNoDesc();
			myPet = MyPet.builder().build();
		}
		*/
		
		for (Product product : productList) {
			productCatListDto.add(ProductCatListDto.toDto(product));
		}
		
		model.addAttribute("productList", productCatListDto);
		model.addAttribute("myPet", myPet);
		// System.out.println(productList.get(0).getProductPetCategory());
		return "shop";
	}
	
}
