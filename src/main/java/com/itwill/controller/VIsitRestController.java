package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.CenterDto;
import com.itwill.dto.VisitDto;
import com.itwill.dto.VolunteerDto;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Visit;
import com.itwill.entity.Volunteer;
import com.itwill.service.VisitService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.criteria.Path;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/visit")
public class VIsitRestController {
	
	@Autowired
	private VisitService visitService ;
	
	
		@Operation(summary = "견학신청")
		@PostMapping("/create-VisitDto")
		public ResponseEntity<VisitDto> insertVolunteer(@RequestBody VisitDto dto, HttpSession session) throws Exception {
	        Long userNo = (Long) session.getAttribute("userNo");
	        
	        Integer status = 0;
	        if (userNo == null) {
	            // 로그인하지 않은 사용자에 대한 처리
	        	status = 1;
	        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	        
	        dto.setUserNo(userNo);
	        Visit visit = VisitDto.toEntity(dto);
	        visitService.createVisit(visit);        
	        HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return new ResponseEntity<VisitDto>(dto, httpHeaders, HttpStatus.CREATED);
	    }
	@Operation(summary = "견학리스트조회")
	@GetMapping("/visits")
	public ResponseEntity<List<VisitDto>> visitList() {
		//모든 방문 리스트 조회
		List<Visit> visits = visitService.selectAllVisits();
		List<VisitDto> visitDtoList = new ArrayList<VisitDto>();
		for(Visit visit : visits) {
			visitDtoList.add(VisitDto.toDto(visit));
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<VisitDto>>(visitDtoList, httpHeaders, HttpStatus.OK);
	}

	@Operation(summary = "견학리스트삭제")
	@DeleteMapping("/{visitNo}")
	public ResponseEntity<Map> VisitDelete(@PathVariable(name = "visitNo") Long visitNo) {
		
		try {
		visitService.deleteVisit(visitNo);
		return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("visitNo", visitNo));
		}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@Operation(summary = "견학리스트업데이트")
	@PutMapping("/{centerNo}")
	public ResponseEntity<VisitDto> updateVisit(@PathVariable(name = "centerNo") Long visitNo, @RequestBody VisitDto dto) {
		Visit existingVisit = visitService.findByVisitNo(visitNo);
		
		if (existingVisit != null) {
			if (dto.getCenterNo() != null) {
				 Center center = Center.builder().centerNo(dto.getCenterNo()).build();
				  existingVisit.setCenter(center);
			}
			if (dto.getUserNo() != null) {
				Userinfo userinfo = Userinfo.builder().userNo(dto.getUserNo()).build();
				  existingVisit.setUserinfo(userinfo);
			}
			if (dto.getVisitDate() != null) {
				existingVisit.setVisitDate(dto.getVisitDate());
			}
			if (dto.getVisitTime() != null) {
				existingVisit.setVisitTime(dto.getVisitTime());
			}
			if (dto.getVisitStatus() != null) {
				existingVisit.setVisitStatus(dto.getVisitStatus());
			}
			
			visitService.updateVisit(existingVisit);
			return new ResponseEntity<>(VisitDto.toDto(existingVisit),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@Operation(summary = "견학번호검색")
	@GetMapping("/centers/search")
	public ResponseEntity<List<VisitDto>> findByVisitNo(@RequestParam(name = "no") Long no) {
		List<Visit> visits = visitService.selectAllVisits();
		List<VisitDto> visitDtoList = new ArrayList<VisitDto>();

		//for문으로 list를 돌면서 선택한 번호와 일치하는 걸 찾음
		for (Visit visit : visits) {
			Long visitNo = visit.getVisitNo();
			//no가 일치하면 Dto로 변환하여 List에 추가
			if (visitNo != null && visitNo.equals(no)) { // <NullPointerException시 추가
				visitDtoList.add(VisitDto.toDto(visit));
			}
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		if (!visitDtoList.isEmpty()) {
			return new ResponseEntity<>(visitDtoList, httpHeaders, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
		}
	}
	@Operation(summary = "userno로 리스트찾기")
	@GetMapping("/visits/search/no")
	public ResponseEntity<List<VisitDto>> searchVisitsByUserNo(@RequestParam(name = "no") Long userNo) {
	    List<Visit> visits = visitService.getVisitsByUserNo(userNo); 
	    //Dto로 변환하여 리스트 초기화
	    List<VisitDto> visitDtoList = new ArrayList<VisitDto>();

	  //for문을 돌려서 Visit각각객체를 VisitDto에 삽입
	    for (Visit visit : visits) {
	        VisitDto visitDto = VisitDto.toDto(visit);
	        visitDtoList.add(visitDto);
	    }

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    if (!visitDtoList.isEmpty()) {
	        return new ResponseEntity<>(visitDtoList, httpHeaders, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
	    }
	}

	
}
