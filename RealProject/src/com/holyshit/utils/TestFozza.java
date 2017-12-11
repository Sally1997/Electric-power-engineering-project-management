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
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.Dao.impl.DTreeDaoImpl;
import com.holyshit.domain.ProjectInfo;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestFozza {
	@Test
	public void forTest() throws SQLException{
		
		String no = "10001";
		DTreeDao dtd = new DTreeDaoImpl();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		
			//获取节点信息
			map1 = dtd.selectNodeInfo(no);
			map.put("no", map1.get("no"));
			map.put("charpname", map1.get("charpname"));
			map.put("name", map1.get("name"));
			map.put("budget", map1.get("budget"));
			
			//时间转换 sql.date转换成util.date
			
			java.sql.Date d1 = (java.sql.Date) map.get("stime");
			System.out.println(d1);
			map.put("stime", d1);
			
			//获取指标信息
			list = dtd.selectIndexInfo(no);
			
			map.put("indexinfo", list);
			
		String s = map1.toString();
		System.out.println(s);
	}
	
	
}
