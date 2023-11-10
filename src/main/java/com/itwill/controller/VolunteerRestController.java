package com.itwill.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.itwill.dto.AdoptDto;
import com.itwill.dto.VolunteerDto;
import com.itwill.dto.VolunteerTimePointDto;
import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;
import com.itwill.repository.UserinfoRepository;
import com.itwill.repository.VolunteerRepository;
import com.itwill.service.CenterService;
import com.itwill.service.UserInfoService;
import com.itwill.service.VolunteerService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/volunteer")
public class VolunteerRestController {
	
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private CenterService centerService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UserinfoRepository userinfoRepository;
	@Autowired
	private VolunteerRepository volunteerRepository;
	
	
	@Operation(summary = "봉사신청")
	@PostMapping("/create-volunteer")
	public ResponseEntity<VolunteerDto> insertVolunteer(@RequestBody VolunteerDto dto, HttpSession session) throws Exception {
        Long userNo = (Long) session.getAttribute("userNo");
        
        Integer status = 0;
        if (userNo == null) {
            // 로그인하지 않은 사용자에 대한 처리
        	status = 1;
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        dto.setUserNo(userNo);
        Volunteer volunteer = VolunteerDto.toEntity(dto);
        volunteerService.insertVolunteer(volunteer);        
        HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<VolunteerDto>(dto, httpHeaders, HttpStatus.CREATED);
    }
	
	@Operation(summary = "봉사삭제")
	@DeleteMapping("/{volunteerNo}")
	public ResponseEntity<Map> VolunteerDelete(@PathVariable(name = "volunteerNo") Long volunteerNo) throws Exception{		
		try {
			volunteerService.deleteVolunteer(volunteerNo);
			return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("volunteerNo", volunteerNo));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}		
	} // DELETE
	
	// my-account 에서 수정 
	@Operation(summary = "봉사 수정") 
	@PutMapping("/update-volunteer")
	public ResponseEntity<VolunteerDto> updateVolunteer(@RequestBody VolunteerDto dto, HttpServletRequest request, HttpSession session) throws Exception {
	    
		Long userNo =(Long)session.getAttribute("userNo");
		dto.setUserNo(userNo);
		
		Volunteer findVolunteer = volunteerService.findByVolunteerNo(dto.getVolunteerNo());
		Userinfo findUserinfo = userInfoService.findUserByNo(userNo);
		
		findVolunteer.setUserinfo(findUserinfo);
		if(findVolunteer != null) {
			if(dto.getVolunteerDate()!=null) {
				findVolunteer.setVolunteerDate(dto.getVolunteerDate());
			}
			if(dto.getVolunteerTime()!=null) {
				findVolunteer.setVolunteerTime(dto.getVolunteerTime());
			}
			
			Volunteer updateVolunteer = volunteerService.updateVolunteer(findVolunteer);
			VolunteerDto updatedVolunteerDto = VolunteerDto.toDto(updateVolunteer);
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			
			return new ResponseEntity<VolunteerDto>(updatedVolunteerDto, httpHeaders, HttpStatus.OK);
		
		} else {
			        
			return new ResponseEntity<VolunteerDto>(HttpStatus.NOT_FOUND);
		}    
	} // UPDATE
	
	@Operation(summary = "volunteerNo로 봉사신청 보기") 
	@GetMapping("/{volunteerNo}") 
	public ResponseEntity<VolunteerDto> findByVolunteerNo(@PathVariable(name = "volunteerNo") Long no,  HttpSession httpSession) throws Exception{		
		Volunteer findVolunteer = volunteerService.findByVolunteerNo(no);		
		if(findVolunteer == null) {
			throw new Exception("정보를 찾을 수 없습니다.");
		}
		VolunteerDto volunteerDto = VolunteerDto.toDto(findVolunteer);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));		
		return new ResponseEntity<VolunteerDto>(volunteerDto, httpHeaders, HttpStatus.OK);
	} // 봉사 목록 찾기

	
	@Operation(summary = "userNo로 봉사목록 조회") 
	@GetMapping("/user/{userNo}")
	public ResponseEntity<List<VolunteerDto>> findVolunteertByUserNo(@PathVariable(name = "userNo") Long userNo) {
		List<Volunteer> volunteers = volunteerService.findVolunteertByUserNo(userNo);
		List<VolunteerDto> volunteerDtoList = new ArrayList<VolunteerDto>();
		
		for (Volunteer volunteer : volunteers) {
			volunteerDtoList.add(VolunteerDto.toDto(volunteer));
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<List<VolunteerDto>>(volunteerDtoList, httpHeaders, HttpStatus.OK);
	} // userNo 로 VolunteerList 조회
	
	
	@Operation(summary = "봉사리스트") 
	@GetMapping("/volunteers")
	public ResponseEntity<List<VolunteerDto>> findAllVolunteers() {
		List<Volunteer> volunteerList = volunteerService.findAllVolunteers();
		List<VolunteerDto> volunteerDtoList = new ArrayList<VolunteerDto>();
		
		for (Volunteer volunteer : volunteerList) {
			volunteerDtoList.add(VolunteerDto.toDto(volunteer));			
		}	
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));				
		return new ResponseEntity<List<VolunteerDto>>(volunteerDtoList, httpHeaders, HttpStatus.OK);
	} // 목록 전체 조회
	
	
	
	/*
	// 봉사완료 변경, 포인트 적립
	@PostMapping("/complete-volunteer/{volunteerId}")
	public ResponseEntity<String> completeVolunteer(@PathVariable Long volunteerNo, HttpSession session) {
	    try {
	        // 세션에서 관리자 정보 가져오기
	        Userinfo adminUser = userInfoService.findUserByNo(59L);

	        // 세션에서 사용자의 포인트 정보 가져오기
	        Integer userPoint = (Integer) session.getAttribute("userPoint");

	        // 관리자 여부와 포인트 정보 확인
	        if (adminUser != null && adminUser.getUserNo().equals(59L)) {
	            // 관리자로 로그인한 경우 아래 코드 실행

	            // 봉사 정보 가져오기
	            Optional<Volunteer> volunteerOptional = volunteerRepository.findById(volunteerNo);

	            if (volunteerOptional.isPresent()) {
	                Volunteer volunteer = volunteerOptional.get();

	                // 봉사 상태를 완료로 변경
	                volunteer.setVolunteerStatus("봉사 완료");

	                // 봉사 정보 업데이트
	                volunteerRepository.save(volunteer);

	                // 봉사 완료 시 3000포인트 지급 및 누적 포인트 계산
	                Long adminUserNo = 59L;  // 관리자 사용자 번호
	                if (adminUserNo != null) {
	                    userPoint = (userPoint != null) ? userPoint + 3000 : 3000;
	                    session.setAttribute("userPoint", userPoint);
	                }

	                return ResponseEntity.ok("봉사상태 완료변경");
	            } else {
	                // 봉사 정보가 없는 경우에 대한 처리
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("봉사정보 찾을 수 없음");
	            }
	        } else {
	            // 관리자가 아닌 경우 또는 로그인하지 않은 경우에 대한 처리
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버오류 발생");
	    }
	}
	*/
	
}
