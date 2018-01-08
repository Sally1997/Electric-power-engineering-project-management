package com.holyshit.domain;

import java.sql.Timestamp;

public class InformFee {
	private String mno;
	private String busno;
	private String mtype;
	private Timestamp mdate;
	private String taskname;
	private double fee;
	private String auditadv;
	private String ofeereason;
	
	public String getAuditadv() {
		return auditadv;
	}
	public void setAuditadv(String auditadv) {
		this.auditadv = auditadv;
	}
	public String getOfeereason() {
		return ofeereason;
	}
	public void setOfeereason(String ofeereason) {
		this.ofeereason = ofeereason;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
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
	
}
