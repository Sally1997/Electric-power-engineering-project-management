package com.holyshit.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.Dao.StaffDao;
import com.holyshit.Dao.impl.DTreeDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.ProjectInfo;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestFozza {
	@Test
	public void forTest() throws SQLException{
		StaffService ss = new StaffServiceImpl();
		List<Map<String, Object>> list = ss.showStaffInProject("10001","201526010001");
		
		String str = JSONArray.fromObject(list).toString();
		System.out.println(str);
	}
	
	
}
