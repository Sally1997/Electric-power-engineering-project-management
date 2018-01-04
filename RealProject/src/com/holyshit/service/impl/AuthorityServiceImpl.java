package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.Dao.impl.AuthorityDaoImpl;
import com.holyshit.domain.Authority;
import com.holyshit.service.AuthorityService;
import com.holyshit.utils.ConnectionManager;

public class AuthorityServiceImpl implements AuthorityService {

	@Override
	public List<Authority> findAllAuthority() {
		// TODO Auto-generated method stub
		AuthorityDao ad=new AuthorityDaoImpl();
		List<Authority> list=null;
		try {
			list=ad.selectAllPermission();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Authority> findAuthorityById(String staffno) {
		// TODO Auto-generated method stub
		AuthorityDao ad=new AuthorityDaoImpl();
		List<Authority> list=null;
		try {
			list=ad.selectPermissionById(staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public boolean setAuthority(String staffno, String para) {
		// TODO Auto-generated method stub
		//对于数据进行拆封
		String[] changes = para.split(":");
		AuthorityDao ad=new AuthorityDaoImpl();
		try {
			ConnectionManager.startTransaction();
			for(int i=0;i<changes.length;i++){
				String[] hehe = changes[i].split("-");
				String perno=hehe[0];
				String operateCode=hehe[1];
				//分情况进行处理
				if(operateCode.equals("1")){
					//添加权限
					int res1 = ad.addAuthorityById(staffno, perno);
					if(res1==0){
						throw new SQLException();
					}
				}else if(operateCode.equals("0")){
					//取消权限
					int res2 = ad.deleteAuthorityById(staffno, perno);
					if(res2==0){
						throw new SQLException();
					}
				}
				
			}
			ConnectionManager.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.rollback();
			e.printStackTrace();
			return false;
		}finally{
			ConnectionManager.closeConnection();
		}
		return true;
	}

}
