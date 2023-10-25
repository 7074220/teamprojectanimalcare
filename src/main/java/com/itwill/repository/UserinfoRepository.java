package com.itwill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.entity.Userinfo;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long>{
	
	@Query(value="select count(*) from userInfo where user_id=?1",nativeQuery = true)
	Integer countByUserId(String userId);
	
	@Query(value="select * from userInfo where user_phone_number=?1",nativeQuery = true)
	Userinfo findByUserPhone(String userPhoneNumber);
	
	@Query(value="select * from userInfo where user_id=?1 and user_phone_number=?2",nativeQuery = true)
	Userinfo findPasswordByUserIdPhoneNumber(String userId, String userPhoneNumber);
	
	@Query(value="select * from userInfo where user_id=?1",nativeQuery = true)
	Userinfo findByUserId(String userId);
	
}
