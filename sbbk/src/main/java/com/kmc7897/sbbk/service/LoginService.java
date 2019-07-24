package com.kmc7897.sbbk.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kmc7897.sbbk.dao.Members;
import com.kmc7897.sbbk.util.PwdEncoding;

@Service
public class LoginService {

	@Autowired
	MembersService membersService;
	
	@Transactional
	public boolean Login(HttpServletResponse response, String userId, String userPwd) {
		Members members = membersService.getMember(userId);
		PasswordEncoder passwordEncoder = new PwdEncoding();
		
		if(!userId.isEmpty() && !userPwd.isEmpty()) {
			if(members != null) {
				if(passwordEncoder.matches(userPwd, members.getUserPwd())){
					return true;
				} else {
					return false;
				}
			}
		}
		return false; 
	}
	
	@Transactional
	public boolean SignIn(HttpServletResponse response, String userId, String userPwd) {
		Members members = membersService.getMember(userId);
		PasswordEncoder passwordEncoder = new PwdEncoding();
	
		if(!userId.isEmpty() && !userPwd.isEmpty()) {
			if(members == null) {
				members = new Members(userId, passwordEncoder.encode(userPwd));
				membersService.save(members);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
}
