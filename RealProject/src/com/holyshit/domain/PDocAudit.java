package com.holyshit.domain;

import java.sql.Timestamp;

public class PDocAudit {
	private String paauditno;
	private String pdocno;
	private String pno;
	private String applicantno;
	private String auditorno;
	private String auditadv;
	private String auditstate;
	private Timestamp audittime;
	public String getPaauditno() {
		return paauditno;
	}
	public void setPaauditno(String paauditno) {
		this.paauditno = paauditno;
	}
	public String getPdocno() {
		return pdocno;
	}
	public void setPdocno(String pdocno) {
		this.pdocno = pdocno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
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
	public String getAuditadv() {
		return auditadv;
	}
	public void setAuditadv(String auditadv) {
		this.auditadv = auditadv;
	}
	public String getAuditstate() {
		return auditstate;
	}
	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}
	public Timestamp getAudittime() {
		return audittime;
	}
	public void setAudittime(Timestamp audittime) {
		this.audittime = audittime;
	}
	
}
