package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.Dao.impl.AuthorityDaoImpl;
import com.holyshit.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	@Override
	public boolean enablePublicNotice(String staffno) {
		// TODO Auto-generated method stub
		AuthorityDao ad=new AuthorityDaoImpl();
		boolean res=false;
		try {
			int hehe = ad.selectHasPermission(staffno, 1);
			if(hehe==1)
				res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
