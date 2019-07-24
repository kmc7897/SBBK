package com.kmc7897.sbbk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			//Members members = getMemberObj(request, response);
			//실시간 검색어, 내검색 히
			//model.addAttribute("EnumTarget", EnumBookTarget.values());
			//model.addAttribute("EnumCategory", EnumBookCategory.values());
			return "/main";
		} catch (Exception e) {
			return "/main"; 
		}

	}

}
