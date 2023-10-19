package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTest;

class CouponDaoImplTest extends TeamprojectAnimalcareApplicationTest{

	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test() {
		
	}

}
