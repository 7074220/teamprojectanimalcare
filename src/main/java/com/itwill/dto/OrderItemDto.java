package com.itwill.dto;

import java.util.Date;
import java.util.List;

import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;
import com.itwill.entity.Orderstatus;
import com.itwill.entity.Product;
import com.itwill.entity.Userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItemDto {

private Long oiNo;
	
	private Integer oiQty;
	private Long orderNo;
	private Long osNo;
	@Default
	private Product product=new Product();
	
//	private Long orderId;
	
	public static OrderItemDto toDto(OrderItem entity) {
		OrderItemDto orderItemDto = OrderItemDto.builder()
									.oiNo(entity.getOiNo())
									.oiQty(entity.getOiQty())
									.orderNo(entity.getOrders().getOrderNo())
									.product(entity.getProduct())
									.osNo(entity.getOrderStatus().getOsNo())
								 .build();
		
		return orderItemDto;
}

	public static OrderItem toEntity(OrderItemDto dto) {
		OrderItem orderItem = OrderItem.builder()
									.oiNo(dto.getOiNo())
									.oiQty(dto.getOiQty())
									.orders(Orders.builder().orderNo(dto.getOrderNo()).build())
									.orderStatus(Orderstatus.builder().osNo(dto.getOsNo()).build())
									.product(dto.getProduct())
								 .build();
		
		return orderItem;
}
	

}