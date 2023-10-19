package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Cart;
import com.itwill.repository.CartRepository;

@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart insertCart(Cart cart) {
		Cart savedCart = cartRepository.save(cart);
		return savedCart;
	}

	
	@Override
	public Cart update_qty(Cart updateQty) throws Exception {
		return cartRepository.save(updateQty);
	}
/*
	@Override
	public void deleteCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int totalPrice(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productWithKindByUserId(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
}
