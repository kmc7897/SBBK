package com.kmc7897.sbbk.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table
public class History {

	@Id
	@GeneratedValue
	private int id;
	
	private String keyword;

	private String userId;
	
	@CreationTimestamp
	private Date registDate;

	public History() {
		super();
	}
	
	public History(String keyword, String userId){
		this.keyword = keyword;
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	@Override
	public String toString() {
		return "SearchHistory [id=" + id + ", keyword=" + keyword + ", userId=" + userId + ", registDate=" + registDate
				+ "]";
	}
	
	
	
}