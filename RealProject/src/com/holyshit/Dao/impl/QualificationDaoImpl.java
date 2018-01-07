
package com.holyshit.Dao.impl;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.holyshit.Dao.QualificationDao;
import com.holyshit.domain.Qualification;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;

public class QualificationDaoImpl implements QualificationDao {
	public List<Qualification> findAllQualifications(String staffno) throws SQLException{
		QueryRunner qr = new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from qualification where staffno=?", new BeanListHandler<Qualification>(Qualification.class),staffno);
		
	}
	
	public void AddAQualification(String staffno,String qua) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into qualification(staffno,qualifdesc) values(?,?)",staffno,qua);
	}
}
