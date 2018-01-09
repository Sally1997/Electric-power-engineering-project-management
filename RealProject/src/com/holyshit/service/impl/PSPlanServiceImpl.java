package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.StageTaskDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.Dao.impl.StageTaskDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.service.PSPlanService;
import com.holyshit.utils.ConnectionManager;

public class PSPlanServiceImpl implements PSPlanService {

	@Override
	public PSPlan getPSPlan(String stageno) {
		// TODO Auto-generated method stub
		PSPlan psp = new PSPlan();
		PSPlanDao ppd = new PSPlanDaoImpl();
		try {
			psp = ppd.selectPsPlanInfo(stageno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psp;
	}

	@Override
	public List<PSPlan> findAllChangeState() {
		// TODO Auto-generated method stub
		List<PSPlan> res=null;
		PSPlanDao std=new PSPlanDaoImpl();
		try {
			res = std.selectAllMaybeChangeStage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		
		return res;
	}

	@Override
	public boolean refreshStageState(Map<String, String> para) {
		// TODO Auto-generated method stub
		PSPlanDao std=new PSPlanDaoImpl();
		boolean flag=true;
		try {
			int[] res = std.updateStageByPara(para);
			for(int i=0;i<res.length;i++)
				if(res[i]==0){
					flag=false;
					break;
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return flag;
	}

}
