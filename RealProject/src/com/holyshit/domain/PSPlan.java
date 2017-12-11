package com.holyshit.domain;
//electric power engineering project management 

import java.sql.Date;

public class PSPlan {
	private String stageno;//阶段编号
	private String pno;
	private String sname;
	private String pubno;
	private String charpno;
	private Date stime;
	private Date etime;
	private String budget;
	private String sstate;

	

	public String getStageno() {
		return stageno;
	}



	public void setStageno(String stageno) {
		this.stageno = stageno;
	}



	public String getPno() {
		return pno;
	}



	public void setPno(String pno) {
		this.pno = pno;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getPubno() {
		return pubno;
	}



	public void setPubno(String pubno) {
		this.pubno = pubno;
	}



	public String getCharpno() {
		return charpno;
	}



	public void setCharpno(String charpno) {
		this.charpno = charpno;
	}



	public Date getStime() {
		return stime;
	}



	public void setStime(Date stime) {
		this.stime = stime;
	}



	public Date getEtime() {
		return etime;
	}



	public void setEtime(Date etime) {
		this.etime = etime;
	}



	public String getBudget() {
		return budget;
	}



	public void setBudget(String budget) {
		this.budget = budget;
	}



	public String getSstate() {
		return sstate;
	}



	public void setSstate(String sstate) {
		this.sstate = sstate;
	}



	public String toString() {
		return "projectstage [stageno=" + stageno + ", projectno=" + pno + ", stagename=" + sname
				+ ", publisherno=" + pubno + ", chargeperno=" + charpno +", startdate=" + stime
						+ ", enddate=" + etime + " ]";
	}
}
