package com.itwill.service;

import java.util.List;

import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;

public interface OrderItemService {

	public OrderItem insertOrderItem(OrderItem orderItem);
	
	public OrderItem updateOrderItem(OrderItem orderItem);
	
	public OrderItem deleteOrderItem(OrderItem orderItem);
	
	public List<OrderItem> findAll();
}
