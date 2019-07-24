package com.kmc7897.sbbk.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Members {

	@Id
	private String userId;

	@Column(nullable = false, length=200)
	private String userPwd;
	
	@CreationTimestamp
	private Date registDate;
	
	@LastModifiedDate
	private Date modifyDate;
	
	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean deleteFlag;
	
	public Members() {
		super();
	}
	
	public Members(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Members [userId=" + userId + ", userPwd=" + userPwd + ", registDate="
				+ registDate + ", modifyDate=" + modifyDate + ", deleteFlag=" + deleteFlag + "]";
	}

	
}



