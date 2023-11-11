package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
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
		
		
		@GetMapping(value = "/adminUserList")
		// 관리자 --> 회원정보 리스트
		// 번호, 아이디, 이름, 포인트, 성별, 주소, 연락처
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
		
		
		// 관리자 --> 마이페이지 이동
		@GetMapping(value="/adminUserinfo")
		public String view(Model model, HttpSession session) throws Exception{
			Long userNo = (Long)session.getAttribute("userNo");
			if(userNo==null) {
				throw new Exception("로그인을 해주세요");
			}
			Userinfo userinfo = userInfoService.findUserByNo(userNo);
			model.addAttribute("userinfo", userinfo);
			
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
		
		
		@GetMapping("/adminAdoptList")
		// 관리자 --> 입양신청 리스트
		// 
		public String adoptList(Model model) {
			
			List<Adopt> adoptList = adoptService.findAdoptList();
			
			model.addAttribute("adminAdoptList", adoptList);
			return "admin-adopt";
		}
		
		
		
		
		
		/******************************* Volunteer ************************************/
		
		
		// 관리자 --> 봉사신청 리스트
		@GetMapping("/adminVolunteerList") // 봉사 목록 전체 조회. 관리자
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
			
			productList = productService.findAllByOrderByProductNoAsc();
			
			for (Product product : productList) {
				productListDto.add(ProductListDto.toDto(product));
			}
			
			model.addAttribute("productList", productListDto);
			
			return "admin-product";
		}
		
		
		
		
		// 관리자 --> 상품 추가
		@GetMapping("/adminInsertProduct")
		public String insertProduct(@RequestBody ProductInsertDto dto) {
			
			productService.insertProduct(dto.toEntity(dto));
			
			return "shop";
		}
		
		
		
		
		// 관리자 --> 상품정보 수정
		@GetMapping("/adminUpdateProduct")
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
		@GetMapping("/adminPetList")
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
