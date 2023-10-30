package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.OrderItemDto;
import com.itwill.dto.OrdersDto;
import com.itwill.entity.Cart;
import com.itwill.entity.OrderItem;
import com.itwill.entity.Orderstatus;
import com.itwill.repository.OrderStatusRepository;
import com.itwill.service.CartService;
import com.itwill.service.OrderItemService;
import com.itwill.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
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
			
			cartService.deleteById(userNo);
			orderService.insertOrder(orderDto.toEntity(orderDto));
			
			return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
			
	}

}
