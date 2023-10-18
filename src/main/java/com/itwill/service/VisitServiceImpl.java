package com.itwill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.VisitDao;
import com.itwill.entity.Visit;
import com.itwill.repository.VisitRepository;

@Service
public class VisitServiceImpl implements VisitService {
	
	@Autowired
	private VisitRepository visitRepository;

	@Override
	public Visit createVisit(Visit visit) {
		Visit saveVisit = visitRepository.save(visit);
		return saveVisit;
	}

	@Override
	public Visit selectVisit(Long visitNo) {
		return visitRepository.findById(visitNo).orElse(null);
	}

	@Override
	public void deleteVisit(Long visitNo) throws Exception {
		visitRepository.deleteById(visitNo);

	}

	@Override
	public List<Visit> selectAllVisits() {
		return visitRepository.findAll();
	}

	@Override
	public Visit updateVisit(Visit visit) throws Exception {
		Optional<Visit> optionalVisit = visitRepository.findById(visit.getVisitNo());

		if (optionalVisit.isPresent()) {
			Visit findVisit = optionalVisit.get();

			findVisit.setVisitDate(visit.getVisitDate());
			//findVisit.setVisitstatus(visit.getVisitstatus());
			findVisit.setVisitTime(visit.getVisitTime());
			return findVisit;
		} else {

			throw new Exception("방문 정보를 찾을 수 없습니다.");
		}
	}

}
