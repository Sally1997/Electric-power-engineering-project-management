package com.holyshit.domain;

import java.sql.Timestamp;

public class InformStageIndex {
	private String mno;
	private String busno;
	private String mtype;
	private Timestamp mdate;
	private String sname;
	private String stageno;
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStageno() {
		return stageno;
	}
	public void setStageno(String stageno) {
		this.stageno = stageno;
	}
	
	
}
