package com.holyshit.domain;

import java.sql.Date;

public class DocumentInfo {
	private String dno;
	private String dtitle;
	private Date uploadtime;
	private int dloadtimes;
	private String ftype;
	private String dtype;
	private String uloadpno;
	private String pname;
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
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
	public String getUloadpno() {
		return uloadpno;
	}
	public void setUloadpno(String uloadpno) {
		this.uloadpno = uloadpno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}
