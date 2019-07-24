package com.kmc7897.sbbk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.kmc7897.sbbk.service.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
	
	@Autowired
	LoginService loginService;

	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;
	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse respone;
	
	@Test
	public void SignInControllerTest() throws Exception{
		request = new MockHttpServletRequest();
		respone = new MockHttpServletResponse();
		
		request.setMethod("POST");
		request.setRequestURI("/SignIn");

		Object handler = handlerMapping.getHandler(request).getHandler();
		ModelAndView mav = handlerAdapter.handle(request, respone, handler);
		assertEquals(respone.getStatus(), 200);
		
	}
	
	@Test
	public void LoginControllerTest() throws Exception{
		request = new MockHttpServletRequest();
		respone = new MockHttpServletResponse();
		
		request.setMethod("POST");
		request.setRequestURI("/login");

		Object handler = handlerMapping.getHandler(request).getHandler();
		ModelAndView mav = handlerAdapter.handle(request, respone, handler);
		assertEquals(respone.getStatus(), 200);
		
	}
	
	@Test
	public void LogoutControllerTest() throws Exception{
		request = new MockHttpServletRequest();
		respone = new MockHttpServletResponse();
		
		request.setRequestURI("/logout");

		Object handler = handlerMapping.getHandler(request).getHandler();
		ModelAndView mav = handlerAdapter.handle(request, respone, handler);
		assertEquals(respone.getStatus(), 200);
		
	}
	
	@Test
	public void SearchBookControllerTest() throws Exception{
		request = new MockHttpServletRequest();
		respone = new MockHttpServletResponse();
		
		request.setRequestURI("/searchBooks");

		Object handler = handlerMapping.getHandler(request).getHandler();
		ModelAndView mav = handlerAdapter.handle(request, respone, handler);
		assertEquals(respone.getStatus(), 200);
		
	}
	
	@Test
	public void SaveHistoryControllerTest() throws Exception{
		request = new MockHttpServletRequest();
		respone = new MockHttpServletResponse();
		
		request.setRequestURI("/saveHistory");

		Object handler = handlerMapping.getHandler(request).getHandler();
		ModelAndView mav = handlerAdapter.handle(request, respone, handler);
		assertEquals(respone.getStatus(), 200);
		
	}
	
	@Test
	public void getHistoryControllerTest() throws Exception{
		request = new MockHttpServletRequest();
		respone = new MockHttpServletResponse();
		
		request.setRequestURI("/getHistory");

		Object handler = handlerMapping.getHandler(request).getHandler();
		ModelAndView mav = handlerAdapter.handle(request, respone, handler);
		assertEquals(respone.getStatus(), 200);
		
	}
	
	@Test
	public void getMyHistoryControllerTest() throws Exception{
		request = new MockHttpServletRequest();
		respone = new MockHttpServletResponse();
		
		request.setRequestURI("/getMyHistory");

		Object handler = handlerMapping.getHandler(request).getHandler();
		ModelAndView mav = handlerAdapter.handle(request, respone, handler);
		assertEquals(respone.getStatus(), 200);
		
	}
	

}
