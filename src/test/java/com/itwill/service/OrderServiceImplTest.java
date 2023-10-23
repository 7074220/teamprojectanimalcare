package com.itwill.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.dao.OrdersDao;
import com.itwill.entity.Orders;
import com.itwill.entity.Userinfo;

class OrderServiceImplTest extends TeamprojectAnimalcareApplicationTest {
	@Autowired
	OrderService orderService;
	@Autowired
	UserInfoService userInfoService;

	@Test
	@Transactional

	@Disabled
	void insert() throws Exception {
		Userinfo user = userInfoService.findUser(2L);

		Orders orders = Orders.builder().orderAddress("서울특별시").orderDesc("카트삭제되는 주문").userinfo(user).orderPrice(1555)
				.build();
		orderService.insertOrder(orders);

	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void update() throws Exception {
		Orders order = orderService.findOrderByNo(1L);
		order.setOrderAddress("남양주시");
		orderService.modifyOrder(order);

	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void delete() throws Exception {
		orderService.removeOrder(1L);

	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findOrders() throws Exception {
		System.out.println(orderService.findOrders());

	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findOrdersByNo() throws Exception {
		System.out.println(orderService.findOrderByNo(2L));

	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findOrdersById() throws Exception {
		System.out.println(orderService.findOrderById("박태환"));

	}

	@Test
	@Transactional
	@Rollback(false)
	// @Disabled
	void findOrderByIdDesc() throws Exception {
		System.out.println(orderService.findOrderByIdDesc("박태환"));

	}

}