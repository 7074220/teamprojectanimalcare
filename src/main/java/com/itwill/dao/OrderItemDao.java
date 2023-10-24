package com.itwill.dao;

import java.util.List;

import com.itwill.entity.OrderItem;

public interface OrderItemDao {

	//orderItem insert
		OrderItem insertOrderItem(OrderItem orderItem);
		

		OrderItem updateOrderItem(OrderItem updateoOrderItem) throws Exception;

		void deleteOrderItemByOrderNo(Long orderNo) throws Exception;
		
		List<OrderItem> findAllOrderItem();
		List<OrderItem> findAllOrderItemByOrderNo(Long orderNo);
		


}