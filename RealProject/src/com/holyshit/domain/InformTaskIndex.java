package com.holyshit.domain;

import java.sql.Timestamp;

public class InformTaskIndex {
	private String mno;
	private String busno;
	private String mtype;
	private Timestamp mdate;
	private String taskname;
	private String taskno;
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public Timestamp getMdate() {
		return mdate;
	}
	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
	
}
