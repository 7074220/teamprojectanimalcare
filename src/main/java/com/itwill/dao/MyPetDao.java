package com.itwill.dao;

import java.util.List;

import com.itwill.entity.MyPet;

public interface MyPetDao {

     public MyPet CreatePet(MyPet myPet);
     
     public void DeletePet(Long mypetNo);
     
     public MyPet UpdatePet(MyPet myPet);
     
     public List<MyPet> findAll();
     
     public MyPet findByNo(Long mypetNo);
    
     public List<MyPet> findMyPetListByuserNo(Long userNo);
   
     public void deleteMypetByUserNo(Long userNo,Long mypetNo);
     
     public void deleteMypetAllByUserNo(Long userNo);
}