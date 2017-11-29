package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.AccountDao;
import com.holyshit.Dao.StaffDao;
import com.holyshit.Dao.impl.AccountDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.Account;
import com.holyshit.domain.Staff;
import com.holyshit.service.AccountService;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.utils.MD5Util;

public class AccountServiceImpl implements AccountService {
	//Account������ӿ�
	private AccountDao ad=new AccountDaoImpl();
	//Staff������ӿ�
	private StaffDao sd=new StaffDaoImpl();
	@Override
	public boolean login(Account account) {
		// TODO Auto-generated method stub
		Account res=null;
		try {
			//����һ�����񣬵�½ʱ��������½ʱ��
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
			//进行md5加密
			String s1=res.getPassword();
			if(s1==null){
				return false;
			}
			String s2=MD5Util.md5(account.getPassword());
			System.out.println("机密以后: "+s2);
			System.out.println("数据库    : "+s1);
			if(res.getPassword().equals(MD5Util.md5(account.getPassword()))){
				return true;
			}
//			if(res.getPassword().equals(account.getPassword())){
//				return true;
//			}
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
	}
	@Override
	public List<Staff> getNameNoByName(String msg) throws Exception {
		// TODO Auto-generated method stub
		return sd.selectNameNoByname(msg);
	}

}
