package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.StageTaskDao;
import com.holyshit.Dao.impl.AuthorityDaoImpl;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.Dao.impl.StageTaskDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.service.PermissionService;
import com.holyshit.service.StageTasksService;
import com.holyshit.utils.ConnectionManager;
import com.sun.mail.iap.Response;

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

	@Override
	public boolean enableChangeCharge(String staffno, String id) {
		// TODO Auto-generated method stub
		int id_length=id.length();
		boolean res=false;
		try {
			if(id_length==5){
				
			}else if(id_length==6){
				PSPlanDao pd=new PSPlanDaoImpl();
				PSPlan psplan = pd.selectPsPlanInfo(id);
				if(staffno.equals(psplan.getCharpno())){
					return true;
				}
			}else if(id_length==10){
				StageTaskDao std=new StageTaskDaoImpl();
				String hehe = std.selectTaskCharge(id);
				if(hehe.equals(staffno)){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
