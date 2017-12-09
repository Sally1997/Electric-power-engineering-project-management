package com.holyshit.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.ConnectionManager;

public class PSPlanDaoImpl implements PSPlanDao {

	@Override
	public PSPlan selectPsPlanInfo(String stageno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from psplan where stageno=?",new BeanHandler<PSPlan>(PSPlan.class),stageno);
	}

}
