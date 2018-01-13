package com.holyshit.domain;

public class ProjectInfo {
	private String pno;
	private String pname;
	private String name;
	private String duty;
	private String ptype;
	private String pstate;
	
	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	public String toString() {
		return "project[pno="+pno+", pname="+pname+", name="+name+", duty="+duty+
				", ptype="+ptype+", pstate="+pstate+"]";
	}
}
