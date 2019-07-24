package com.kmc7897.sbbk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.kmc7897.sbbk.dao.Members;
import com.kmc7897.sbbk.dao.MembersRepository;

@Service
public class MembersService {
	
	@Autowired
	MembersRepository membersRepository;
	
	@Transactional
	public Members getMember(String userId) {
		return membersRepository.findById(userId).orElse(null);
	}

	@Transactional
	public void save(Members members) {
		membersRepository.save(members);
	}
	
}
