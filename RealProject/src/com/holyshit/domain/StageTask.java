package com.holyshit.domain;

import java.util.Date;

public class StageTask {
	private String taskno;
	private String taskname;
	private Date stime;
	private Date etime;
	private String pubno;
	private String charpno;
	private String ptaskno;
	private int tstate;
	private String budget;
	private String taskcontent;
	public String toString() {
		return "StageTask [taskno=" + taskno + ", taskname=" + taskname + ", stime=" + stime
				+ ", etime=" + etime + ", pubno=" + pubno +", charpno=" + charpno
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
	public String getPtaskno() {
		return ptaskno;
	}
	public void setPtaskno(String ptaskno) {
		this.ptaskno = ptaskno;
	}
	public int getTstate() {
		return tstate;
	}
	public void setTstate(int tstate) {
		this.tstate = tstate;
	}
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getTaskcontent() {
		return taskcontent;
	}

	public void setTaskcontent(String taskcontent) {
		this.taskcontent = taskcontent;
	}
	
}
