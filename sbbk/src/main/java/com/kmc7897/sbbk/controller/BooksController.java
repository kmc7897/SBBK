package com.kmc7897.sbbk.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmc7897.sbbk.service.BooksSearchAPIService;

@RestController
public class BooksController {

	@Autowired
	BooksSearchAPIService booksSearchAPIService;

	@RequestMapping("/searchBooks")
	@ResponseBody
	public ResponseEntity<String> searchBooks(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(name = "keyword", defaultValue = "") String keyword, @RequestParam(name = "target", defaultValue = "title") String target,
			@RequestParam(name = "page", defaultValue = "1") int page) throws UnsupportedEncodingException{

		ResponseEntity<String> result = null;
		String userId = null;
		HttpSession session = request.getSession(true);
		
		if(request.getSession() != null) {
			session = request.getSession();
			userId = (String) session.getAttribute("userId");
		}
		
		if("".equals(keyword)) {
			return null;
		} else {
			result = booksSearchAPIService.SearchBooks(keyword, target, page);
		}
		
		return result;
	}
}
	