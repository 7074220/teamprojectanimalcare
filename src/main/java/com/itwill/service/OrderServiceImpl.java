package com.itwill.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.CartDao;
import com.itwill.dao.OrderItemDao;
import com.itwill.dao.OrdersDao;
import com.itwill.dao.ProductDao;
import com.itwill.entity.Cart;
import com.itwill.entity.Coupon;
import com.itwill.entity.OrderItem;
import com.itwill.entity.Orders;
import com.itwill.entity.Orderstatus;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;
import com.itwill.repository.OrderStatusRepository;
@Service
public class OrderServiceImpl implements OrderService{
@Autowired 
OrdersDao ordersDao;
@Autowired 
CartDao cartDao;
@Autowired 
OrderItemDao orderItemDao;
@Autowired
ProductDao productDao;
@Autowired
OrderStatusRepository orderStatusRepository;
	
	@Override
	public Orders insertOrder(Orders order) {
		Long userNo = order.getUserinfo().getUserNo();
		List<Cart> carts = cartDao.findAllCartByUserId(userNo);
		int price = 0;
		
		for (Cart cart : carts) {
			List<OrderItem> orderItems = order.getOrderItems();
			OrderItem tempOrderItem = OrderItem.builder().build();
			Long p_no = cart.getProduct().getProductNo();
			tempOrderItem.setOrders(order);
			tempOrderItem.setOrderStatus(orderStatusRepository.findById(1L).get()); 
			tempOrderItem.setOiQty(cart.getCartQty());
			tempOrderItem.setProduct(productDao.findByProductNo(p_no));
			//price = price +(cart.getProduct().getProductPrice()*cart.getCartQty());
			orderItemDao.insertOrderItem(tempOrderItem);
			
			order.setOrderItems(orderItems);
			
			
		}//유저 정보만 세팅하고 인서트 테스트 진행
		
		cartDao.deleteByUserId(order.getUserinfo().getUserNo());
		return ordersDao.insertOrder(order);
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


	//전체주문 최신순으로 정렬
	@Override
	public List<Orders> findAllByOrderByOrderNoDesc(Long orderNo) {
		
		return ordersDao.findAllByOrderByOrderNoDesc();
	}
	//회원주문목록조회
	@Override
	public List<Orders> findOrderById(Long userNo) {
		return ordersDao.findOrdersByuserNo(userNo);
	}
	@Override
	public List<Orders> findOrderByIdDesc(Long userNo) {
		return ordersDao.findAllByUserNoDESC(userNo);
	}
	@Override
	public List<Orders> findAllByOrdersByOrderDate(Date startDate, Date endDate) {
		return ordersDao.findAllByOrdersByOrderDate(startDate,endDate);
	}

}