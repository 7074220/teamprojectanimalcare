package com.itwill.dao;

import java.util.List;

import com.itwill.entity.OrderItem;

public interface OrderItemDao {

	//orderItem insert
		OrderItem insertOrderItem(OrderItem orderItem);
		

		OrderItem updateOrderItem(OrderItem orderItem) throws Exception;

		void deleteOrderItemByOrederNo(Long orderNo) throws Exception;
		
		OrderItem findByOrderItem(Long oiNo);
		List<OrderItem> findAllOrderItem();
		List<OrderItem> findAllOrderItemByOrderNo(Long orderNo);
		


}
