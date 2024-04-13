package com.itwill.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPetListDto {

    private Long mypetNo;
    private int mypetSequence;
    private String mypetName;
    private String mypetBirthday;
    private String mypetKind;


    private String mypetLeader;

}
