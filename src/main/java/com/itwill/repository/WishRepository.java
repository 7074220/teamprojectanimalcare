package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.Wish;

public interface WishRepository extends JpaRepository<Wish, Long>{

	// 위시리스트 모두 출력 (userNo)
	@Query(value = "select * from wish where user_no=?1", nativeQuery = true)
	List<Wish> findAllByUserNo(Long userNo);
}
