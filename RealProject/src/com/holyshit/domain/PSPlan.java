package com.holyshit.domain;

import java.sql.Date;

//electric power engineering project management 

import java.sql.Date;

public class PSPlan {
	//stageno  charpno   pno  sname   stime etime sstate budget
	private String stageno;
	private String charpno;
	private String pno;
	private String sname;
	private Date stime;
	private Date etime;
	private String sstate;
	private String budget;
	
	public String toString(){
		return "stageno="+stageno+",charpno="+charpno+",pno="+pno+",sname="+sname
				+ ",stime="+stime+",etime="+etime+",sstate="+sstate+",budget="+budget;
	}
	
	public String getStageno() {
		return stageno;
	}
	public void setStageno(String stageno) {
		this.stageno = stageno;
	}
	public String getCharpno() {
		return charpno;
	}
	public void setCharpno(String charpno) {
		this.charpno = charpno;
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
	public String getSstate() {
		return sstate;
	}
	public void setSstate(String sstate) {
		this.sstate = sstate;
	}


	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	
}
