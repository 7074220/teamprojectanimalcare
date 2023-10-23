package com.itwill.repository;

import java.util.Date;
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
	
	
	//userno로 주문목록 조회
	 @Query(value = "SELECT * FROM Orders o WHERE o.user_no = :user_no",nativeQuery = true)
	List<Orders> findAllByUserNo(@Param("user_no")Long userNo);
	 
	//userno로 최신 주문목록 조회
		 @Query(value = "SELECT * FROM Orders o WHERE o.user_no = :user_no ORDER BY o.order_no DESC",nativeQuery = true)
		List<Orders> findAllByUserNoDESC(@Param("user_no")Long userNo);
		
		 //기간별로 주문목록 조회
		 @Query(value = "SELECT * FROM Orders o where o.order_date BETWEEN :startDate AND :endDate",nativeQuery = true)
		  List<Orders> findAllByOrdersByOrderDate(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
		 
		 

}
