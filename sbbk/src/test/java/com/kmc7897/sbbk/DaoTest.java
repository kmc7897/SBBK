package com.kmc7897.sbbk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kmc7897.sbbk.dao.History;
import com.kmc7897.sbbk.dao.HistoryRepository;
import com.kmc7897.sbbk.dao.Members;
import com.kmc7897.sbbk.dao.MembersRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DaoTest {

	@Autowired
	MembersRepository membersRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@Test
	public void DaoTest(){
	
		//회원가입 테스트
		Members members = new Members("test", "1234");
		this.membersRepository.save(members);
		
		//검색 나의히스토리 테스트
		History history1 = new History("해리포터", members.getUserId());
		this.historyRepository.save(history1);
		
		//비로그인 히스토리 테스트(실시간검색 포함)
		History history2 = new History("해리포터", "");
		this.historyRepository.save(history2);
	}
	
	
	
	
	
}
