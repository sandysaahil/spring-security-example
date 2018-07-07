package com.intellizest.security.domain;

import java.util.Arrays;

public class IntelliUser {
	
	private String userName;	
	private String password;
	private String[] roles;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "IntellUser [userName=" + userName + ", password=" + password + ", roles=" + Arrays.toString(roles)
				+ "]";
	}
}
