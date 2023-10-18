package com.itwill.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.entity.Visit;
import com.itwill.repository.VisitRepository;

public class VisitDaoImpl implements VisitDao {

	@Autowired
	VisitRepository visitRepository;

	@Override
	public Visit createVisit(Visit visit) {
		visitRepository.save(visit);	
		return visit;
	}

	@Override
	public Visit selectVisit(Long visitNo) {
		// TODO Auto-generated method stub
		return null;
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

}
