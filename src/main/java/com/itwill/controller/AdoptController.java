package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.AdoptDto;
import com.itwill.entity.Adopt;
import com.itwill.service.AdoptService;

@Controller
@RequestMapping("/adopt")
public class AdoptController {

	@Autowired
	private AdoptService adoptService;

	// 입양신청
	@PostMapping("/insert_action")
	public String insert_action(@RequestBody AdoptDto dto) {
		adoptService.insertAdopt(dto.toEntity(dto));
		return "redirect:my-account.html";
	}

	// 입양 리스트 조회
	@GetMapping("/adoptList")
	public String adoptList(Model model) {
		List<AdoptDto> adoptDtoList = new ArrayList<>();
		List<Adopt> adoptList = adoptService.findAdoptList();
		for (Adopt adopt : adoptList) {
			adoptDtoList.add(AdoptDto.fromEntity(adopt));
		}
		model.addAttribute("adoptDtoList", adoptDtoList);
		return "forward:my-account.html";
	}

	// 수정
	@PostMapping("/update_action")
	public String update_action(@RequestBody AdoptDto dto) throws Exception {
		Adopt adopt = adoptService.findByAdoptNo(dto.getAdoptNo());
        if (adopt != null) {
            adopt.setAdoptDate(dto.getAdoptDate());
            adopt.setAdoptStatus(dto.getAdoptStatus());
            adopt.setAdoptTime(dto.getAdoptTime());
            adoptService.updateAdopt(adopt);
        }
        return "redirect:my-account.html";
    }

		

	// 삭제
	@PostMapping("/delete_action/{adoptNo}")
	public String delete_action(@PathVariable(name = "adoptNo") Long adoptNo) throws Exception{
		 Adopt adopt = adoptService.findByAdoptNo(adoptNo);
	        if (adopt != null) {
	            adoptService.deleteAdopt(adoptNo);
	        }
	        return "redirect:my-account.html";
	}

	
	
}
