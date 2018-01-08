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
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.ProjectStageServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class TestFozza {
	@Test
	public void forTest() throws SQLException, ParseException{
		AutoNumber an = new AutoNumber();
		
		ProjectStageSercvice pss = new ProjectStageServiceImpl();
		String pmno = pss.getPMno("100302");
		System.out.println(pmno);
		
		System.out.println(pss.getPTaskNo("1003020000"));
	}
	
	
}
