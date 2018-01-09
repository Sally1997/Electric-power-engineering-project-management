package com.holyshit.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

public class TestFozza {
	@Test
	public void forTest(){
		PSPlanDao ppd = new PSPlanDaoImpl();
		ConnectionManager.startTransaction();
		try {
			ppd.updateCharP("1000a0", "201526010007");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.commit();
	}
	
	
}
