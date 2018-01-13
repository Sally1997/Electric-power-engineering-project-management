package com.holyshit.domain;

import java.sql.Date;

public class Staff {
	private String staffno;
	private String name;
	private String sex;
	private Date birthday;
	private String te;
	private String email;
	private String enable;
	
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
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
	@Override
	public String toString() {
		return "Staff [staffno=" + staffno + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", te=" + te + ", email=" + email
				+ "]";
	}

	
}
