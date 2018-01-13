package com.holyshit.domain;

import java.sql.Date;

public class Notice {
	private String noticeno;
	private String noticetitle;
	private String filepath;
	private String pubpno;
	private Date pubtime;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNoticeno() {
		return noticeno;
	}
	public void setNoticeno(String noticeno) {
		this.noticeno = noticeno;
	}
	public String getNoticetitle() {
		return noticetitle;
	}
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getPubpno() {
		return pubpno;
	}
	public void setPubpno(String pubpno) {
		this.pubpno = pubpno;
	}
	public Date getPubtime() {
		return pubtime;
	}
	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}
	@Override
	public String toString() {
		return "Notice [noticeno=" + noticeno + ", noticetitle=" + noticetitle
				+ ", filepath=" + filepath + ", pubpno=" + pubpno
				+ ", pubtime=" + pubtime + ", name=" + name + "]";
	}
	
}
