package com.holyshit.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.Dao.AuditDao;
import com.holyshit.Dao.impl.AuditDaoImpl;
import com.holyshit.domain.PDocAudit;
import com.holyshit.domain.Projaprlaudit;
import com.holyshit.service.AuditService;
import com.holyshit.utils.AutoNumber;
import com.holyshit.utils.ConnectionManager;

public class AuditServiceImpl implements AuditService {

	@Override
	public void addProAuditInfo(Projaprlaudit paa) {
		AuditDao ad = new AuditDaoImpl();
		try {
			ad.insertprojaprlaudit(paa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public void addPdocauditInfo(PDocAudit pda) {
		// TODO Auto-generated method stub
		AuditDao ad = new AuditDaoImpl();
		try {
			ad.insertpdocaudit(pda);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public String getProAuditInfo(String mno) {
		// 我他妈又傻逼了，从数据库里读出来的是java.sql.Date赋值给了java.util.Date,转化成JSONObject时出错
		AuditDao ad = new AuditDaoImpl();
		AutoNumber an = new AutoNumber();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = ad.selectProAuditInfo(mno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		map.put("mno", mno);
		map.put("list", list);
		
		String str = JSONObject.fromObject(map).toString();
		str = an.transToLowerObject(str).toString();
		return str;
	}

	@Override
	public Projaprlaudit getPAAInfoByMno(String mno) {
		// TODO Auto-generated method stub
		AuditDao ad = new AuditDaoImpl();
		Projaprlaudit paa = new Projaprlaudit();
		try {
			paa = ad.selectPAAByMno(mno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paa;
	}

	@Override
	public void changePAAInfo(String mno, String auditstate, String auditadv,
			String NAuditorNo) {
		// TODO Auto-generated method stub
		ConnectionManager.startTransaction();
		AuditDao ad = new AuditDaoImpl();
		try {
			ad.updateProAuditInfo(mno, auditstate, auditadv, NAuditorNo);
			ConnectionManager.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionManager.rollback();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

}
