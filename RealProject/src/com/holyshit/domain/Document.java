package com.holyshit.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Document {
	private String dno;
	private String pno;
	private String dtitle;
	private String dpath;
	private Timestamp uploadtime;
	private int dloadtimes;
	private String ftype;
	private String dtype;
	private int fsize;
	private String auditres;
	private String uloadpno;
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public Timestamp getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getAuditres() {
		return auditres;
	}
	public void setAuditres(String auditres) {
		this.auditres = auditres;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
	public String getDpath() {
		return dpath;
	}
	public void setDpath(String dpath) {
		this.dpath = dpath;
	}
	public int getDloadtimes() {
		return dloadtimes;
	}
	public void setDloadtimes(int dloadtimes) {
		this.dloadtimes = dloadtimes;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public int getFsize() {
		return fsize;
	}
	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	public String getUloadpno() {
		return uloadpno;
	}
	public void setUloadpno(String uloadpno) {
		this.uloadpno = uloadpno;
	}
	
}
