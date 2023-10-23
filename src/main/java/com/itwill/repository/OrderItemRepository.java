package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.OrderItem;
import com.itwill.entity.Userinfo;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
