package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.PlanManageService;

public class PlanManageServiceImpl implements PlanManageService {

	@Override
	public PSPlan findPsPlanInfo(String stageno) {
		// TODO Auto-generated method stub
		PSPlanDao pd=new PSPlanDaoImpl();
		try {
			return pd.selectPsPlanInfo(stageno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
