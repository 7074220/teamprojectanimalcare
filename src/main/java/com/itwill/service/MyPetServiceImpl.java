package com.itwill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.MyPetDao;

@Service
public class MyPetServiceImpl implements MyPetService{
	
	@Autowired
	MyPetDao myPetDao;
	
	
	
}
