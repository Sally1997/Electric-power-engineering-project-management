package com.holyshit.domain;

import java.sql.Timestamp;

public class Inform {
	private String mno;
	private String busno;
	private String srcpno;
	private String dstpno;
	private String mtype;
	private String hasread;
	private Timestamp mdate;
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
	public String getSrcpno() {
		return srcpno;
	}
	public void setSrcpno(String srcpno) {
		this.srcpno = srcpno;
	}
	public String getDstpno() {
		return dstpno;
	}
	public void setDstpno(String dstpno) {
		this.dstpno = dstpno;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getHasread() {
		return hasread;
	}
	public void setHasread(String hasread) {
		this.hasread = hasread;
	}
	public Timestamp getMdate() {
		return mdate;
	}
	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}
	
}
