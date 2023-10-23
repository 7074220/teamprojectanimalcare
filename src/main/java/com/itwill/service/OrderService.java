package com.itwill.service;

import java.util.List;

import com.itwill.entity.Orders;

public interface OrderService {

	
	//order insert 시 장바구니 전체삭제 , 
	
	Orders insertOrder(Orders order);
	
	
	Orders modifyOrder(Orders order) throws Exception;
	//주문삭제 관리자전용
	void removeOrder(Long orderNo) throws Exception;
	//주문 전체 조회 , 관리자전용
	List<Orders> findOrders();
	
	//주문 번호로 조회
	Orders findOrderByNo(Long orderNo);
	
	//회원아이디로 주문조회
	List<Orders> findOrderById(String userId);
	
	List<Orders>findOrderByIdDesc(String userId);
	//
	List<Orders>findAllByOrderByOrderNoDesc(Long orderNo);
	
	
	
}
