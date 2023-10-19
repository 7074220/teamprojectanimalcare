package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Center;

public interface CenterDao {

	Center createCenter(Center center);
	
	Center selectCenter(Long centerNo);
	
	Center updateCenter(Center center);
	
	void deleteCenter(Long centerNo);
	
	List<Center> selectAllCenters();
}
