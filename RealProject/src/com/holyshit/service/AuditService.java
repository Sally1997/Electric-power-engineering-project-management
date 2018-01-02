package com.holyshit.service;

import com.holyshit.domain.Projaprlaudit;

public interface AuditService {
	/**
	 * 立项时发送增加审核信息
	 * @param paa
	 */
	void addProAuditInfo(Projaprlaudit paa);
}
