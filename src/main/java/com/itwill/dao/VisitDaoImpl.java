package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;
import com.itwill.repository.VisitRepository;
@Repository
public class VisitDaoImpl implements VisitDao {

	@Autowired
	VisitRepository visitRepository;

	@Override
	public Visit createVisit(Visit visit) {
		visitRepository.save(visit);	
		return visit;
	}

	@Override
	public Visit findByVisitNo(Long visitNo) {
	    return visitRepository.findById(visitNo).get();
	}


	@Override
	public void deleteVisit(Long visitNo) {
		visitRepository.deleteById(visitNo);
	
	}

	@Override
	public List<Visit> selectAllVisits() {
		return visitRepository.findAll();
	}

	@Override
	public Visit updateVisit(Visit visit) {
		return visitRepository.save(visit);
	}
	 //userid로 visit리스트 검색
	  @Override
	    public List<Visit> getVisitsByUserNo(String userNo) {
	        return visitRepository.findByUserinfoUserNo(userNo);
	    }

}
