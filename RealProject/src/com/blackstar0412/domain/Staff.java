package com.blackstar0412.domain;

import java.sql.Date;

public class Staff {
	private String staffno;
	private String name;
	private String sex;
	private Date birthday;
	private String te;
	private String email;
	private String imagelink;
	public String getStaffno() {
		return staffno;
	}
	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTe() {
		return te;
	}
	public void setTe(String te) {
		this.te = te;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImagelink() {
		return imagelink;
	}
	public void setImagelink(String imagelink) {
		this.imagelink = imagelink;
	}
	
	
}
