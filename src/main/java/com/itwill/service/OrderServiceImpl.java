package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.CartDao;
import com.itwill.dao.OrdersDao;
import com.itwill.entity.Cart;
import com.itwill.entity.Orders;
import com.itwill.entity.Userinfo;
@Service
public class OrderServiceImpl implements OrderService{
@Autowired 
OrdersDao ordersDao;
CartDao cartDao;

	
	@Override
	public Orders insertOrder(Orders order) {
		//주문 회원
		String userId =order.getUserinfo().getUserId();
		//유저 카트리스트 
		List<Cart> cartList = order.getUserinfo().getCarts();
		//카트 총 가격
		int cartprice = 0;
		int total = 0;
		for (Cart cart : cartList) {
			cartprice=cart.getCartQty()*cart.getProduct().getProductPrice();
			total+=cartprice;
		}
		order.setOrderPrice(total);
		Orders insertOrder=ordersDao.insertOrder(order);
		
		//주문완료후 장바구니 전체삭제
		cartDao.deleteByUserId(userId);
		return insertOrder;
	
	}

	@Override
	public Orders modifyOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOrder(Long orderNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orders> findOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findOrderByNo(Long orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findOrderById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findOrderByIdDesc(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findAllByOrderByOrderNoDesc(Long orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
