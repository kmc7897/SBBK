package com.kmc7897.sbbk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmc7897.sbbk.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(name = "userId", defaultValue = "") String userId,
			@RequestParam(name = "userPwd", defaultValue = "") String userPwd) throws Exception {
		
		HttpSession session = (HttpSession)request.getSession(true);

		if(!userId.isEmpty() && !userPwd.isEmpty()) {
			if (loginService.Login(response, userId, userPwd)) {
				session.setAttribute("userId", userId);
				return "success";
			}
		}
		return "fail1";
	}
	
	
	@RequestMapping(value="/SignIn", method=RequestMethod.POST)
	@ResponseBody
	public String SignIn(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(name = "userId", defaultValue = "") String userId,
			@RequestParam(name = "userPwd", defaultValue = "") String userPwd) throws Exception {
		if(!userId.isEmpty() && !userPwd.isEmpty()) {
			if (loginService.SignIn(response, userId, userPwd)) {
				return "success";
			}
		}
		return "fail1";

	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userId");
		return "success";
	}
	
	
}
