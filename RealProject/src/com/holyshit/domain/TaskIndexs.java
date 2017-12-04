package com.holyshit.domain;

public class TaskIndexs {
	private String IndexNo;
	private String TaskNo;
	private String IndexInfo;
	private String AttachPath;
	private String IndexState;
	
	public String getIndexState() {
		return IndexState;
	}
	public void setIndexState(String indexState) {
		IndexState = indexState;
	}
	public String getIndexNo() {
		return IndexNo;
	}
	public void setIndexNo(String indexNo) {
		IndexNo = indexNo;
	}
	public String getTaskNo() {
		return TaskNo;
	}
	public void setTaskNo(String taskNo) {
		TaskNo = taskNo;
	}
	public String getIndexInfo() {
		return IndexInfo;
	}
	public void setIndexInfo(String indexInfo) {
		IndexInfo = indexInfo;
	}
	public String getAttachPath() {
		return AttachPath;
	}
	public void setAttachPath(String attachPath) {
		AttachPath = attachPath;
	}
	
	public String toString() {
		return "TaskIndexs [IndexNo=" + IndexNo + ", TaskNo=" + TaskNo + ", IndexInfo=" + IndexInfo
				+ ", AttachPath=" + AttachPath + "]";
	}
}
