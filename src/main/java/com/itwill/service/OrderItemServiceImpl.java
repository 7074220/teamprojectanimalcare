package com.itwill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.OrderItemDao;
import com.itwill.entity.OrderItem;
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemDao orderItemDao;
	@Override
	public OrderItem insertOrderItem(OrderItem orderItem) {
		
		return orderItemDao.insertOrderItem(orderItem);
	}
 
}
