package com.kmc7897.sbbk;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.kmc7897.sbbk.util.PwdEncoding;

public class UtilTest {
	
	@Test
	public void UtilTest() {
		
		String password1 = "12345678";
		String password2 = "12341234";
				
		PwdEncoding pwdEncoding = new PwdEncoding();
		String EncPassword1 = pwdEncoding.encode(password1);
		String EncPassword2 = pwdEncoding.encode(password2);
		
		pwdEncoding.matches(password1, EncPassword1);
		pwdEncoding.matches(password2, EncPassword1);
		
		
	}
	

}
