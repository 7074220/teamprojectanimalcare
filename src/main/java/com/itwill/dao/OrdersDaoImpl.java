package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Orders;
import com.itwill.repository.OrdersRepository;
@Repository
public class OrdersDaoImpl implements OrdersDao{
@Autowired
OrdersRepository ordersRepository;
	
	@Override
	public Orders insertOrder(Orders order) {
		Orders saveOrder=ordersRepository.save(order);
		return saveOrder;
	}

	@Override
	public Orders updateOrder(Orders updateOrder) {
		Orders upOrder=ordersRepository.save(updateOrder);
		return upOrder;
	}

	@Override
	public void deleteOrder(Long orderNo) {
		ordersRepository.deleteById(orderNo);
	}

	@Override
	public List<Orders> findAllOrders() {
		List<Orders> Orders = ordersRepository.findAll();
		return Orders;
		
	}
	
	@Override
	public Orders findOrderByNo(Long orderNo) {
		Orders order = ordersRepository.findById(orderNo).get();
		return order;
	}

	
	
	@Override
	public List<Orders> findOrdersById(String userId) {
		List<Orders> orders = ordersRepository.findAllByUserId(userId);
		return orders;
	}


	@Override
	public List<Orders> findAllByOrderByOrderNoDesc() {
		List<Orders> orders = ordersRepository.findAllByOrderByOrderNoDesc();
		return orders;
	}

}
