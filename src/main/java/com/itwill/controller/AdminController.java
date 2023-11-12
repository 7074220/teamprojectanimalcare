package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.AdminUserListDto;
import com.itwill.dto.OrdersDto;
import com.itwill.dto.PetDto;
import com.itwill.dto.ProductInsertDto;
import com.itwill.dto.ProductListDto;
import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Adopt;
import com.itwill.entity.Center;
import com.itwill.entity.Orders;
import com.itwill.entity.Pet;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;
import com.itwill.entity.Volunteer;
import com.itwill.repository.AdoptRepository;
import com.itwill.repository.VisitRepository;
import com.itwill.repository.VolunteerRepository;
import com.itwill.service.AdoptService;
import com.itwill.service.CartService;
import com.itwill.service.CenterService;
import com.itwill.service.MyPetService;
import com.itwill.service.OrderService;
import com.itwill.service.PetService;
import com.itwill.service.ProductService;
import com.itwill.service.UserInfoService;
import com.itwill.service.VisitService;
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
		private AdoptRepository adoptRepository;
		@Autowired
		private VolunteerService volunteerService;
		@Autowired
		private VolunteerRepository volunteerRepository;
		@Autowired
		private PetService petService;
		@Autowired
		private VisitService visitService;
		@Autowired
		private VisitRepository visitRepository;
		@Autowired
		private CenterService centerService;
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
		
		
		// 관리자 -> 봉사 리스트 조회
		@GetMapping("/adminVolunteerList")
		public String volunteerList(Model model, HttpSession session) throws Exception{
			Long userNo = (Long) session.getAttribute("userNo");
			Userinfo userinfo = userInfoService.findUserByNo(userNo);
			
			List<Volunteer> volunteerList;
			volunteerList = volunteerService.findAllVolunteers();
			
		    model.addAttribute("volunteerList", volunteerList);
		    return "my-account-volunteer";
		}
		
		
		
		@GetMapping("/updateVolunteer/{volunteerNo}")
		public String updateVolunteer(@PathVariable Long volunteerNo, Model model, HttpSession session) throws Exception {
		    Long userNo = (Long) session.getAttribute("userNo");
		    Userinfo userinfo = userInfoService.findUserByNo(userNo);
		    
		    Volunteer findVolunteer = volunteerService.findByVolunteerNo(volunteerNo);

		    // 로그를 이용한 디버깅
		    System.out.println("Before update: " + findVolunteer.getVolunteerStatus());

		    // Visit 업데이트 로직
		    findVolunteer.setVolunteerStatus("봉사완료"); 
		    volunteerService.updateVolunteer(findVolunteer);

		    // 로그를 이용한 디버깅
		    System.out.println("After update: " + findVolunteer.getVolunteerStatus());

		    // 변경된 상태를 DB에 반영
		    volunteerRepository.save(findVolunteer);

		    return "redirect:/adminVolunteerList";
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
		
		
		
		
		
		/******************************* Orders ************************************/
		
		
		//관리자전용
		@GetMapping("/adminOrdersList")
		public String adminOrderList(Model model,HttpSession session) throws Exception {
			List<Orders> orderList = orderService.findOrders();
			List<OrdersDto> ordersDto = new ArrayList<OrdersDto>();
				for (Orders orders : orderList) {
					Userinfo userinfo = orders.getUserinfo();
					OrdersDto dto = OrdersDto.toDto(orders);
					dto.setUserinfo(userinfo);
					ordersDto.add(dto);
				}
				model.addAttribute("adminOrdersList",ordersDto);
				return "admin-orders";
			
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
		
		
		
		/******************************* visit ************************************/
		// 관리자 --> 견학 리스트
		@GetMapping("/adminVisitList")
		public String findOrders(Model model, HttpSession  session) throws Exception {
			Long userNo = (Long) session.getAttribute("userNo");
			Userinfo userinfo = userInfoService.findUserByNo(userNo);
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+userinfo);
			List<Visit> visitList;
			visitList = visitService.selectAllVisits();
			
		    model.addAttribute("visitList", visitList);
		    return "admin-visit";
		}
		@GetMapping("/updateVisit/{visitNo}")
		public String updateVisit(@PathVariable Long visitNo, Model model, HttpSession session) throws Exception {
		    Long userNo = (Long) session.getAttribute("userNo");
		    Userinfo userinfo = userInfoService.findUserByNo(userNo);
		    Visit findVisit = visitService.findByVisitNo(visitNo);

		    // 로그를 이용한 디버깅
		    System.out.println("Before update: " + findVisit.getVisitStatus());

		    // Visit 업데이트 로직
		    findVisit.setVisitStatus("견학완료"); 
		    visitService.updateVisit(findVisit);

		    // 로그를 이용한 디버깅
		    System.out.println("After update: " + findVisit.getVisitStatus());

		    // 변경된 상태를 DB에 반영
		    visitRepository.save(findVisit);

		    return "redirect:/adminVisitList";
		}

		/******************************* center ************************************/
		
		@GetMapping("/centerListAll")
		public String centerList(Model model) {
		    List<Center> centerList = centerService.findAllCenters();
		    model.addAttribute("centerList", centerList);
		    return "admin-center";
		}
		
}
