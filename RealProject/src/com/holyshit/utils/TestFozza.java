package com.holyshit.utils;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.holyshit.Dao.AuditDao;
import com.holyshit.Dao.impl.AuditDaoImpl;
import com.holyshit.domain.Inform;
import com.holyshit.service.InformService;
import com.holyshit.service.impl.InformServiceImpl;

public class TestFozza {
	@Test
	public void forTest() throws SQLException, ParseException{
		InformService is = new InformServiceImpl();
		Inform info = is.getInformByMno("11");
		System.out.println(info.getBusno());
		
	}
	
	
}
