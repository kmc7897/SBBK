package com.kmc7897.sbbk.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmc7897.sbbk.dao.History;
import com.kmc7897.sbbk.service.HistoryService;

@RestController
public class HistoryController {

	@Autowired
	HistoryService historyService;
	
	
	@RequestMapping("/saveHistory")
	public String saveHistory(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(name = "userId", defaultValue = "") String userId,
			@RequestParam(name = "keyword", defaultValue = "") String keyword){
		if(!keyword.isEmpty()) {
			historyService.saveHistory(keyword, userId);
			return "success";
		}
		return "fail";
	}
	
	
	@RequestMapping("/getHistory")
	public List<Object[]> getHistory(HttpServletRequest request, HttpServletResponse response, Model model){
		List<Object[]> result = historyService.getHistory();
			return result;
	}
	
	@RequestMapping("/getMyHistory")
	public List<Object[]> getMyHistory(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(name = "userId", defaultValue = "") String userId){
		List<Object[]> result = historyService.getMyHistory(userId);
			return result;
	}
}

