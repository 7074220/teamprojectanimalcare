package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.CartDao;
import com.itwill.entity.Cart;
import com.itwill.repository.CartRepository;

@Transactional
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart insertCart(Cart cart) {
		Cart savedCart = cartDao.insertCart(cart);
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
		Cart findCart = cartRepository.findById(no).get();
		return findCart;
	}

	@Override
	public void deleteByUserId(String userId) {
		cartDao.deleteByUserId(userId);
	}

	@Override
	public void deleteById(Long no) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer cartTotalPrice(String userId) {
		/*
		List<Cart> cartList = cartRepository.findAllCartByUserId(userId);
		Integer total = 0;
		for (Cart cart : cartList) {
			total = total + cart.getProduct().getProductPrice();
			cart.getProduct().getProductPrice();
		}
		*/
		return 0;
		
	} 

	@Override
	public List<Cart> findAll() {
		List<Cart> carts = cartDao.findAll();
		return null;
	}

	@Override
	public List<Cart> findAllCartByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Integer countProductByUserId(String userId, Long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart updateOverlapCart(Cart overlapCart) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
