package com.holyshit.domain;

public class TaskIndexs {
	private String indexno;
	private String taskno;
	private String indexinfo;
	private String attachpath;
	private String indexstate;
	private String achreq;
	
	
	
	public String getIndexno() {
		return indexno;
	}



	public void setIndexno(String indexno) {
		this.indexno = indexno;
	}



	public String getTaskno() {
		return taskno;
	}



	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}



	public String getIndexinfo() {
		return indexinfo;
	}



	public void setIndexinfo(String indexinfo) {
		this.indexinfo = indexinfo;
	}



	public String getAttachpath() {
		return attachpath;
	}



	public void setAttachpath(String attachpath) {
		this.attachpath = attachpath;
	}



	public String getIndexstate() {
		return indexstate;
	}



	public void setIndexstate(String indexstate) {
		this.indexstate = indexstate;
	}



	public String getAchreq() {
		return achreq;
	}



	public void setAchreq(String achreq) {
		this.achreq = achreq;
	}



	public String toString() {
		return "taskindexs [indexno=" + indexno + ", taskno=" + taskno + ", indexinfo=" + indexinfo
				+ ", attachpath=" + attachpath + "]";
	}
}
