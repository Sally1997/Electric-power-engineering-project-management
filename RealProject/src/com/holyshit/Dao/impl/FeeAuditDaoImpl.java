package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.holyshit.Dao.FeeAuditDao;
import com.holyshit.domain.ProjectStageBudget;
import com.holyshit.utils.ConnectionManager;

public class FeeAuditDaoImpl implements FeeAuditDao{

	@Override
	public List<ProjectStageBudget> selectProjectStageBudget(String id)throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from projectstagebudget where pno=?",new BeanListHandler<ProjectStageBudget>(ProjectStageBudget.class),id);
//		return null;
	}

}
