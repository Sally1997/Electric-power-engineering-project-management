package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.holyshit.Dao.SystemMesgDao;
import com.holyshit.domain.TaskMesg;
import com.holyshit.utils.C3P0Util;

public class SystemMesgDaoImpl implements SystemMesgDao{
	public List<TaskMesg> listSystemMesghr(String me) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select b.pno,b.pname,a.mdate,a.mtype,a.hasread from inform a,project b where a.busNo=b.pno and a.dstPNo=? and a.mtype in('S0','S1')", me, new BeanListHandler<TaskMesg>(TaskMesg.class));
	}
	
	
	public List<TaskMesg> listSystemMesgroot(String me) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select a.mdate,a.mtype,a.hasread from inform a where a.dstPNo=? and a.mtype in('S2','S3','S4')", me, new BeanListHandler<TaskMesg>(TaskMesg.class));
	}
}
