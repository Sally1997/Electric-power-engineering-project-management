package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.AccountDao;
import com.holyshit.Dao.StaffDao;
import com.holyshit.Dao.impl.AccountDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.Account;
import com.holyshit.domain.Staff;
import com.holyshit.service.AccountService;
import com.holyshit.utils.ConnectionManager;

public class AccountServiceImpl implements AccountService {
<<<<<<< HEAD
	//Account±í²Ù×÷½Ó¿Ú
	private AccountDao ad=new AccountDaoImpl();
	//Staff±í²Ù×÷½Ó¿Ú
	private StaffDao sd=new StaffDaoImpl();
	@Override
	public boolean login(Account account) {
		// TODO Auto-generated method stub
		Account res=null;
		try {
			//¿ªÆôÒ»¸öÊÂÎñ£¬µÇÂ½Ê±ÉèÖÃ×îºóµÇÂ½Ê±¼ä
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
=======
	//Accountï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ó¿ï¿½
	private AccountDao ad=new AccountDaoImpl();
	//Staffï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ó¿ï¿½
	private StaffDao sd=new StaffDaoImpl();
	@Override
	public boolean login(Account account) {
		// TODO Auto-generated method stub
		Account res=null;
		try {
			//ï¿½ï¿½ï¿½ï¿½Ò»ï¿½ï¿½ï¿½ï¿½ï¿½ñ£¬µï¿½Â½Ê±ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Â½Ê±ï¿½ï¿½
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
	public Staff getUserById(String id) {
		// TODO Auto-generated method stub
		Staff staff=null;
		try {
			staff = sd.selectStaffById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return staff;
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
	}

}
