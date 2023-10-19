package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
}
