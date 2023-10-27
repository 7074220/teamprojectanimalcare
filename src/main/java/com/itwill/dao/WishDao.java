package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Wish;

public interface WishDao {

	
	// 위시리스트에 담기
	Wish insertWish(Wish wish);
	
	// 위시리스트에서 삭제
	void deleteWish(Long no) throws Exception;
	
	// 위시리스트 모두 출력 (userNo)
	List<Wish> findAllWishByUserNo(Long userNo);
}
