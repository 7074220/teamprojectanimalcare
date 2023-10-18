package com.itwill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Adopt;

public interface AdoptService {
	
	Adopt getAdopt(Long no);

	Adopt saveAdopt(Adopt adopt);

	Adopt updateAdopt(Adopt adopt) throws Exception;

	void deleteAdopt(Long no) throws Exception;

	List<Adopt> adopts();
}
