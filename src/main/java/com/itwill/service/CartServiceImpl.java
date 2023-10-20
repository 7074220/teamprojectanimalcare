package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.dao.CartDao;
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
	
	@Override
	public Cart findByCartNo(Long no) {
		Cart findCart = cartRepository.findById(1L).get();
		return findCart;
	}

	@Override
	public void deleteByUserId(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long no) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer cartTotalPrice(String userId) {
		List<Cart> cartList = cartRepository.findAllCartByUserId(userId);
		Integer total = 0;
		for (Cart cart : cartList) {
			total = total + cart.getProduct().getProductPrice();
		}
		return total;
	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> findAllCartByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer cartSelectTotalPrice(Long no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
