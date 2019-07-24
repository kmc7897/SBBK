package com.kmc7897.sbbk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoryRepository extends JpaRepository<History, String> {
	
	@Query("SELECT keyword, COUNT(*) FROM History group by keyword order by 2 desc")
	List<Object[]> getHistory();

	@Query("SELECT keyword, registDate FROM History where user_id = ?1 order by 2 desc ")
	List<Object[]> getMyHistory(String userId);
	
}
