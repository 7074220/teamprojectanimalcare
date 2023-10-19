package com.itwill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.entity.Adopt;

public interface AdoptService {
	
	Adopt findByNoAdopt(Long no);

	Adopt insertAdopt(Adopt adopt);

	Adopt updateAdopt(Adopt adopt) throws Exception;

	void deleteAdopt(Long no) throws Exception;

	List<Adopt> findAllAdopts(String userId);
}
