package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.StaffDao;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
public class StaffDaoImpl implements StaffDao {

	@Override
	public Staff selectStaffById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from staff where staffno=?",new BeanHandler<Staff>(Staff.class),id);
		
	}

	@Override
	public List<Staff> selectNameNoByname(String msg) throws Exception {
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select name,staffno from staff "
				+"where name like ?",new BeanListHandler<Staff>(Staff.class),msg+"%"
				);
	}
	
	public List<StaffDuty> findAllStaffs(String pno,int CurrentPage,int PageSize) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psrelation join  staff on psrelation.staffno=staff.staffno where pno=? limit ?,?", new BeanListHandler<StaffDuty>(StaffDuty.class),pno,(CurrentPage-1)*PageSize,PageSize);
		
	}
	public int countAllStaffs(String pno) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		long count = (Long)qr.query("select count(*) from psrelation where pno=?",new ScalarHandler(),pno);
		return (int)count;
	}
    public Staff findAStaff(String staffno) throws SQLException{
    	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	return qr.query(ConnectionManager.getConnection(),"select * from staff where staffno=?",new BeanHandler<Staff>(Staff.class),staffno);
    }
	@Override
	public void delAllStaffs(String[] staffnos, String pno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[staffnos.length][];
		for (int i = 0; i < params.length; i++) {
			 params[i] = new Object[]{staffnos[i],pno};
		}
		qr.batch("delete from psrelation where staffno = ? and pno=?", params);
	}
	
	public void addAStaff(PSRelation psr) throws SQLException{
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),
				"insert into psrelation(Pno,Staffno,duty) values(?,?,?); ",
				psr.getPno(),psr.getStaffno(),psr.getDuty());
	}

	@Override
	public int selectStaffByNo(String no) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		long l =  (long) qr.query("select count(*) from psrelation "+
				"where staffno=?", new ScalarHandler(),no);
		return (int)l;
	}

	@Override
	public List<Map<String, Object>> selectStaffInProject(String pno, String userno) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT StaffNo,name,te,duty,notes FROM "+
			"(SELECT staff.staffno,NAME,te,duty FROM staff,psrelation "+
			"WHERE psrelation.pno=? AND staff.staffno=psrelation.staffno)a "+
			"LEFT JOIN staffnote ON (staffno=notedno AND noterno=?) ORDER BY staffno limit 0,10", 
			new MapListHandler(),pno,userno);
	}

	@Override
	public List<Map<String, Object>> selectStaffInCompany(String pno, String userno) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT StaffNo,name,te,duty,notes FROM "+
			"(SELECT staff.StaffNo,NAME,te,duty "+
			"FROM staff LEFT JOIN psrelation ON "+
			"psrelation.pno=? AND staff.staffno=psrelation.staffno)a "+
			"LEFT JOIN staffnote ON (staffno=notedno AND noterno=?) ORDER BY staffno limit 0,10",
			new MapListHandler(),pno,userno);
	}
	
	@Override
	public List<Map<String, Object>> selectStaffInCompany(String pno, String userno,String keyword) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT staffno,name,te,duty,notes FROM "+
			"(SELECT staff.staffno,name,te,duty "+
			"FROM staff LEFT JOIN psrelation ON "+
			"psrelation.pno=? AND staff.staffno=psrelation.StaffNo)a "+
			"LEFT JOIN staffnote ON (staffno=notedno AND noterno=?) "+
			"WHERE staffno LIKE ? OR NAME LIKE ? OR te LIKE ? "+
			"OR duty LIKE ? OR notes LIKE ? ORDER BY staffno limit 0,10",
			new MapListHandler(),pno,userno,"%"+keyword+"%","%"+keyword+"%",
			"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%");
	}

}
