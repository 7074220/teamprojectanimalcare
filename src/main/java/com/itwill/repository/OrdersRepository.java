package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Orders;
import com.itwill.entity.Userinfo;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
//최신 등록순으로 조회
	List<Orders> findAllByOrderByOrderNoDesc();
	
	
	//userid로 주문목록 조회
	 @Query(value = "SELECT * FROM Orders o WHERE o.user_id = :user_id",nativeQuery = true)
	List<Orders> findAllByUserId(@Param("user_id")String userId);

}
