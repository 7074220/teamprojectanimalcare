package com.itwill.controller;

import com.itwill.dto.MypetDto;
import com.itwill.entity.MyPet;
import com.itwill.service.MyPetService;
import com.itwill.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/userinfo")
public class MyPetController {

	@Autowired
    private  MyPetService myPetService;
	@Autowired
    private UserInfoService userInfoService;

    @GetMapping("/mypet")
    public String viewMyPet(HttpSession session, Model model) throws Exception {
        if (session.getAttribute("userNo") == null) {
            throw new Exception("로그인 하세요.");
        }
        Long userNo=(Long)session.getAttribute("userNo");

		
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  String formattedDate =
		  myPetService.findMyPetListByuserNo(userNo).get(0).getMypetBirthday().format(formatter);
		 
        List<MyPet> myPetList = myPetService.findMyPetListByuserNo(userNo); // 애왔 목록을 가져옴
        int sequentialNumber=0;
        for (int i = 0; i < myPetList.size(); i++) {
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
	 * @GetMapping("/registerMyPet") public String registerMyPet(HttpSession
	 * session, Model model) {
	 * 
	 * return "registerMyPet"; }
	 * 
	 */
  

    	@GetMapping("/registerMyPet")
        public String registerMyPet(HttpSession session,@RequestParam("mypetBirthday") Date date, Model model) {
            // Date 객체를 LocalDateTime으로 변환
            LocalDateTime localDateTime = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // 시간 부분을 자정(00:00:00)으로 설정
            localDateTime = localDateTime.withHour(0).withMinute(0).withSecond(0);
            model.addAttribute("localDateTime", localDateTime);
            // 결과를 모델에 추가 (예: "resultDateTime"라는 이름으로)
            return "my-account-mypet"; // 결과를 표시할 뷰 페이지의 이름을 반환
        }
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

