package com.itwill.dto;

import java.util.Date;

import com.itwill.entity.Center;
import com.itwill.entity.Userinfo;
import com.itwill.entity.Volunteer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class VolunteerDto {
	
	private Long volunteerNo;
	private Integer volunteerTime;
	private Date volunteerDate;
	private String volunteerStatus;
	
	public static Volunteer toEntity(VolunteerDto dto) {
		return Volunteer.builder()
						.volunteerNo(dto.getVolunteerNo())
				 		.volunteerTime(dto.getVolunteerTime())
				 		.volunteerDate(dto.getVolunteerDate())
				 		.volunteerStatus(dto.getVolunteerStatus())			
				 		
				 		.build();
		
		
	}
	
	
	
	
	
}
