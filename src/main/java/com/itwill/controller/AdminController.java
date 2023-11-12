package com.itwill.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.dto.AdminUserListDto;
import com.itwill.dto.OrdersDto;
import com.itwill.dto.PetDto;
import com.itwill.dto.ProductInsertDto;
import com.itwill.dto.ProductListDto;
import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Adopt;
import com.itwill.entity.Center;
import com.itwill.entity.MyPet;
import com.itwill.entity.Orders;
import com.itwill.entity.Pet;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;
import com.itwill.entity.Volunteer;
import com.itwill.entity.Wish;
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
		
		@GetMapping(value = "adminUpdateUser")
		public String update(Model model,@RequestParam Long userNo) throws Exception{
			
			
			Userinfo userinfo = userInfoService.findUserByNo(userNo);
			
			model.addAttribute("userinfo", userinfo);
			
			return "adminUpdateUserInfo";
		}
		
		
		
		@GetMapping("/adminUserDelete")
		public String delete(@RequestParam Long userNo,Model model) throws Exception {
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
			userInfoService.remove(userNo);
			
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
		
		
		@GetMapping("/adminAdoptList")
		// 관리자 --> 입양신청 리스트
		// 
		public String adoptList(Model model, HttpSession session) throws Exception {
			Long userNo = (Long) session.getAttribute("userNo");
			Userinfo userinfo=userInfoService.findUserByNo(userNo);
			List<Adopt> adoptList = adoptService.findAdoptList();
			
			model.addAttribute("adoptList", adoptList);
			return "admin-adopt";
		}
		
		
		@GetMapping("/updateAdopt/{adoptNo}")
		public String updateAdopt(@PathVariable Long adoptNo, Model model, HttpSession session) throws Exception {
		    Long userNo = (Long) session.getAttribute("userNo");
		    Userinfo userinfo = userInfoService.findUserByNo(userNo);
		    
		    Adopt findAdopt = adoptService.findByAdoptNo(adoptNo);

		    
		    // Visit 업데이트 로직
		    findAdopt.setAdoptStatus("입양완료"); 
		    adoptService.updateAdopt(findAdopt);
		   adoptService.deleteAdopt(findAdopt.getAdoptNo());
		  Pet pet= petService.petFindById(findAdopt.getPet().getPetNo());
		  petService.petRemove(pet.getPetNo());
		    // 변경된 상태를 DB에 반영
		    //adoptRepository.save(findAdopt);
		   
		    
		    return "redirect:/adminAdoptList";
		}
		
		
		
		/******************************* Volunteer ************************************/
		
		
		// 관리자 -> 봉사 리스트 조회
		@GetMapping("/adminVolunteerList")
		public String findVolunteerList(Model model, HttpSession session) throws Exception{
			Long userNo = (Long) session.getAttribute("userNo");
			Userinfo userinfo = userInfoService.findUserByNo(userNo);
			
			List<Volunteer> volunteerList;
			volunteerList = volunteerService.findAllVolunteers();
			// volunteerDate를 기준으로 내림차순으로 정렬
		    volunteerList.sort((v1, v2) -> v2.getVolunteerDate().compareTo(v1.getVolunteerDate()));
		
		    model.addAttribute("volunteerList", volunteerList);
		    return "admin-volunteer";
		}
		
		
		/*
		@GetMapping("/updateVolunteer/{volunteerNo}")
		public String updateVolunteer(@PathVariable Long volunteerNo, Model model, HttpSession session) throws Exception {
		    Long userNo = (Long) session.getAttribute("userNo");
		    Userinfo userinfo = userInfoService.findUserByNo(userNo);
		    
		    Volunteer findVolunteer = volunteerService.findByVolunteerNo(volunteerNo);

		    System.out.println("Before update: " + findVolunteer.getVolunteerStatus());

		    findVolunteer.setVolunteerStatus("봉사완료"); 
		    volunteerService.updateVolunteer(findVolunteer);
		    

		    System.out.println("After update: " + findVolunteer.getVolunteerStatus());

		    volunteerRepository.save(findVolunteer);

		    return "redirect:/adminVolunteerList";
		}
		*/
		
		@GetMapping("/updateVolunteer/{volunteerNo}")
		public String updateVolunteer(@PathVariable Long volunteerNo, Model model, HttpSession session) throws Exception {
			try {
		        String userName = (String) session.getAttribute("userName");

		        // userName이 '관리자'인 경우에만 실행
		        if ("관리자".equals(userName)) {
		            // 봉사 정보 가져오기
		            Volunteer findVolunteer = volunteerService.findByVolunteerNo(volunteerNo);

		            // 봉사 상태를 '봉사완료'로 변경
		            findVolunteer.setVolunteerStatus("봉사완료"); 
		            volunteerService.updateVolunteer(findVolunteer);

		            // 해당 봉사에 연결된 사용자의 userNo 가져오기
		            Long userNo = findVolunteer.getUserinfo().getUserNo();

		            // 세션에서 사용자의 포인트 정보 가져오기
		            Integer userPoint = (Integer) session.getAttribute("userPoint");

		            // 사용자 정보 가져오기
		            Userinfo user = userInfoService.findUserByNo(userNo);

		            // 봉사 완료 시 3000포인트 지급 및 누적 포인트 계산
		            if (user != null) {
		                userPoint = (userPoint != null) ? userPoint + 3000 : 3000;
		                user.setUserPoint(userPoint);
		                userInfoService.update(user);
		                // 세션에도 업데이트
		                session.setAttribute("userPoint", userPoint);
		            }

		            // 봉사 정보 저장
		            volunteerRepository.save(findVolunteer);
		        } else {
		            // '관리자'가 아닌 경우에 대한 처리 (예: 에러 페이지로 리다이렉트)
		            return "redirect:/error"; // 적절한 에러 페이지로 변경하세요.
		        }

		        return "redirect:/adminVolunteerList";
		    } catch (Exception e) {
		        e.printStackTrace();
		        // 예외 처리에 대한 추가적인 로직이 필요하다면 여기에 추가하세요.
		        return "redirect:/error"; // 혹은 다른 적절한 에러 페이지로 리다이렉트할 수 있습니다.
		    }
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
		@PostMapping("/adminInsertProduct")
		public String insertProduct(@RequestParam("imageFile1") MultipartFile file1, @RequestParam("imageFile2") MultipartFile file2, @RequestParam("productName") String productName, 
				@RequestParam("productPrice") Integer productPrice, @RequestParam("productCategory") String productCategory, @RequestParam("productPetCategory") String productPetCategory, Model model) throws Exception {

		String uploadPath1 = System.getProperty("user.dir") + "/src/main/resources/static/image/product/";
		String originalFileName1 = file1.getOriginalFilename();
		UUID uuid1 = UUID.randomUUID();
		String savedFileName1 = uuid1.toString() + "_" + originalFileName1;
		
		File newFile1 = new File(uploadPath1 + savedFileName1);
		
		file1.transferTo(newFile1);
		
		String uploadPath2 = System.getProperty("user.dir") + "/src/main/resources/static/image/product/";
		String originalFileName2 = file2.getOriginalFilename();
		UUID uuid2 = UUID.randomUUID();
		String savedFileName2 = uuid2.toString() + "_" + originalFileName2;
		
		File newFile2 = new File(uploadPath2 + savedFileName2);
		
		file2.transferTo(newFile2);
		
		Product createProduct = Product.builder()
							.productName(productName)
							.productPrice(productPrice)
							.productCategory(productCategory)
							.productPetCategory(productPetCategory)
							.productImage(savedFileName1)
							.productDetailImage(savedFileName2)
							.productStarAvg(0D)
							.productQty(0)
							.build();
		
		productService.insertProduct(createProduct);
		
		List<ProductListDto> productListDto = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		
		productList = productService.findAllByOrderByProductNoAsc();
		
		for (Product product : productList) {
			productListDto.add(ProductListDto.toDto(product));
		}
		
		model.addAttribute("productList", productListDto);
		
		return "admin-product";
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
