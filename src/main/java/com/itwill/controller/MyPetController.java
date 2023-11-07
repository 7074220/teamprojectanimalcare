package com.itwill.controller;

import com.itwill.dto.MypetDto;
import com.itwill.entity.MyPet;
import com.itwill.service.MyPetService;
import com.itwill.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/userinfo")
public class MyPetController {

	
    private final MyPetService myPetService;
    private final UserInfoService userInfoService;

    @GetMapping("/mypet")
    public String viewMyPet(HttpSession session, Model model) throws Exception {
        if (session.getAttribute("userNo") == null) {
            throw new Exception("로그인 하세요.");
        }
        Long userNo=(Long)session.getAttribute("userNo");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = myPetService.findMyPetListByuserNo(userNo).get(0).getMypetBirthday().format(formatter);
        List<MyPet> myPetList = myPetService.findMyPetListByuserNo(userNo); // 애왔 목록을 가져옴
        int sequentialNumber=0;
        for (int i = 0; i < myPetList.size(); i++) {
            MyPet myPet = myPetList.get(i);
            long formatNo = myPet.getMypetNo();
            sequentialNumber = i + 1;// 현재 애왔의 번호를 가져옴
            // mypetNo를 사용할 수 있음, 여기에서는 i+1가 해당 애왔의 순번입니다.
        }
       MyPet myPet =  myPetService.findLeaderMyPet(userNo);
       String Name  = myPet.getMypetName();
        
        model.addAttribute("sequentialNumber", sequentialNumber);
        model.addAttribute("Name", Name);
        model.addAttribute("sequentialNumber", sequentialNumber);
        model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("myPetList",myPetList);
        
        return "my-account-mypet";
      
    }


	/*
	 * @PostMapping("/myPet/{mypetNo}") public String
	 * updateMyPet(@PathVariable(value = "mypetNo") Long myPetNo, @RequestBody
	 * MypetDto mypetDto, HttpSession session) {
	 * 
	 * Long userNo=(Long)session.getAttribute("userNo"); //MyPet updatePet = MyPet
	 * 
	 * return "redirect:/userinfo/mypet"; }
	 */
}
