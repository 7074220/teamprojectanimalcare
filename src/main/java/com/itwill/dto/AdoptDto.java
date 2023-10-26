package com.itwill.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.entity.Adopt;
import com.itwill.entity.Pet;
import com.itwill.entity.Userinfo;
import com.itwill.service.PetService;
import com.itwill.service.UserInfoService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdoptDto {
	private Long adoptNo;
	private Integer adoptTime;
	private Date adoptDate;
	private String adoptStatus;
	private Pet pet;
	
	public static Adopt toEntity(AdoptDto dto) {
		return Adopt.builder()
				.adoptNo(dto.getAdoptNo())
				.adoptDate(dto.getAdoptDate())
				.adoptStatus(dto.getAdoptStatus())
				.adoptTime(dto.getAdoptTime())
				.pet(Pet.builder().petNo(dto.getPet().getPetNo()).build())
				.build();
	}
	

	
	
	
}
