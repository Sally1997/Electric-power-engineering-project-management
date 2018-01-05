package com.holyshit.Dao.impl;

import java.sql.SQLException;









import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.holyshit.Dao.AccountDao;
import com.holyshit.domain.Account;
import com.holyshit.utils.ConnectionManager;

public class AccountDaoImpl implements AccountDao{

	@Override
	public Account selectAccountById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Account account=null;
		QueryRunner qr=new QueryRunner();
		account = qr.query(ConnectionManager.getConnection(), "select * from account where staffno=?",new BeanHandler<Account>(Account.class),id);
		return account;
	}

	@Override
	public void updateLltime(Account account) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"update account set lltime=? where staffno=?",account.getLltime(),account.getStaffno());
	}

	@Override
	public int addAccount(String staffno, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(),"insert into account values(?,?,null)",staffno,password);
	}

	@Override
	public int editAccount(String staffno, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(),"update account set password=? where staffno=?",password,staffno);
	}

	@Override
	public int[] deleteAccount(String[] staffs) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		Object[][] para=new Object[staffs.length][1];
		
		for(int i=0;i<staffs.length;i++){
			para[i][0]=staffs[i];
		}
		
		return qr.batch(ConnectionManager.getConnection(), "delete from account where staffno=?", para);
	}

}
