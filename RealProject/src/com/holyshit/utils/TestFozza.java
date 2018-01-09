package com.holyshit.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

public class TestFozza {
	@Test
	public void forTest() throws SQLException, ParseException{
		ProjectService ps = new ProjectServiceImpl();
		ps.changeProjectStage("00002");
		
		ProjectDao pd = new ProjectDaoImpl();
		List<Object> list = pd.selectProjectStage("10001");
		
		pd.updateProjectStage("00002");
	}
	
	
}
