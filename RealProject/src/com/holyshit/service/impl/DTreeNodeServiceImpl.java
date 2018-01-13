package com.holyshit.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.impl.DTreeDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.Project;
import com.holyshit.domain.StageTask;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.utils.ConnectionManager;

public class DTreeNodeServiceImpl implements DTreeNodeService {
	
	@Override
	public List<PSPlan> GetSNByPn(String pn){
		DTreeDao dtd = new DTreeDaoImpl();
		List<PSPlan> list = new ArrayList<PSPlan>();
		try {
			list = dtd.selectAllSNByPn(pn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<StageTask> GetTNByPn(String pn){
		DTreeDao dtd = new DTreeDaoImpl();
		List<StageTask> list = new ArrayList<StageTask>();
		try {
			list = dtd.selectAllTNByPn(pn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Project GetProjectInfo(String pn){
		DTreeDao dtd = new DTreeDaoImpl();
		Project p = new Project();
		try {
			p = dtd.selectProjectInfo(pn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public PSPlan GetStageInfo(String sn){
		DTreeDao dtd = new DTreeDaoImpl();
		PSPlan p = new PSPlan();
		try {
			p = dtd.selectStageInfo(sn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public StageTask GetTaskInfo(String tn){
		DTreeDao dtd = new DTreeDaoImpl();
		StageTask s = new StageTask();
		try {
			s = dtd.selectTaskInfo(tn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Map<String, Object>> GetTreeInfo(String pn) {
		DTreeDao dtd = new DTreeDaoImpl();
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		try {
			list = dtd.selectTreeAttribute(pn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String, Object> GetNodeInfo(String no) {
		DTreeDao dtd = new DTreeDaoImpl();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		List<Object> l1 = new ArrayList<Object>();
		
		try {
			//获取节点信息
			map1 = dtd.selectNodeInfo(no);
			map.put("no", map1.get("no"));
			map.put("charpname", map1.get("charpname"));
			map.put("name", map1.get("name"));
			map.put("budget", map1.get("budget"));
			map.put("staffno", map1.get("staffno"));
			
			String pno = no.substring(0,5);
			//查询项目是否完成
			ProjectDao pd = new ProjectDaoImpl();
			String pstate = (String) pd.ifProjectIsComplished(pno).get("pstate");
			map.put("pstate", pstate);
			
			//时间转换 sql.date转换成util.date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date date1 = (java.sql.Date) map1.get("stime");
			java.util.Date d1 = new java.util.Date(date1.getTime());
			String dd1 = sdf.format(d1);
			map.put("stime", dd1);
			java.sql.Date date2 = (java.sql.Date) map1.get("etime");
			java.util.Date d2 = new java.util.Date(date2.getTime());
			String dd2 = sdf.format(d2);
			map.put("etime", dd2);
			
			//获取指标信息
			list = dtd.selectIndexInfo(no);
			l1 = dtd.selectAchReq(no);
			
			map.put("indexinfo", list);
			map.put("achreq", l1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public void addIndexPath(String path,String no,String indexinfo) {
		DTreeDao dtd = new DTreeDaoImpl();
		try {
			dtd.insertIndexPath(no, indexinfo, path);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public void changeSState(String sno) {
		DTreeDao dtd = new DTreeDaoImpl();
		try {
			dtd.updateSState(sno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public void changeTState(String tno) {
		DTreeDao dtd = new DTreeDaoImpl();
		try {
			dtd.updateTState(tno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}
	
}
