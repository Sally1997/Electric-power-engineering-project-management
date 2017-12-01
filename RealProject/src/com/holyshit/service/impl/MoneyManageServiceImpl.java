package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.Dao.FeeAuditDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.impl.FeeAuditDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStageBudget;
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
				//阶段预算   阶段已经使用    阶段超标
				String pname=p.getPname();
				JSONObject project=new JSONObject();
				project.put("pname", pname);
				
				List<ProjectStageBudget> res=fd.selectProjectStageBudget(p.getPno());
				//阶段数组
				JSONArray stages=new JSONArray();
				for(ProjectStageBudget psb:res){
					JSONObject jb=new JSONObject();
					jb.put("sname", psb.getSname());
					jb.put("hasaudit", psb.getHasaudit());
					//报账剩余
					double tmp=0;
					if((tmp=psb.getBudget()-psb.getHasaudit())>0)
					{
						jb.put("surplus", tmp);
						jb.put("over", 0);
					}else {
						jb.put("surplus", 0);
						jb.put("over", -tmp);
					}
					//添加到数组
					stages.add(jb);
					project.put("stages", stages);
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
		resMap.put("totalnum", totalSize);
		resMap.put("budgets", projectbudget.toString());
		resMap.put("currentPage", cur);
		resMap.put("pageSize", pagesize);
		resMap.put("pagenum", totalSize%pagesize==0?totalSize/pagesize:totalSize/pagesize+1);
		return resMap;
	}
	
	public static void main(String[] args) {
		MoneyManageService ms=new MoneyManageServiceImpl();
		ms.showProjectMoneyPage(1, 3, "201526010001");
	}

}
