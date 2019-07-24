package com.kmc7897.sbbk;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kmc7897.sbbk.dao.Members;
import com.kmc7897.sbbk.service.BooksSearchAPIService;
import com.kmc7897.sbbk.service.HistoryService;
import com.kmc7897.sbbk.service.MembersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	
	@Autowired
	MembersService membersService;
	
	@Autowired
	HistoryService historyService;
	
	@Autowired
	BooksSearchAPIService booksSearchAPIService;
	
	@Test
	public void ServiceTest() throws UnsupportedEncodingException {
		
		//회원저장
		Members members = new Members("testService", "1234");
		membersService.save(members);
		
		//회원정보조회
		membersService.getMember(members.getUserId());
		
		//히스토리 저장
		historyService.saveHistory("test1", "");
		historyService.saveHistory("test2", members.getUserId());
		
		//히스토리 조회
		historyService.getHistory();
		historyService.getMyHistory(members.getUserId());
		
		//책검색 abcd가 포함된 제목이 있는 책 1페이지
		booksSearchAPIService.SearchBooks("abcd", "title", 1);
		
	}
		
	
	
}
