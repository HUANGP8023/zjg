package com.stkj.model;

import java.io.Serializable;


public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6899323134952690475L;
	
	private int userId;
	private String userName;
	private String userPass;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	
	
	
	
}
