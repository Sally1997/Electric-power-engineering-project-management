package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.holyshit.Dao.TaskMesgDao;
import com.holyshit.domain.Staff;
import com.holyshit.domain.TaskMesg;
import com.holyshit.utils.C3P0Util;

public class TaskMesgDaoImpl implements TaskMesgDao{

	public List<TaskMesg> findallTaskMesg(String me) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select d.pno,d.pname,d.StageNo,d.SName,e.taskno,e.TaskName,e.mdate,e.hasread,e.mtype "
				+ "from(select a.pno,a.pname,b.StageNo,b.SName from project a,psplan b where a.pno=b.PNo) d,"
				+ "(select a.taskno,a.TaskName,a.stageno,b.mdate,b.hasread,b.mtype from stagetasks a,inform b"
				+ " where a.TaskNo=b.busNo and b.dstPNo=? and b.mtype=1 and b.hasread='0') e"
				+ " where d.StageNo=e.stageno",me, new BeanListHandler<TaskMesg>(TaskMesg.class));
	}

	public List<TaskMesg> findallStageMesg(String me) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select m.pno,m.pname,m.StageNo,m.SName,n.mdate,n.hasread,n.mtype from"+
		"(select a.pno,a.pname,b.StageNo,b.SName from project a,psplan b where a.pno=b.PNo) m,"+
		"(select a.PNo,a.SName,a.StageNo,b.mdate,b.hasread,b.mtype from psplan a,inform b where a.StageNo=b.busNo and mtype=7 and b.dstPNo=? and b.hasread='0') n"+
		" where m.StageNo=n.StageNo", me,new BeanListHandler<TaskMesg>(TaskMesg.class));
	}
}
