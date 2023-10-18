package com.itwill.dao;

import java.util.List;

import com.itwill.entity.Adopt;

public interface AdoptDao {
	
	Adopt insertAdopt(Adopt adopt);

	Adopt selectAdopt(Long no);

	Adopt updateAdopt(Adopt adopt) throws Exception;

	void deleteAdopt(Long no) throws Exception;

	List<Adopt> selectList();

}
