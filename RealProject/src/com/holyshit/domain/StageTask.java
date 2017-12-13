package com.holyshit.domain;

import java.sql.Date;

public class StageTask {
	private String taskno;
	private String taskname;
	private Date stime;
	private Date etime;
	private String ptasktype;
	private String charpno;
	private String ptaskno;
	private String tstate;
	private String budget;
	private String stageno;
	private String pno;
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String toString() {
		return "StageTask [taskno=" + taskno + ", taskname=" + taskname + ", stime=" + stime
				+ ", etime=" + etime + ", stageno=" + stageno +", charpno=" + charpno
						+ ", ptaskno=" + ptaskno + ", tstate=" + tstate +"]";
	}
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
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
	public String getPtasktype() {
		return ptasktype;
	}
	public void setPtasktype(String ptasktype) {
		this.ptasktype = ptasktype;
	}
	public String getCharpno() {
		return charpno;
	}
	public void setCharpno(String charpno) {
		this.charpno = charpno;
	}
	public String getPtaskno() {
		return ptaskno;
	}
	public void setPtaskno(String ptaskno) {
		this.ptaskno = ptaskno;
	}
	public String getTstate() {
		return tstate;
	}
	public void setTstate(String tstate) {
		this.tstate = tstate;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getStageno() {
		return stageno;
	}
	public void setStageno(String stageno) {
		this.stageno = stageno;
	}
	
	
}
