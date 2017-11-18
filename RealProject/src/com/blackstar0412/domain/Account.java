package com.blackstar0412.domain;

import java.sql.Date;

public class Account {
	private String staffno;
	private String password;
	private Date lltime;
	public String getStaffno() {
		return staffno;
	}
	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLltime() {
		return lltime;
	}
	public void setLltime(Date lltime) {
		this.lltime = lltime;
	}
	
}
