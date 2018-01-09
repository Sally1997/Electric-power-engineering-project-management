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
	public Staff isinproject(String staffno,String pno) throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psrelation where staffno=? and pno=? and enable='1'", new BeanHandler<Staff>(Staff.class), staffno,pno);
	}
	
	public void updateemail(String staffno,String email) throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("update staff set email=? where staffno=?", email,staffno);
	}
	
	public void updatete(String staffno,String te) throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("update staff set te=? where staffno=?",te,staffno);
	}
	
	
	@Override
	public Staff selectStaffById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from staff where staffno=? and enable='1'",new BeanHandler<Staff>(Staff.class),id);
		
	}

	@Override
	public List<Staff> selectNameNoByname(String msg) throws Exception {
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select name,staffno from staff "
				+"where name like ? and enable='1'",new BeanListHandler<Staff>(Staff.class),msg+"%"
				);
	}
	
	public List<StaffDuty> findAllStaffs(String pno,int CurrentPage,int PageSize) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psrelation join  staff on psrelation.staffno=staff.staffno where pno=? and enable='1' limit ?,?", new BeanListHandler<StaffDuty>(StaffDuty.class),pno,(CurrentPage-1)*PageSize,PageSize);
		
	}
	public int countAllStaffs(String pno) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		long count = (Long)qr.query("select count(*) from psrelation where pno=? and enable='1'",new ScalarHandler(),pno);
		return (int)count;
	}
    public Staff findAStaff(String staffno) throws SQLException{
    	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	return qr.query(ConnectionManager.getConnection(),"select * from staff where staffno=? and enable='1'",new BeanHandler<Staff>(Staff.class),staffno);
    }
	@Override
	public void delAllStaffs(String[] staffnos, String pno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[staffnos.length][];
		for (int i = 0; i < params.length; i++) {
			 params[i] = new Object[]{staffnos[i],pno};
		}
		qr.batch("delete from psrelation where staffno = ? and pno=? and enable='1'", params);
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
				"where staffno=? and enable='1'", new ScalarHandler(),no);
		return (int)l;
	}

	@Override
	public List<Map<String, Object>> selectStaffInProject(String pno, String userno) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT StaffNo,name,te,duty,notes FROM "+
			"(SELECT staff.staffno,NAME,te,duty FROM staff,psrelation "+
			"WHERE psrelation.pno=? AND staff.staffno=psrelation.staffno AND ENABLE='1')a "+
			"LEFT JOIN staffnote ON (staffno=notedno AND noterno=? AND staffnote.PNo=?) ORDER BY staffno limit 0,10", 
			new MapListHandler(),pno,userno,pno);
	}

	@Override
	public List<Map<String, Object>> selectStaffInCompany(String pno, String userno) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT StaffNo,name,te,duty,notes FROM "+
			"(SELECT staff.StaffNo,NAME,te,duty "+
			"FROM staff LEFT JOIN psrelation ON "+
			"psrelation.pno=? AND staff.staffno=psrelation.staffno AND ENABLE='1')a "+
			"LEFT JOIN staffnote ON (staffno=notedno AND noterno=? AND staffnote.PNo=?) ORDER BY staffno limit 0,10",
			new MapListHandler(),pno,userno,pno);
	}
	
	@Override
	public List<Map<String, Object>> selectStaffInCompany(String pno, String userno,String keyword) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT staffno,name,te,duty,notes FROM "+
			"(SELECT staff.staffno,name,te,duty "+
			"FROM staff LEFT JOIN psrelation ON "+
			"psrelation.pno=? AND staff.staffno=psrelation.StaffNo AND ENABLE='1')a "+
			"LEFT JOIN staffnote ON (staffno=notedno AND noterno=? AND staffnote.PNo=?) "+
			"WHERE staffno LIKE ? OR NAME LIKE ? OR te LIKE ? "+
			"OR duty LIKE ? OR notes LIKE ? ORDER BY staffno limit 0,10",
			new MapListHandler(),pno,userno,pno,"%"+keyword+"%","%"+keyword+"%",
			"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%");
	}

	@Override
	public List<Staff> selectStaffByPage(int cur, int pageSize,Staff condition)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql="select * from staff where '1'='1' and enable='1'";
		if(condition.getStaffno()!=null){
			sql+=" and staffno like '%"+condition.getStaffno()+"%'";
		}
		if(condition.getName()!=null){
			sql+=" and name like '%"+condition.getName()+"%'";
		}
		if(condition.getSex()!=null){
			sql+=" and sex='"+condition.getSex()+"'";
		}
		if(condition.getBirthday()!=null){
			sql+=" and birthday='"+condition.getBirthday().toString()+"'";
		}
		if(condition.getTe()!=null){
			sql+=" and te like '%"+condition.getTe()+"%'";
		}
		if(condition.getEmail()!=null){
			sql+=" and email like '%"+condition.getEmail()+"%'";
		}
		sql+=" limit ?,?";
		return qr.query(ConnectionManager.getConnection(),sql,new BeanListHandler<Staff>(Staff.class),(cur-1)*pageSize,pageSize);
	}

	@Override
	public long selectStaffNum(Staff condition) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql="select count(*) from staff where '1'='1' and enable='1'";
		if(condition.getStaffno()!=null){
			sql+=" and staffno like '%"+condition.getStaffno()+"%'";
		}
		if(condition.getName()!=null){
			sql+=" and name like '%"+condition.getName()+"%'";
		}
		if(condition.getSex()!=null){
			sql+=" and sex='"+condition.getSex()+"'";
		}
		if(condition.getBirthday()!=null){
			sql+=" and birthday='"+condition.getBirthday().toString()+"'";
		}
		if(condition.getTe()!=null){
			sql+=" and te like '%"+condition.getTe()+"%'";
		}
		if(condition.getEmail()!=null){
			sql+=" and email like '%"+condition.getEmail()+"%'";
		}
		return (long) qr.query(ConnectionManager.getConnection(),sql,new ScalarHandler());
	}

	@Override
	public int addStaff(Staff staff) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "insert into staff values(?,?,?,?,?,?,?)",staff.getStaffno(),staff.getName(),staff.getSex(),staff.getBirthday(),staff.getTe(),staff.getEmail(),"1");
	}

	@Override
	public int editStaff(Staff staff) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "update staff set name=?,sex=?,birthday=?,te=?,email=? where staffno=? and enable='1'",staff.getName(),staff.getSex(),staff.getBirthday(),staff.getTe(),staff.getEmail(),staff.getStaffno());
	}

	@Override
	public int[] deleteStaff(String[] staffs) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		Object[][] para=new Object[staffs.length][1];
		for(int i=0;i<staffs.length;i++){
			para[i][0]=staffs[i];
		}
		return qr.batch(ConnectionManager.getConnection(), "update staff set enable='0' where staffno=?",para);
	}

	@Override
	public List<Map<String, Object>> selectStaffCanSetProject(String keyword) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT StaffNo,NAME,te FROM staff "+
			"WHERE staffno IN (SELECT staffno FROM asrelation "+
			"WHERE perno='4') AND (staffno LIKE ? OR NAME LIKE ? "+
			"OR te LIKE ?) AND staff.ENABLE='1' limit 0,10",new MapListHandler(),"%"+keyword+"%","%"+keyword+"%",
			"%"+keyword+"%");
	}
	/**
	 * 切记，这个一定不要添加enable=‘1’
	 */
	@Override
	public Staff selectStaffByIdOnRegister(String staffno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select * from staff where staffno=?";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanHandler<Staff>(Staff.class),staffno);
	}

}
