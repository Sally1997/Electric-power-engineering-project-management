package com.holyshit.service;

import java.util.Map;

import com.holyshit.domain.PDocAudit;
import com.holyshit.domain.Projaprlaudit;

public interface AuditService {
	/**
	 * 立项时发送增加审核信息
	 * @param paa
	 */
	void addProAuditInfo(Projaprlaudit paa);
	
	/**
	 * 立项时增加项目文档审核信息
	 * @param paa
	 */
	void addPdocauditInfo(PDocAudit pda);
	
	/**
	 * 得到项目审核相关信息
	 * @param mno
	 * @return
	 */
	String getProAuditInfo(String mno);
}
