package com.holyshit.domain;
//electric power engineering project management 

import java.util.Date;

public class ProjectStage {
	private String StageNo;//阶段编号
	private String ProjectNo;
	private String StageName;
	private String PublisherNo;
	private String ChargePerNo;
	private Date StartDate;
	private Date EndDate;
	public String getStageNo() {
		return StageNo;
	}

	public void setStageNo(String stageNo) {
		StageNo = stageNo;
	}
	public String getProjectNo() {
		return ProjectNo;
	}
	public void setProjectNo(String projectNo) {
		ProjectNo = projectNo;
	}
	public String getStageName() {
		return StageName;
	}
	public void setStageName(String stageName) {
		StageName = stageName;
	}
	public String getPublisherNo() {
		return PublisherNo;
	}
	public void setPublisherNo(String publisherNo) {
		PublisherNo = publisherNo;
	}
	public String getChargePerNo() {
		return ChargePerNo;
	}
	public void setChargePerNo(String chargePerNo) {
		ChargePerNo = chargePerNo;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public String toString() {
		return "ProjectStage [StageNo=" + StageNo + ", ProjectNo=" + ProjectNo + ", StageName=" + StageName
				+ ", PublisherNo=" + PublisherNo + ", ChargePerNo=" + ChargePerNo +", StartDate=" + StartDate
						+ ", EndDate=" + EndDate + " ]";
	}
	
}
