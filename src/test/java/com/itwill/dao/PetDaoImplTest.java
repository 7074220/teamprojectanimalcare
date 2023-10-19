package com.itwill.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.TeamprojectAnimalcareApplicationTests;
import com.itwill.entity.Pet;

class PetDaoImplTest extends TeamprojectAnimalcareApplicationTests{
	@Autowired
	PetDao petDao;
	@Test
	@Transactional
	@Rollback(false)
void test() {
		
		Pet pet = Pet.builder()
				.petLocal("서울특별시")
				.petType("프렌치불독")
				.petgender("암컷")
				.petRegisterDate(LocalDate.now())
				.petFindPlace("서울특별시")
				.petCharacter("이쁘고 온순하다")
				.petCenter("범석보호소")
				.build();
	petDao.petInsert(pet);
}
}
