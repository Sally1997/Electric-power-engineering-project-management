package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.InformDao;
import com.holyshit.domain.Inform;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;

public class InformDaoImpl implements InformDao {

	@Override
	public List<Object> selectCurPaauditNO() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT paauditno FROM projaprlaudit ORDER BY paauditno DESC LIMIT 0,1", new ColumnListHandler());
	}

	@Override
	public void insertInform(Inform info) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"INSERT INTO inform(busno,srcpno,dstpno,mtype,hasread) "+
				"VALUES(?,?,?,?,?)",info.getBusno(),info.getSrcpno(),info.getDstpno(),info.getMtype(),
				info.getHasread());
	}

	@Override
	public Inform selectInformByMno(String mno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT * FROM inform WHERE mno=?", new BeanHandler<Inform>(Inform.class),mno);
	}

	@Override
	public void updateInformState(String mno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"UPDATE inform SET hasread='1' WHERE mno=?",mno);
	}

	@Override
	public List<Inform> selectInformByTypePage(String staffno, String[] types)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select * from inform where dstpno='"+staffno+"'";
		if(types.length>1){
			for(int i=0;i<types.length;i++){
				if(i!=0){
					if(i!=(types.length-1)){
						sql+=" or mtype='"+types[i]+"'";
					}else{
						sql+=" or mtype='"+types[i]+"')";
					}
				}else{
					sql+=" and (mtype='"+types[i]+"'";
				}
			}
		}else if(types.length==1){
			sql+=" and mtype='"+types[0]+"'";
		}
		System.out.println(sql);
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<Inform>(Inform.class));
	}

	@Override
	public long selectInformNumberBytype(String staffno, String[] types)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select count(*) from inform where dstpno='"+staffno+"'";
		if(types.length>1){
			for(int i=0;i<types.length;i++){
				if(i!=0){
					if(i!=(types.length-1)){
						sql+=" or mtype='"+types[i]+"'";
					}else{
						sql+=" or mtype='"+types[i]+"')";
					}
				}else{
					sql+=" and (mtype='"+types[i]+"'";
				}
			}
		}else if(types.length==1){
			sql+=" and mtype='"+types[0]+"'";
		}
		System.out.println(sql);
		return (long) qr.query(ConnectionManager.getConnection(), sql, new ScalarHandler());
	}

	

}
