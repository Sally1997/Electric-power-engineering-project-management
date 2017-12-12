package com.holyshit.Dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Id;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.NoticeDao;
import com.holyshit.domain.Notice;
import com.holyshit.utils.ConnectionManager;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public int addNotice(String noticeno,String title, String path, String pubpno, Date time)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "INSERT INTO  notice VALUES(?,?,?,?,?)",noticeno,title,path,pubpno,new Timestamp(time.getTime()));
	}

	@Override
	public List<Notice> selectAllNoticeByPage(int cur,int pagesize) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "select * from notice order by pubtime desc limit ?,?", new BeanListHandler<Notice>(Notice.class),(cur-1)*pagesize,pagesize);
	}

	@Override
	public long totalNumNotice() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return (long) qr.query(ConnectionManager.getConnection(), "select count(*) from notice", new ScalarHandler());
	}

	@Override
	public Notice selectNoticeById(String noticeno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from notice where noticeno=?",new BeanHandler<Notice>(Notice.class),noticeno);
	}

}
