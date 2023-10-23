package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;
import com.itwill.entity.Orders;
import com.itwill.entity.Userinfo;

class OrdersDaoImplTest extends TeamprojectAnimalcareApplicationTest{
@Autowired 
private OrdersDao ordersDao;
	
//유저아이디로 최신주문조회
@Test
//@Disabled
@Transactional
@Rollback(false)
	void findOrdersById() {
		
	List<Orders> orders = ordersDao.findAllByUserIdDESC("박태환");
	
	System.out.println(orders);
	}



//주문최신순으로 조회
@Test
@Disabled
@Transactional
@Rollback(false)
	void findAllByOrderByOrderNoDesc() {
		
	List<Orders> orders = ordersDao.findAllByOrderByOrderNoDesc();
	System.out.println(orders);
	}


@Test
@Disabled
@Transactional
@Rollback(false)
void insert() {
	Orders order1=Orders.builder()
			.orderDate(new Date())
			.orderPrice(5000)
			.orderAddress("서울특별시 구로구")
			.orderDesc("상품 외...")
			.build();
	Userinfo userinfo = Userinfo.builder().userId("호진").build();
	
	order1.setUserinfo(userinfo);
	
	Orders insertOrder = ordersDao.insertOrder(order1);
	
	}
@Test
@Disabled
@Transactional
@Rollback(false)
void update() {
	Orders order = ordersDao.findOrderByNo(1L);
	order.setOrderAddress("충남 보령시");
	ordersDao.insertOrder(order);
}

@Test
@Disabled
@Transactional
@Rollback(false)
void delete() {
	
	ordersDao.deleteOrder(4L);
}

@Test
@Disabled
@Transactional
@Rollback(false)
void findNo() {
	
	Orders order=ordersDao.findOrderByNo(2L);
	System.out.println(order);
}
@Test
//@Disabled
@Transactional
@Rollback(false)
void findall() {
	
	System.out.println(ordersDao.findAllOrders());
}
}



