package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.AdoptDao;
import com.itwill.entity.Adopt;


@Service
public class AdoptServiceImpl implements AdoptService{
	@Autowired
	private AdoptDao adoptDao;

	@Override
	public Adopt findByNoAdopt(Long no) {                  
		Adopt findAdopt=adoptDao.findByNoAdopt(no);
		return findAdopt;
	}

	@Override
	public Adopt insertAdopt(Adopt adopt) {             
		Adopt insertAdopt=adoptDao.insertAdopt(adopt);
		return insertAdopt;
	}

	@Override
	public Adopt updateAdopt(Adopt adopt) throws Exception {                   
		return adoptDao.updateAdopt(adopt);
	}

	@Override
	public void deleteAdopt(Long no) throws Exception {
		adoptDao.deleteAdopt(no);
	}

	@Override
	public List<Adopt> findAdoptList() {
		List<Adopt> adoptList=adoptDao.findAdoptList();
		return adoptList;
		
	}

	@Override
	public List<Adopt> findByUserinfoUserId(String userId) {
		return adoptDao.findByUserinfoUserId(userId);
	}

}
