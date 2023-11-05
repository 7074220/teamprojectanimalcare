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

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/userinfo")
public class MyPetController {

    private final MyPetService myPetService;
    private final UserInfoService userInfoService;

    @GetMapping("/mypet")
    public String viewMyPet(HttpSession session, Model model) throws Exception {
        if (session.getAttribute("userNo") == null) {
            throw new Exception("로그인 하세요.");
        }
        Long userNo=(Long)session.getAttribute("userNo");

        List<MyPet> myPetList = myPetService.findMyPetListByuserNo(userNo);
        model.addAttribute("myPetList",myPetList);
        return "my-account-pet";
    }


    @PostMapping("/myPet/{mypetNo}")
    public String updateMyPet(@PathVariable(value = "mypetNo") Long myPetNo, @RequestBody MypetDto mypetDto, HttpSession session) {

        Long userNo=(Long)session.getAttribute("userNo");
        //MyPet updatePet = MyP

        return "redirect:/userinfo/mypet";
    }
}
