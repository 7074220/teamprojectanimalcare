package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.MyPet;
import com.itwill.entity.Userinfo;
import com.itwill.repository.MyPetRepository;
import com.itwill.repository.UserinfoRepository;

@Repository
public class MyPetDaoImpl implements MyPetDao{
	@Autowired
	MyPetRepository myPetRepository;
	
   @Override
   public MyPet CreatePet(MyPet myPet) {
      return myPetRepository.save(myPet);
   }

   @Override
   public void DeletePet(Long mypetNo) {
	   if(myPetRepository.findById(mypetNo).isPresent()) {
		   myPetRepository.deleteById(mypetNo);
		}
   }

   @Override
   public MyPet UpdatePet(MyPet myPet) {
      return myPetRepository.save(myPet);
   }

   @Override
   public List<MyPet> findAll() {
      return myPetRepository.findAll();
   }
   
}

   
   
     
   