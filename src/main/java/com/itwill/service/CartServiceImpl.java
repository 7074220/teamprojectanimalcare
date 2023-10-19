package com.itwill.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.entity.Cart;
import com.itwill.repository.CartRepository;

public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart insertCart(Cart cart) {
		Cart savedCart = cartRepository.save(cart);
		return savedCart;
	}

	@Override
	public Cart update_qty(Cart updateQty) throws Exception {
		Optional<Cart> findCartOptional = cartRepository.findById(updateQty.getCartNo());
		Cart updatedCart = null;
		if(findCartOptional.isPresent()) {
			Cart cart = findCartOptional.get();
			cart.setCartQty(updateQty.getCartQty());
		} else {
			throw new Exception("존재하지 않습니다.");
		}
		return updatedCart;
	}
}
