package com.holyshit.domain;

public class ProjectInfo {
	private String Pno;
	private String PName;
	private String Name;
	private String Duty;
	private String PType;
	private String pState;
	
	public String getPno() {
		return Pno;
	}
	public void setPno(String pno) {
		Pno = pno;
	}


	public String getPName() {
		return PName;
	}


	public void setPName(String pName) {
		PName = pName;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getDuty() {
		return Duty;
	}


	public void setDuty(String duty) {
		Duty = duty;
	}


	public String getPType() {
		return PType;
	}


	public void setPType(String pType) {
		PType = pType;
	}


	public String getpState() {
		return pState;
	}


	public void setpState(String pState) {
		this.pState = pState;
	}


	public String toString() {
		return "Project[Pno="+Pno+", PName="+PName+", Name="+Name+", Duty="+Duty+
				", PType="+PType+", pState="+pState+"]";
	}
}
