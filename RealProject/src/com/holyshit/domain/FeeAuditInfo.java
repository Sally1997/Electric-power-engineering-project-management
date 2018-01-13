package com.holyshit.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class FeeAuditInfo {
	private String fauditno;
	private String applicantno;
	private String auditorno;
	private String pno;
	private String auditadv;
	private Date audittime;
	private String auditstate;
	private double fee;
	private String ofeereason;
	private String taskno;
	private Timestamp stime;
	private String pname;
	private String sname;
	private String taskname;
	private String name;
	public String getFauditno() {
		return fauditno;
	}
	public void setFauditno(String fauditno) {
		this.fauditno = fauditno;
	}
	public String getApplicantno() {
		return applicantno;
	}
	public void setApplicantno(String applicantno) {
		this.applicantno = applicantno;
	}
	public String getAuditorno() {
		return auditorno;
	}
	public void setAuditorno(String auditorno) {
		this.auditorno = auditorno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getAuditadv() {
		return auditadv;
	}
	public void setAuditadv(String auditadv) {
		this.auditadv = auditadv;
	}
	public Date getAudittime() {
		return audittime;
	}
	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}
	public String getAuditstate() {
		return auditstate;
	}
	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getOfeereason() {
		return ofeereason;
	}
	public void setOfeereason(String ofeereason) {
		this.ofeereason = ofeereason;
	}
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
