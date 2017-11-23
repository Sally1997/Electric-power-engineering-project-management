package com.holyshit.domain;

import java.sql.Date;

public class Document {
	private String dno;
	private String pno;
	private String dtitle;
	private String dpath;
	private Date uploadtime;
	private int dloadtimes;
	private String ftype;
	private String dtype;
	private int fsize;
	private String uloadpno;
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
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
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
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
