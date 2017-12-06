package com.holyshit.domain;

public class TaskInfo {
	private String pname;
	private String sname;
	private String taskname;
	private String pno;
	private String stageno;
	private String taskno;
	private double budget;
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getStageno() {
		return stageno;
	}
	public void setStageno(String stageno) {
		this.stageno = stageno;
	}
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
	
}
