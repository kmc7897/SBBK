package com.kmc7897.sbbk.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmc7897.sbbk.dao.History;
import com.kmc7897.sbbk.dao.HistoryRepository;

@Service
public class HistoryService {

	@Autowired
	HistoryRepository historyRepository;

	@Transactional
	public List<Object[]> getHistory() {
		return historyRepository.getHistory();
	}
	
	@Transactional
	public List<Object[]> getMyHistory(String userId) {
		return historyRepository.getMyHistory(userId);
	}
	
	@Transactional
	public boolean saveHistory(String keyword, String userId) {
		History history = null;
		history	= new History(keyword, userId);
		historyRepository.save(history);
		return true;
	}
	
}