package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.AuditDao;
import com.holyshit.Dao.impl.AuditDaoImpl;
import com.holyshit.domain.Projaprlaudit;
import com.holyshit.service.AuditService;
import com.holyshit.utils.ConnectionManager;

public class AuditServiceImpl implements AuditService {

	@Override
	public void addProAuditInfo(Projaprlaudit paa) {
		AuditDao ad = new AuditDaoImpl();
		try {
			ad.insertprojaprlaudit(paa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

}
