package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.CartDao;
import com.itwill.dao.OrdersDao;
import com.itwill.entity.Cart;
import com.itwill.entity.Coupon;
import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;
@Service
public class OrderServiceImpl implements OrderService{
@Autowired 
OrdersDao ordersDao;
CartDao cartDao;

	
	@Override
	public Orders insertOrder(Orders order) {
		String userId=order.getUserinfo().getUserId();
		List<OrderItem> orderItems = order.getOrderItems();
		List<Cart> cartList = order.getUserinfo().getCarts();
		for (int i = 0; i < orderItems.size(); i++) {
			orderItems.get(i).setOrders(order);
			
		}
		
		
		cartDao.findAllCartByUserId(userId);
		order.builder()
				.orderItems(null)
	
				.build();
		
		cartDao.deleteByUserId(userId);
		Orders insertOrders=ordersDao.insertOrder(order);
	return insertOrders;
	
	}
	//배송지변경
	@Override
	public Orders modifyOrder(Orders updateOrder) throws Exception {
		Optional<Orders> orderOptional = Optional.of(ordersDao.findOrderByNo(updateOrder.getOrderNo()));
		Orders uporders=null;
		if(orderOptional.isPresent()) {
			Orders orders = orderOptional.get();
			orders.setOrderAddress(updateOrder.getOrderAddress());
			uporders=ordersDao.updateOrder(orders);
		}else {
			throw new Exception("오류입니다.");
		}
		return uporders;
	}

	@Override
	public void removeOrder(Long orderNo)throws Exception {
		Optional<Orders> ordersOptional = Optional.of(ordersDao.findOrderByNo(orderNo));
		if(ordersOptional.isEmpty()) {
			throw new Exception("존재하지않습니다.");
		
			}
		ordersDao.deleteOrder(orderNo);
		
	}
//전체주문 조회
	@Override
	public List<Orders> findOrders() {
	
		return ordersDao.findAllOrders();
	}
	//주문한개 조회
	@Override
	public Orders findOrderByNo(Long orderNo) {
		
		return ordersDao.findOrderByNo(orderNo);
	}

	//회원주문목록조회
	@Override
	public List<Orders> findOrderById(String userId) {
		
		return ordersDao.findOrdersById(userId);
	}

	//회원주문목록 최신순으로 정렬
	@Override
	public List<Orders> findOrderByIdDesc(String userId) {
		return ordersDao.findAllByUserIdDESC(userId);
	}

	//전체주문 최신순으로 정렬
	@Override
	public List<Orders> findAllByOrderByOrderNoDesc(Long orderNo) {
		
		return ordersDao.findAllByOrderByOrderNoDesc();
	}

}
