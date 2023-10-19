package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Center;
import com.itwill.repository.CartRepository;
import com.itwill.repository.CenterRepositoty;

@Repository
public class CenterDaoImpl implements CenterDao{
	
	@Autowired
	CenterRepositoty centerRepositoty;
	
	@Override
	public Center createCenter(Center center) {
		centerRepositoty.save(center);
		return center;
	}

	@Override
	public Center selectCenter(Long centerNo) {
		return centerRepositoty.findById(centerNo).get();
	}

	@Override
	public Center updateCenter(Center center) {
		return centerRepositoty.save(center);
	}

	@Override
	public void deleteCenter(Long centerNo) {
		centerRepositoty.deleteById(centerNo);
	}

	@Override
	public List<Center> selectAllCenters() {
		return centerRepositoty.findAll();
	}


	
}
