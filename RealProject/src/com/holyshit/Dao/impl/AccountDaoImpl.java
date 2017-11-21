package com.holyshit.Dao.impl;

import java.sql.SQLException;





import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.holyshit.Dao.AccountDao;
import com.holyshit.domain.Account;
import com.holyshit.utils.ConnectionManager;
/**
 * 
 * @author yuan
 *
 */
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

}
