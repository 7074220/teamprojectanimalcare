package com.itwill.dao;

import com.itwill.entity.Orders;

public interface OrdersDao {

	// 주문 완료
	int insertOrders(Orders orders);
}
