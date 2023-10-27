package com.itwill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.entity.Center;
import com.itwill.service.CenterService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/center")
public class CenterRestController {

	@Autowired
	private CenterService centerService;

	public ResponseEntity<Center> getCenterByNo(@PathVariable Long CenterNo) {
		// 센터 번호에 해당하는 센터 정보 조회
		Center center = centerService.findByCenterNo(CenterNo);
		if (center != null) {
			// 센터가 존재하는 경우 OK와 함께 리턴
			return ResponseEntity.ok(center);
		} else {
			// 센터가 존재하지 않으면 Not Found 리턴
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping
	public ResponseEntity<Center> createCenter(@RequestBody Center center) {
		// 센터 생성
		Center createCenter = centerService.createCenter(center);
		return ResponseEntity.status(HttpStatus.CREATED).body(createCenter);
	}

	@PutMapping("/{centerNo}")
	public ResponseEntity<Center> updateCenter(@PathVariable Long centerNo, @RequestBody Center updatedCenter) {
		// 센터수정
		// 센터 정보 조회
		Center SearchCenter = centerService.findByCenterNo(centerNo);
		// 업데이트된 센터 정보 적용 후 저장
		SearchCenter.setCenterName(updatedCenter.getCenterName());
		SearchCenter.setCenterLocal(updatedCenter.getCenterLocal());
		SearchCenter.setCenterOpenCloseTime(updatedCenter.getCenterOpenCloseTime());
		SearchCenter.setCenterPhoneNumber(updatedCenter.getCenterPhoneNumber());

		Center saveCenter = centerService.updateCenter(SearchCenter);

		return ResponseEntity.ok(saveCenter);
	}

	@DeleteMapping("/{centerNo}")
	public ResponseEntity<Void> deleteCenter(@PathVariable Long centerNo) {
		// 센터 삭제
		centerService.deleteCenter(centerNo);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/all")
	public ResponseEntity<List<Center>> getAllCenters() {
		// 모든 센터 리스트 조회
		List<Center> centers = centerService.findAllCenters();

		return ResponseEntity.ok(centers);
	}

	@GetMapping("/name/{centerName}")
	public ResponseEntity<List<Center>> getCentersByName(@PathVariable String centerName) {
		// 센터 이름에 해당하는 센터 검색
		List<Center> center = centerService.findByName(centerName);

		return ResponseEntity.ok(center);
	}
}
