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
	
	private Long userNo;
	private Long volunteerNo;
	private Integer volunteerTime;
	private Date volunteerDate;
	private String volunteerStatus;
	private Long centerNo;
	
	public static Volunteer toEntity(VolunteerDto dto) {
		Volunteer volunteer = Volunteer.builder()
						.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
						.volunteerNo(dto.getVolunteerNo())
				 		.volunteerTime(dto.getVolunteerTime())
				 		.volunteerDate(dto.getVolunteerDate())
				 		.volunteerStatus(dto.getVolunteerStatus())			
				 		.center(Center.builder().centerNo(dto.getCenterNo()).build())
				 		.build();
		return volunteer;
		
	}
	
	
	
	
	
}
