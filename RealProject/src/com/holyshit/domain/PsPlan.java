package com.holyshit.domain;
//electric power engineering project management 

import java.util.Date;

public class PsPlan {
	private String StageNo;//阶段编号
	private String PNo;
	private String SName;
	private String PubNo;
	private String CharPNo;
	private Date STime;
	private Date ETime;
	
	public String getStageNo() {
		return StageNo;
	}

	public void setStageNo(String stageNo) {
		StageNo = stageNo;
	}

	public String getPNo() {
		return PNo;
	}

	public void setPNo(String pNo) {
		PNo = pNo;
	}

	public String getSName() {
		return SName;
	}

	public void setSName(String sName) {
		SName = sName;
	}

	public String getPubNo() {
		return PubNo;
	}

	public void setPubNo(String pubNo) {
		PubNo = pubNo;
	}

	public String getCharPNo() {
		return CharPNo;
	}

	public void setCharPNo(String charPNo) {
		CharPNo = charPNo;
	}

	public Date getSTime() {
		return STime;
	}

	public void setSTime(Date sTime) {
		STime = sTime;
	}

	public Date getETime() {
		return ETime;
	}

	public void setETime(Date eTime) {
		ETime = eTime;
	}

	public String toString() {
		return "ProjectStage [StageNo=" + StageNo + ", ProjectNo=" + PNo + ", StageName=" + SName
				+ ", PublisherNo=" + PubNo + ", ChargePerNo=" + CharPNo +", StartDate=" + STime
						+ ", EndDate=" + ETime + " ]";
	}
	
}
