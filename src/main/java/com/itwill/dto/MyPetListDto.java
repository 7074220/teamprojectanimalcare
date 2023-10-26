package com.itwill.dto;

import java.util.Date;

import com.itwill.entity.MyPet;
import com.itwill.entity.Userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.net.aso.b;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPetListDto {

	private Long mypetNo;
	private String mypetName;
	private Date mypetBirthday;
	private String mypetKind;
	
	public static MyPet toEntity(MyPetListDto dto) {
		MyPet myPet = MyPet.builder()
							.mypetNo(dto.getMypetNo())
							.mypetName(dto.getMypetName())
							.mypetKind(dto.getMypetKind())
							.mypetBirthday(dto.getMypetBirthday())
							.build();
		return myPet;
	}
	
	public static MyPetListDto toDto(MyPet mypet) {
		MyPetListDto myPetListDto = MyPetListDto.builder()
												.mypetNo(mypet.getMypetNo())
												.mypetName(mypet.getMypetName())
												.mypetKind(mypet.getMypetKind())
												.mypetBirthday(mypet.getMypetBirthday())
												.build();
		return myPetListDto;
	}
	
}
