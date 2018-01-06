package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.service.PSPlanService;

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

}
