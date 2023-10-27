package com.itwill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Wish;

public interface WishService {

	// 위시리스트에 담기
	Wish insertWish(Wish wish);

	// 위시리스트에서 삭제
	void deleteWish(Long no) throws Exception;

	// 위시리스트 모두 출력 (userNo)
	List<Wish> findAllWishByUserNo(Long userNo);
	
	// 위시리스트에서 하나 찾기
	Wish findByWishNo(Long no);
	
	// 위시리스트에서 userNo, productNo로 찾아오기
	Wish findByUserNoProductNo(Long userNo, Long productNo);

}
