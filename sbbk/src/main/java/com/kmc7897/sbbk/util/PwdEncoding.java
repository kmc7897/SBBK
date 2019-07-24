package com.kmc7897.sbbk.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PwdEncoding implements PasswordEncoder{
	
	private PasswordEncoder pwdEncoder;
	
	public PwdEncoding(){
		this.pwdEncoder = new BCryptPasswordEncoder();
	}
	
	public PwdEncoding(PwdEncoding pwdEncoding){
		this.pwdEncoder = pwdEncoding;
	}
	
	@Override
	public String encode(CharSequence rawPwd){
		return pwdEncoder.encode(rawPwd);
	}
	
	@Override
	public boolean matches(CharSequence rawPwd, String encodedPwd){
		return pwdEncoder.matches(rawPwd, encodedPwd);
	}

}
