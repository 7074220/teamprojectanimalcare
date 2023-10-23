package com.itwill.dao;

import java.sql.Date;
import java.util.List;

import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;

public interface OrdersDao {
	
	//주문완료
	Orders insertOrder(Orders order) ;
	// 주문변경
	Orders updateOrder(Orders updateOrder) ;
	//주문삭제
	void deleteOrder(Long orderNo) ;


	//모든주문 찾기
	List<Orders> findAllOrders() ;
	
	
	//order 1개 찾기
	Orders findOrderByNo(Long orderNo) ;

	//id로 주문찾기
	List<Orders> findOrdersByNo(Long userNo) ;
	
	//id로 최신주문정렬찾기
		List<Orders> findAllByUserNoDESC(Long userNo);
	
	//최근주문별로 조회
	List<Orders> findAllByOrderByOrderNoDesc();
	
	//날짜별 기간으로 조회
	List<Orders> findAllByOrdersByOrderDate(Date startDate,Date endDate);


	
}
