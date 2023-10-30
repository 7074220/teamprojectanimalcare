package com.itwill.controller;

import java.nio.charset.Charset;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.CartDto;
import com.itwill.dto.OrderItemDto;
import com.itwill.dto.OrdersDto;
import com.itwill.dto.ProductListDto;
import com.itwill.entity.Cart;
import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;
import com.itwill.entity.Orderstatus;
import com.itwill.repository.OrderStatusRepository;
import com.itwill.service.CartService;
import com.itwill.service.OrderItemService;
import com.itwill.service.OrderService;
import com.itwill.service.OrderStatusService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.criteria.Order;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/order")

public class OrderRestController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	OrderStatusRepository orderStatusRepository;

	@Autowired
	OrderItemService itemService;
	
	
	
	@Operation(summary = "주문 등록")
	@PostMapping("/insert_Order")
	public ResponseEntity<OrdersDto> insert_Order(@RequestBody OrdersDto orderDto, HttpSession session,int totalPrice)throws Exception {
		Long userNo = (Long) session.getAttribute("userNo");
		Orderstatus orderstatus= orderStatusRepository.findById(1L).get();
		Long osNo = orderstatus.getOsNo();
		List<Cart> carts = cartService.findAllCartByUserId(userNo);
		
			for (Cart cart : carts) {
			List<OrderItemDto> orderItemDtos = orderDto.getOrderItemDtos();
			OrderItemDto tempOrderItemDto=OrderItemDto.builder().build();
			tempOrderItemDto.setOiQty(cart.getCartQty());
			tempOrderItemDto.setOrderNo(orderDto.getOrderNo());
			tempOrderItemDto.setOsNo(osNo);
			tempOrderItemDto.setProductNo(cart.getProduct().getProductNo());
			
			itemService.insertOrderItem(tempOrderItemDto.toEntity(tempOrderItemDto));
			orderDto.setOrderItemDtos(orderItemDtos);
			}
			orderDto.setOrderPrice(totalPrice);
			orderDto.setOrderDesc(carts.get(0).getProduct().getProductName()+"외"+carts.size()+"상품");
			cartService.deleteById(userNo);
			orderService.insertOrder(orderDto.toEntity(orderDto));
			
			return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
			
	}
	
	@Operation(summary = "주문 번호로 조회")
	@GetMapping("/{orderNo}")
	public ResponseEntity<OrdersDto> findOrdersByNo(@PathVariable(name = "orderNo") Long no, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Orders findOrder = orderService.findOrderByNo(no);
		OrdersDto ordersDto = OrdersDto.toDto(findOrder);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<OrdersDto>(ordersDto, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "주문 전체 조회 , 관리자전용")
	@GetMapping("/ordersList")
	public ResponseEntity<List<OrdersDto>> findOrders() {
		List<Orders> orderList = orderService.findOrders();
		List<OrdersDto> ordersDto = new ArrayList<OrdersDto>();
		
		for (Orders orders : orderList) {
			ordersDto.add(OrdersDto.toDto(orders));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<OrdersDto>>(ordersDto, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "회원아이디로 주문조회")
	@GetMapping("/ordersList/{userNo}")
	public ResponseEntity<List<OrdersDto>> findOrderById(@PathVariable(name = "userNo") Long no, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		List<Orders> orderList = orderService.findOrderById(no);
		List<OrdersDto> ordersDto = new ArrayList<OrdersDto>();
		
		for (Orders orders : orderList) {
			ordersDto.add(OrdersDto.toDto(orders));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<OrdersDto>>(ordersDto, httpHeaders, HttpStatus.OK);
	}
		
	@Operation(summary = "회원아이디로 주문 정렬")
	@GetMapping("/ordersList/desc/{userNo}")
	public ResponseEntity<List<OrdersDto>> findOrderByIdDesc(@PathVariable(name = "userNo") Long no, HttpSession session) throws Exception {
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		List<Orders> orderList = orderService.findOrderByIdDesc(no);
		List<OrdersDto> ordersDto = new ArrayList<OrdersDto>();
		
		for (Orders orders : orderList) {
			ordersDto.add(OrdersDto.toDto(orders));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<OrdersDto>>(ordersDto, httpHeaders, HttpStatus.OK);
	}
			
	@Operation(summary = "주문 번호로 내림차순 정렬")
	@PostMapping("/{orderNo}")
	public ResponseEntity<List<OrdersDto>> findAllByOrderByOrderNoDesc(@PathVariable(name = "orderNo") Long orderNo){
		List<OrdersDto> ordersListDto = new ArrayList<OrdersDto>();
		List<Orders> ordersList = orderService.findAllByOrderByOrderNoDesc(orderNo);
	
		for (Orders orders : ordersList) {
			OrdersDto ordersDto = OrdersDto.toDto(orders);
			ordersListDto.add(ordersDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<OrdersDto>>(ordersListDto, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "날짜별 기간으로 조회")
	@GetMapping("/{startDate}/{endDate}")
	public ResponseEntity<List<OrdersDto>> findAllByOrdersByOrderDate(@PathVariable(name = "startDate") Date startDate, @PathVariable(name = "endDate") Date endDate){
		List<OrdersDto> ordersListDto = new ArrayList<OrdersDto>();
		List<Orders> ordersList = orderService.findAllByOrdersByOrderDate(startDate, endDate);
		
		for (Orders orders : ordersList) {
			OrdersDto ordersDto = OrdersDto.toDto(orders);
			ordersListDto.add(ordersDto);
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<OrdersDto>>(ordersListDto, httpHeaders, HttpStatus.OK);
	}
}


