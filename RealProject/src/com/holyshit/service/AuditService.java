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
	
	/**
	 * 得到项目审核整个javabean类，多是编号类后台数据，和getProAuditInfo不同
	 * @param mno
	 * @return
	 */
	Projaprlaudit getPAAInfoByMno(String mno);
	
	/**
	 * 改变项目审核表信息
	 * @param mno
	 * @param auditstate
	 * @param auditadv
	 * @param NAuditorNo
	 */
	void changePAAInfo(String mno, String auditstate,String auditadv, String NAuditorNo);
}
