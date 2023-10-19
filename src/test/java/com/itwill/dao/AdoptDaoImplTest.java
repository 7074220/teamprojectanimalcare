package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Adopt;
import com.itwill.entity.Pet;


@SpringBootTest
class AdoptDaoImplTest {

	@Autowired
	AdoptDao adoptDao;
	
	
	
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test() {
		
		
		Adopt adopt = Adopt.builder()
							.adoptNo(1L)
							.adoptDate(LocalDate.now())
							.adoptTime(11L)
							.pet(null)
							.status("입양완료")
							.userinfo(null)	
							.build();
		adoptDao.insertAdopt(adopt);
		
	}

}
