package com.itwill.service;

import java.util.List;

import com.itwill.entity.Visit;

public interface VisitService {
	
    Visit createVisit(Visit visit);
    //견학신청 리스트생성
    Visit findByVisitNo(Long visitNo);
    //견학 리스트 찾기
    Visit updateVisit(Visit visit);
    //견학 리스트 수정(ex 접수중~접수완료)
    void deleteVisit(Long visitNo);
    //견학 리스트 삭제
    List<Visit> selectAllVisits();
    //견학 리스트 출력
    
    List<Visit> getVisitsByUserNo(String userNo);
	//userid로 visit리스트 검색
}