package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.Center;

public interface CenterDao {

	public Center createCenter(Center center);
	
	public Center findByCenterNo(Long centerNo);

	public Center updateCenter(Center center);
	
	public void deleteCenter(Long centerNo);
	
	public List<Center> findAllCenters();
	//센터이름검색
	public List<Center> findByName(String centerName);
}
