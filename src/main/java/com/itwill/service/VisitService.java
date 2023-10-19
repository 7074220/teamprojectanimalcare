package com.itwill.service;

import java.util.List;

import com.itwill.entity.Visit;

public interface VisitService {

    Visit createVisit(Visit visit);

    Visit selectVisit(Long visitNo);

    void deleteVisit(Long visitNo)throws Exception;

    List<Visit> selectAllVisits();

    Visit updateVisit(Visit visit)throws Exception;
}
