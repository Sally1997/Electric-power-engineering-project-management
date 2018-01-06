package com.holyshit.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import org.junit.Test;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.service.AuditService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class TestFozza {
	@Test
	public void forTest() throws SQLException, ParseException{
		StageTasksService sts = new StageTasksServiceImpl();
		StageTask st = sts.getStageTask("0000400002");
		System.out.println(st.getTaskname());
		
		PSPlanDao ppd = new PSPlanDaoImpl();
		PSPlan psp = ppd.selectPsPlanInfo("000040");
		System.out.println(psp.getSname());
		
		AuditService as = new AuditServiceImpl();
		Map<String,Object> map = as.getIndexAudit("0000400002");
		
		if(map.get("taskno")==null){//阶段
			System.out.println("这是阶段");
		}
		else{//任务
			System.out.println("这是rew");
		}
	}
	
	
}
