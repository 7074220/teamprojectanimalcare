package com.itwill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.entity.Adopt;


public interface AdoptRepository extends JpaRepository<Adopt, Long>{
	
	@Query(value = "SELECT * FROM adopt WHERE user_id = ?1", nativeQuery = true)
    List<Adopt> findByUserinfoUserId(@Param("userId") String userId);

	


}
