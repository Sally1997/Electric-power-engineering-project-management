package com.blackstar0412.service.impl;

import java.sql.SQLException;

import com.blackstar0412.Dao.AccountDao;
import com.blackstar0412.Dao.StaffDao;
import com.blackstar0412.Dao.impl.AccountDaoImpl;
import com.blackstar0412.Dao.impl.StaffDaoImpl;
import com.blackstar0412.domain.Account;
import com.blackstar0412.domain.Staff;
import com.blackstar0412.service.AccountService;
import com.blackstar0412.utils.ConnectionManager;

public class AccountServiceImpl implements AccountService {
	//Account表操作接口
	private AccountDao ad=new AccountDaoImpl();
	//Staff表操作接口
	private StaffDao sd=new StaffDaoImpl();
	@Override
	public boolean login(Account account) {
		// TODO Auto-generated method stub
		Account res=null;
		try {
			//开启一个事务，登陆时设置最后登陆时间
			ConnectionManager.startTransaction();
			res = ad.selectAccountById(account.getStaffno());
			ad.updateLltime(account);
			ConnectionManager.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.rollback();
			e.printStackTrace();
			return false;
		}finally{
			ConnectionManager.closeConnection();
		}
		if(res==null){
			return false;
		}else {
			if(res.getPassword().equals(account.getPassword())){
				return true;
			}
		}
		
		return false;
	}
	@Override
	public String getUserLogoLinkById(String id) {
		// TODO Auto-generated method stub
		Staff staff=null;
		try {
			staff = sd.selectStaffById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(staff==null){
			return "user_not_found";
		}
		return staff.getImagelink();
	}

}
