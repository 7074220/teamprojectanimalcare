package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.AdminUserListDto;
import com.itwill.dto.PetDto;
import com.itwill.dto.ProductInsertDto;
import com.itwill.dto.ProductListDto;
import com.itwill.entity.Adopt;
import com.itwill.entity.MyPet;
import com.itwill.entity.Orders;
import com.itwill.entity.Pet;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;
import com.itwill.entity.Wish;
import com.itwill.service.AdoptService;
import com.itwill.service.CartService;
import com.itwill.service.MyPetService;
import com.itwill.service.OrderService;
import com.itwill.service.PetService;
import com.itwill.service.ProductService;
import com.itwill.service.UserInfoService;
import com.itwill.service.VolunteerService;
import com.itwill.service.WishService;

import jakarta.servlet.http.HttpSession;

public class AdminController {

	
		@Autowired
		private UserInfoService userInfoService;
		@Autowired
		private CartService cartService;
		@Autowired
		private OrderService orderService;
		@Autowired
		private WishService wishService;
		@Autowired
		private MyPetService myPetService;
		@Autowired
		private ProductService productService;
		@Autowired
		private AdoptService adoptService;
		@Autowired
		private VolunteerService volunteerService;
		@Autowired
		private PetService petService;
		
		
		/******************************* Userinfo ************************************/
		
		
		// 관리자 --> 회원정보 리스트
		@GetMapping(value = "/adminUserList")
		public String adminUserList(Model model) throws Exception {
			
			List<AdminUserListDto> adminUserList = new ArrayList<>();
			List<Userinfo> userList = new ArrayList<>();
			
			userList = userInfoService.findUserList();
			
			for (Userinfo userinfo : userList) {
				adminUserList.add(AdminUserListDto.toDto(userinfo));
			}
			
			model.addAttribute("adminUserList", adminUserList);
			
			return "admin-userinfo";
		}
		
		
		/*
		 
		  ~~~~~~~~~~~~~~~~~~~~ 팀장 이거 수정해달라 ~~~~~~~~~~~~~~~~~~~~~~
		
		// 관리자 --> 회원 탈퇴
		@GetMapping("userDelete")
		public String delete(HttpSession session) throws Exception {
			Long userNo = (Long)session.getAttribute("userNo");
			
			userInfoService.remove(userNo);
			cartService.deleteByUserId(userNo);
			
			List<Orders> orderList = orderService.findOrderById(userNo);
			
			for (Orders orders : orderList) {
				orderService.removeOrderByOrderNo(orders.getOrderNo());
			}
			
			List<Wish> wishs = wishService.findAllWishByUserNo(userNo);
			for (Wish wish : wishs) {
				wishService.deleteWish(wish.getWishNo());
			}

			List<MyPet> myPets = myPetService.findMyPetListByuserNo(userNo);
			for (MyPet myPet : myPets) {
				myPetService.Delete(myPet.getMypetNo());
			}
			
			session.invalidate();
			
			return "index";
		}
		*/
		
		
		/******************************* Adopt ************************************/
		
		
		// 관리자 --> 입양신청 리스트
		@GetMapping("/adoptList")
		public String adoptList(Model model) {
			
			List<Adopt> adoptList = adoptService.findAdoptList();
			
			model.addAttribute("adoptList", adoptList);
			return "my-account";
		}
		
		
		
		
		
		/******************************* Volunteer ************************************/
		
		
		// 관리자 --> 봉사신청 리스트
		@GetMapping("/volunteerList") // 봉사 목록 전체 조회. 관리자
		public String volunteerList(Model model) {
			List<Volunteer> volunteers = volunteerService.findAllVolunteers();    
		    model.addAttribute("volunteers", volunteers);
		    return "my-account";
		}
		
		
		
		
		
		
		/******************************* Product ************************************/
		
		
		
		// 관리자 --> 상품목록 리스트
		@GetMapping("/adminProductList")
		public String adminProductList(Model model, HttpSession session) {
			List<ProductListDto> productListDto = new ArrayList<>();
			List<Product> productList = new ArrayList<>();
			
			Long userNo = (Long) session.getAttribute("userNo");
			
			productList = productService.findAllByOrderByProductNoDesc();
			
			for (Product product : productList) {
				productListDto.add(ProductListDto.toDto(product));
			}
			
			model.addAttribute("productList", productListDto);
			
			return "shop";
		}
		
		
		
		
		// 관리자 --> 상품 추가
		@GetMapping("insertProduct")
		public String insertProduct(@RequestBody ProductInsertDto dto) {
			
			productService.insertProduct(dto.toEntity(dto));
			
			return "shop";
		}
		
		
		
		
		// 관리자 --> 상품정보 수정
		@GetMapping("/updateProduct")
		public String updateProduct(@RequestBody ProductListDto dto, Model model) throws Exception{
			Product product = Product.builder().build();
			
			product.setProductPrice(dto.getProductPrice());
			product.setProductImage(dto.getProductImage());
			product.setProductName(dto.getProductName());
			
			productService.updateProduct(product);
			
			model.addAttribute("product", product);
			
			return "shop";
		}
		
		
		
		
		
		/******************************* Pet ************************************/
		
		
		
		// 관리자 --> 펫 리스트
		@GetMapping("/petList")
		public String petList(Model model) {
			List<PetDto> petDtoList = new ArrayList<>();
			List<Pet> petList = petService.petFindAll();
			for (Pet pet : petList) {
				petDtoList.add(PetDto.toDto(pet));
			}
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+petDtoList.get(0).getPetType());
			model.addAttribute("petList",petDtoList);
			return "pet-list" ;
		}
		
		
		
		
}
