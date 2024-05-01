package com.app.user;

import com.app.common.BaseVo;

public class UserVo extends BaseVo{

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String userId;
	private String userName;
	private String createdDate;
	private boolean isMembershipActive;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isMembershipActive() {
		return isMembershipActive;
	}
	public void setMembershipActive(boolean isMembershipActive) {
		this.isMembershipActive = isMembershipActive;
	}
}
