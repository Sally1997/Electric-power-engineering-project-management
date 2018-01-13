package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.domain.Authority;
import com.holyshit.utils.ConnectionManager;

public class AuthorityDaoImpl implements AuthorityDao {

	@Override
	public int selectHasPermission(String staffno, int perno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		Long res = (Long) qr.query(ConnectionManager.getConnection(), "select count(*) from asrelation where staffno=? and perno=?",new ScalarHandler(),staffno,perno);
		return Integer.parseInt(res.toString());
	
	}

	@Override
	public List<Authority> selectAllPermission() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "select * from authority",new BeanListHandler<Authority>(Authority.class));
	}

	@Override
	public List<Authority> selectPermissionById(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "select * from asrelation join authority on asrelation.perno=authority.perno where staffno=?",new BeanListHandler<Authority>(Authority.class),staffno);
	}

	@Override
	public boolean hasPermissionById(String staffno, int perno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		List<Authority> res = qr.query(ConnectionManager.getConnection(), "select * from asrelation where staffno=? and perno=?",new BeanListHandler<Authority>(Authority.class),staffno,perno);
		if(res!=null){
			return true;
		}
		return false;
		
	}

	@Override
	public int addAuthorityById(String staffno, String perno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "insert into asrelation values(null,?,?)",staffno,perno);
	}

	@Override
	public int deleteAuthorityById(String staffno, String perno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "delete from asrelation where staffno=? and perno=?",staffno,perno);
	}

	@Override
	public int[] deleteAllAuthorityById(String[] staffs) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		Object[][] para=new Object[staffs.length][1];
		for(int i=0;i<staffs.length;i++)
			para[i][0]=staffs[i];
		String sql="delete from asrelation where staffno=?";
		return qr.batch(ConnectionManager.getConnection(), sql, para);
	}
	
}
