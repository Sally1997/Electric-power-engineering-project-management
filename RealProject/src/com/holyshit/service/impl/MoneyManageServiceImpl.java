package com.holyshit.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.Dao.FeeAuditDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.StaffDao;
import com.holyshit.Dao.StageTaskDao;
import com.holyshit.Dao.impl.FeeAuditDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.Dao.impl.StageTaskDaoImpl;
import com.holyshit.domain.FeeAudit;
import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStageBudget;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskInfo;
import com.holyshit.service.MoneyManageService;
import com.holyshit.utils.ConnectionManager;

public class MoneyManageServiceImpl implements MoneyManageService {

	@Override
	public Map<String, Object> showProjectMoneyPage(int cur, int pagesize,String id) {
		// TODO Auto-generated method stub
		ProjectDao pd=new ProjectDaoImpl();
		FeeAuditDao fd=new FeeAuditDaoImpl();
		long totalSize=0;
		List<Project> projects=null;
		JSONArray projectbudget=new JSONArray();
		try {
			//获取用户正在进行的项目数量 
			totalSize=pd.selectWorkingProjectNumberById(id);
			
			//获取当前页面3个项目的具体信息
			projects=pd.showPage(cur, pagesize, id);
			
			for(Project p:projects){
				//阶段已经使用  剩余预算  阶段超标
				String pname=p.getPname();
				JSONObject project=new JSONObject();
				project.put("pname", pname);
				JSONArray stages=new JSONArray();
				JSONArray hasaudit=new JSONArray();
				JSONArray surplus=new JSONArray();
				JSONArray over=new JSONArray();
				
				List<ProjectStageBudget> res=fd.selectProjectStageBudget(p.getPno());
				for(ProjectStageBudget psb:res){
					stages.add(psb.getSname());
					hasaudit.add(psb.getHasaudit());
					//报账剩余
					double tmp=0;
					if((tmp=psb.getBudget()-psb.getHasaudit())>0)
					{
						surplus.add(tmp);
						over.add(0);
					}else {
						surplus.add(0);
						over.add(-tmp);
					}
					//添加到数组
					project.put("stages", stages);
					project.put("hasaudit", hasaudit);
					project.put("surplus", surplus);
					project.put("over", over);
				}
				//添加到budget
				projectbudget.add(project);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}

		System.out.println(projectbudget.toString());
		
		//封装返回的map
		Map<String, Object> resMap=new HashMap<String, Object>();
		resMap.put("totalNum", totalSize);
		resMap.put("budgets", projectbudget.toString());
		resMap.put("currentPage", cur);
		resMap.put("pageSize", pagesize);
		resMap.put("pageNum", totalSize%pagesize==0?totalSize/pagesize:totalSize/pagesize+1);
		resMap.put("projectNum", projects.size());
		return resMap;
	}


	@Override
	public Map<String, Object> showFeeAuditInfoPage(int cur, int pagesize,
			String id) {
		// TODO Auto-generated method stub
		//dao操作对象
		ProjectDao pd=new ProjectDaoImpl();   //项目表
		FeeAuditDao fd=new FeeAuditDaoImpl();  //报账表
		StaffDao sd=new StaffDaoImpl();    //员工表
		StageTaskDao std=new StageTaskDaoImpl();   //阶段任务表
		long totalNum=0;
		List<FeeAudit> fees=null;
		JSONArray feeaudits=new JSONArray();
		try {
			//保存报账信息的详细内容json
			JSONObject fad=new JSONObject();
			fees = fd.selectAllFeeInfoPageById(cur, pagesize, id);
			totalNum=fd.selectTotalNumById(id);
			String appname = sd.selectStaffById(id).getName();
			for(FeeAudit fa:fees){
				//遍历取得任务编号相关的所有其他信息
				TaskInfo t=std.selectTaskInfoByTaskNo(fa.getTaskno());
				fad.put("pname", t.getPname());
				fad.put("sname", t.getSname());
				fad.put("taskname", t.getTaskname());
				fad.put("appname", appname);
				fad.put("stime", fa.getStime().toString());
				fad.put("fee", fa.getFee());
				fad.put("auditstate", fa.getAuditstate());
				//压入数组
				feeaudits.add(fad);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		Map<String, Object> resMap=new HashMap<String, Object>();
		resMap.put("totalNum", totalNum);  //数据库总的记录数
		resMap.put("feeaudits", feeaudits.toString());   //数据库记录的json数组
		resMap.put("currentPage", cur);     //当前页
		resMap.put("pageSize", pagesize);   //页大小
		resMap.put("pageNum", totalNum%pagesize==0?totalNum/pagesize:totalNum/pagesize+1);  //总页数
		resMap.put("feeauditNum", fees.size());   //目前获得的记录数
		return resMap;
	}


	@Override
	public String findFeeAbledTask(String id) {
		// TODO Auto-generated method stub
		StageTaskDao std=new StageTaskDaoImpl();
		JSONArray projects=new JSONArray();
		try {
			//得到任务信息
			//正在参与的所有任务
			List<TaskInfo> tasks= std.selectTaskInfoById(id);
			//将数据拆分封装成json
			Map<String, Integer> project_flag=new HashMap<String, Integer>();
			Map<String, Integer> stage_flag=new HashMap<String, Integer>();
			for(TaskInfo task:tasks){
				//project
				JSONObject project=null;
				if(project_flag.containsKey(task.getPno())){
					project=projects.getJSONObject(project_flag.get(task.getPno()));
				}else {
					project=new JSONObject();
					project.put("pname", task.getPname());
					project.put("stagelist", new JSONArray());
					project_flag.put(task.getPno(), projects.size());
					projects.add(project);
				}
				
				//stage
				JSONArray stages=project.getJSONArray("stagelist");
				JSONObject stage=null;
				if(stage_flag.containsKey(task.getStageno())){
					stage=stages.getJSONObject(stage_flag.get(task.getStageno()));
				}else {
					stage=new JSONObject();
					stage.put("sname", task.getSname());
					stage.put("tasklist", new JSONArray());
					stage_flag.put(task.getStageno(), stages.size());
					stages.add(stage);
					
				}
				//task
				JSONArray manytask=stage.getJSONArray("tasklist");
				JSONObject atask=new JSONObject();
				double used=0;
				BigDecimal hasused = std.selectFeeUsedByTaskno(task.getTaskno());
				if(hasused!=null)
					used=Double.parseDouble(hasused.toString());
				atask.put("taskname", task.getTaskname());
				atask.put("taskno", task.getTaskno());
				atask.put("budget", task.getBudget()-used);
				manytask.add(atask);
				//很坑，getJsonObject这样的函数居然返回的是一个对象副本。。。。草泥马
				//重新压入新的数据
				stage.put("tasklist", manytask);  
				stages.set(stage_flag.get(task.getStageno()), stage);
		
				project.put("stagelist", stages);
				
				projects.set(project_flag.get(task.getPno()), project);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String res=projects.toString();
		return res;
	}


	@Override
	public int handleFee(TaskInfo task, double fee,String cause,boolean over) {
		// TODO Auto-generated method stub
		//String taskno,double fee,String cause,String applicantno,String auditor,String pno
		FeeAuditDao fd=new FeeAuditDaoImpl();
		if(over){
			try {
				return fd.addFeeAuditOver(task.getTaskno(), fee, cause, task.getCharpno(), task.getPubpno(), task.getPno());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}else{
			fd=new FeeAuditDaoImpl();
			try {
				return fd.addFeeAudit(task.getTaskno(), fee, task.getCharpno(), task.getPubpno(), task.getPno());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
	}


	@Override
	public String showAuditInfoPageById(int cur, int pagesize, String id) {
		// TODO Auto-generated method stub
//		resMap.put("totalNum", totalNum);  //数据库总的记录数
//		resMap.put("feeaudits", feeaudits.toString());   //数据库记录的json数组
//		resMap.put("currentPage", cur);     //当前页
//		resMap.put("pageSize", pagesize);   //页大小
//		resMap.put("pageNum", totalNum%pagesize==0?totalNum/pagesize:totalNum/pagesize+1);  //总页数
//		resMap.put("feeauditNum", fees.size());   //目前获得的记录数
		long totalNum=0;
		FeeAuditDao fd=new FeeAuditDaoImpl();
		StageTaskDao std=new StageTaskDaoImpl();
		StaffDao sd=new StaffDaoImpl();
		List<FeeAudit> list=null;
		JSONObject res=new JSONObject();
		JSONArray audits=new JSONArray();
		try {
			totalNum=fd.selectTotalAuditById(id);
			//获取
			list=fd.selectFeeAuditInfoPageById(cur, pagesize, id);
			//循环遍历
			
			for(FeeAudit f:list){
				TaskInfo task=std.selectTaskInfoByTaskNo(f.getTaskno());
				JSONObject t=new JSONObject();
				t.put("pname", task.getPname());
				t.put("sname", task.getSname());
				t.put("taskname", task.getTaskname());
				String name = sd.selectStaffById(f.getApplicantno()).getName();
				t.put("appname", name);
				t.put("stime", f.getStime());
				t.put("fee", f.getFee());
				t.put("auditstate", f.getAuditstate());
				audits.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.put("totalNum", totalNum);
		res.put("currentPage", cur);
		res.put("pageSize", pagesize);
		res.put("pageNum", totalNum%pagesize==0?totalNum/pagesize:totalNum/pagesize+1);
		res.put("audits", audits);
		return res.toString();
	}
}
