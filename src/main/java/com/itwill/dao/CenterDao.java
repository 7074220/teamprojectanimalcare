package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.Center;

public interface CenterDao {

	Center createCenter(Center center);
	
	Center findByCenterNo(Long centerNo);

	Center updateCenter(Center center);
	
	void deleteCenter(Long centerNo);
	
	List<Center> findAllCenters();
	//센터이름검색
	List<Center> findByContains(String centerName);
}
