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

public class TestFozza {
	@Test
	public void forTest() throws SQLException, ParseException{
		String mno = "3";
		AuditDao ad = new AuditDaoImpl();
		AutoNumber an = new AutoNumber();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = ad.selectProAuditInfo(mno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(map);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.sql.Date sd1 = (java.sql.Date) map.get("stime");
		String s1 = sdf.format(sd1);
		map.put("stime", s1);
		
		java.sql.Date sd2 = (java.sql.Date) map.get("etime");
		String s2 = sdf.format(sd2);
		map.put("etime", s2);
		
		if(map.get("ptype").equals("0")){
			map.put("ptype", "设计类");
		}
		else{
			map.put("ptype", "工程类");
		}
		
		//立项相关审核意见
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			list = ad.selectProAuditAdvInfo(mno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).get("auditstate").equals("0")){
				list.get(i).put("auditstate","否");
				list.get(i).put("ifpassed", "否");
				list.get(i).put("audittime", "null");
			}
			else if(list.get(i).get("auditstate").equals("1")){
				list.get(i).put("auditstate","是");
				list.get(i).put("ifpassed", "是");
				
				//时间戳转字符串
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Timestamp ts = (Timestamp) list.get(i).get("audittime");
				String at = sdf1.format(ts);
				list.get(i).put("audittime", at);
			}
			else{
				list.get(i).put("auditstate","是");
				list.get(i).put("ifpassed", "否");
				
				//时间戳转字符串
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Timestamp ts = (Timestamp) list.get(i).get("audittime");
				String at = sdf1.format(ts);
				list.get(i).put("audittime", at);
			}
		}
		
		map.put("list", list);
		
		String str = JSONObject.fromObject(map).toString();
		str = an.transToLowerObject(str).toString();
		System.out.println(str);
	}
	
	
}
