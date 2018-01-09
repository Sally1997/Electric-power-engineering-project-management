package com.holyshit.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

public class TestFozza {
	@Test
	public void forTest() throws SQLException, ParseException{
		AutoNumber an = new AutoNumber();
		
		StaffService ss = new StaffServiceImpl();
		List list = ss.showStaffCanSetProject("151");
		System.out.println(list.toString());
	}
	
	
}
