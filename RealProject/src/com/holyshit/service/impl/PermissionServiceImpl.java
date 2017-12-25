package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.impl.AuthorityDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.service.PermissionService;
import com.holyshit.utils.ConnectionManager;

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

	@Override
	public boolean enableDeleteAndAddStaff(String staffno,String pno) {
		// TODO Auto-generated method stub
		boolean res=false;
		ProjectDao pd=new ProjectDaoImpl();
		String duty=null;
		try {
			duty = pd.selectDuty(staffno, pno);
			if(duty!=null&&duty.equals("项目经理"))
				res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return res;
	}

	@Override
	public boolean enableNewStage(String pno, String staffno) {
		// TODO Auto-generated method stub
		boolean res=false;
		ProjectDao pd=new ProjectDaoImpl();
		String duty=null;
		try {
			duty = pd.selectDuty(staffno, pno);
			if(duty!=null&&duty.equals("项目经理"))
				res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return res;
	}

}
