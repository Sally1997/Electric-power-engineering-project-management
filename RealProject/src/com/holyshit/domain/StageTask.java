package com.holyshit.domain;

import java.sql.Date;

public class StageTask {
	private String taskno;
	private String taskname;
	private Date stime;
	private Date etime;
	private String pubno;
	private String charpno;
	private String ptaskno;
	private String tstate;
	private String taskcontent;
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
	public String getTstate() {
		return tstate;
	}
	public void setTstate(String tstate) {
		this.tstate = tstate;
	}
	public String getTaskcontent() {
		return taskcontent;
	}
	public void setTaskcontent(String taskcontent) {
		this.taskcontent = taskcontent;
	}
	
}
