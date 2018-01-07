package com.holyshit.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class FeeAudit {
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
	public void setTaskno(String taskon) {
		this.taskno = taskon;
	}
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}
	
	
}
