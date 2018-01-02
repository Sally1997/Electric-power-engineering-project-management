package com.holyshit.domain;

import java.sql.Timestamp;

public class Projaprlaudit {
	private String paauditno;
	private String pno;
	private String applicantno;
	private String auditorno;
	private String nauditorno;
	private String auditadv;
	private String auditstate;
	private Timestamp audittime;
	public Timestamp getAudittime() {
		return audittime;
	}
	public void setAudittime(Timestamp audittime) {
		this.audittime = audittime;
	}
	public String getPaauditno() {
		return paauditno;
	}
	public void setPaauditno(String paauditno) {
		this.paauditno = paauditno;
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
	public String getNauditorno() {
		return nauditorno;
	}
	public void setNauditorno(String nauditorno) {
		this.nauditorno = nauditorno;
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
	
	
}
