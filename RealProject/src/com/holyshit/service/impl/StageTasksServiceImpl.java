package com.holyshit.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holyshit.Dao.InformDao;
import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.PSRelationDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.StaffDao;
import com.holyshit.Dao.StageTaskDao;
import com.holyshit.Dao.TaskIndexesDao;
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.Dao.impl.PSRelationDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.Dao.impl.StageTaskDaoImpl;
import com.holyshit.Dao.impl.TaskIndexesDaoImpl;
import com.holyshit.domain.Inform;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.domain.TaskInfo;
import com.holyshit.service.StageTasksService;
import com.holyshit.utils.AutoNumber;
import com.holyshit.utils.ConnectionManager;

public class StageTasksServiceImpl implements StageTasksService{

	@Override
	public Map<String, Object> findAllTasksByid(String id) {
		// TODO Auto-generated method stub
		List<StageTask> tasks=null;
		ProjectDao pd=new ProjectDaoImpl();
		String pname=null;
		StageTaskDao std=new StageTaskDaoImpl();
		List<String> projectNames=new ArrayList<String>();
		try {
			tasks=std.selectAllTasksById(id);
			for(StageTask st : tasks){
				String pno=st.getTaskno().substring(0, 5);
				pname = pd.selectProjetById(pno).getPname();
				projectNames.add(pname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		Map<String, Object> res=new HashMap<String, Object>();
		res.put("tasks", tasks);
		res.put("projectNames", projectNames);
		return res;
	}

	@Override
	public List<Object> getNewIndexNo(String tn) throws SQLException {
		StageTaskDao st = new StageTaskDaoImpl();
		return st.selectIndexNobyTN(tn);
	}

	@Override
	public void AddTaskandIndex(StageTask stage_task, TaskIndexs task_index) throws SQLException {
		StageTaskDao std = new StageTaskDaoImpl();
		std.addTask(stage_task, task_index);
	}

	@Override
	public List<Object> getNewTaskNo9(String ntn) throws SQLException {
		StageTaskDao st = new StageTaskDaoImpl();
		return st.selectTaskNoby9TN(ntn);
	}

	@Override
	public TaskInfo findTaskInfoById(String taskno) {
		// TODO Auto-generated method stub
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			return std.selectTaskInfoByTaskNo(taskno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return null;
	}

	@Override
	public double findUsedFeeByTaskno(String taskno) {
		// TODO Auto-generated method stub
		StageTaskDao std=new StageTaskDaoImpl();
		double res=0;
		try {
			BigDecimal fees = std.selectFeeUsedByTaskno(taskno);
			if(fees==null){
				return res;
			}
			String str=fees.toString();
			res=Double.parseDouble(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return res;
	}

	@Override
	public void addIndexInfo(TaskIndexs task_index) {
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			std.insertIndexInfo(task_index);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public void addTask(StageTask stage_task) {
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			std.insertTask(stage_task);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public Map<String, Object> showTaskInfoByPage(String staffno, int cur,
			int pageSize) {
		// TODO Auto-generated method stub
		StageTaskDao std=new StageTaskDaoImpl();
		List<TaskInfo> tasks=null;
		long total=0;
		try {
			tasks=std.selectTaskInfoByPage(staffno, cur, pageSize);
			total=std.selectTotalTaskById(staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		//将分页结果封装成hashmap
		Map<String, Object> res=new HashMap<String, Object>();
		res.put("tasks", tasks);
		res.put("totalNum", total);
		res.put("currentPage", cur);
		res.put("pageSize", pageSize);
		res.put("pageNum", total%pageSize==0?total/pageSize:total/pageSize+1);
		return res;
	}

	@Override
	public StageTask getStageTask(String taskno) {
		StageTask st = new StageTask();
		StageTaskDao std = new StageTaskDaoImpl();
		try {
			st = std.selectStageTasks(taskno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public void addTaskAndIndex(String ptn,String pno, StageTask[] parray,
			String[] icArray, String[] anArray, Inform[] iArray,PSRelation[] prArray) {
			//开启事务
			ConnectionManager.startTransaction();
			StageTaskDao std = new StageTaskDaoImpl();
			AutoNumber an = new AutoNumber();
			InformDao id = new InformDaoImpl();
			TaskIndexesDao tid = new TaskIndexesDaoImpl();
			PSRelationDao psr = new PSRelationDaoImpl();
			
			int len = parray.length;
			String tn = null;
			
			try {
				for(int i=0;i<len;i++){
					String cpn = parray[i].getCharpno();
					
					if(i==0){
						tn = an.TrueNewTaskNo(ptn);
					}
					else{
						tn = an.TNToTn(tn);
					}
					
					parray[i].setTaskno(tn);
					iArray[i].setBusno(tn);
					
					std.insertTask((parray[i]));
					id.insertInform(iArray[i]);
					
					boolean bibiji = true;
					for(int j=0;j<i;j++){//如果有相同的审核人
						if(cpn==parray[j].getCharpno()){
							bibiji = false;
							break;
						}
					}
					//如果不在项目组里就把该人员拉进项目组里面
					if(bibiji&&!psr.selectIfInProject(pno, cpn)){
						psr.insertPSRelation(prArray[i]);
						
						Inform info = new Inform();
						info.setBusno(pno);
						info.setSrcpno("root");
						info.setDstpno(cpn);
						info.setMtype("S0");
						//给负责人发送被拉进项目组的系统消息
						id.insertInform(info);
					}
						
					//阶段指标的插入
					String[] ia = icArray[i].split(",");
					String[] aa = anArray[i].split(",");
					int l = ia.length;
					
					//根据该阶段指标内容的数据创建对应的指标对象个数
					for(int j=0;j<l;j++){
						TaskIndexs ti = new TaskIndexs();
						
						ti.setAchreq(aa[j]);
						ti.setIndexinfo(ia[j]);
						ti.setTaskno(tn);
						//插入指标信息
						tid.insertTaskIndexes(ti);
					}
				}
				ConnectionManager.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ConnectionManager.rollback();
			} finally{
				ConnectionManager.closeConnection();
			}
	}

	@Override
	public List<StageTask> findAllChangeState() {
		// TODO Auto-generated method stub
		List<StageTask> res=null;
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			res = std.selectAllMaybeChangeTask();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		
		return res;
	}

	@Override
	public boolean refreshTaskState(Map<String, String> para) {
		// TODO Auto-generated method stub
		StageTaskDao std=new StageTaskDaoImpl();
		boolean flag=true;
		try {
			int[] res = std.updateTaskByPara(para);
			for(int i=0;i<res.length;i++)
				if(res[i]==0){
					flag=false;
					break;
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return flag;
	}

	@Override
	public void changeCharP(String pno, String no, String charpno) {
		// TODO Auto-generated method stub
		ConnectionManager.startTransaction();
		PSPlanDao ppd = new PSPlanDaoImpl();
		StageTaskDao std=new StageTaskDaoImpl();
		StaffDao sd = new StaffDaoImpl();
		PSRelationDao psrd = new PSRelationDaoImpl();
		Staff staff = new Staff();
		InformDao id = new InformDaoImpl();
		
		try {
			if(no.length()==6){
				ppd.updateCharP(no, charpno);
				
				//成为负责人消息
				Inform info = new Inform();
				info.setBusno(no);
				info.setSrcpno("root");
				info.setDstpno(charpno);
				info.setMtype("T1");
				//给负责人发送被拉进项目组的系统消息
				id.insertInform(info);
			}
			else{
				std.updateCharP(no, charpno);
				
				Inform info = new Inform();
				info.setBusno(no);
				info.setSrcpno("root");
				info.setDstpno(charpno);
				info.setMtype("T3");
				//给负责人发送被拉进项目组的系统消息
				id.insertInform(info);
			}
			
			//如果不在项目组里就把该人员拉进项目组里面,并发送消息
			if(!psrd.selectIfInProject(pno, charpno)){
				PSRelation psr = new PSRelation();
				psr.setDuty("负责人");
				psr.setPno(pno);
				psr.setStaffno(charpno);
				sd.addAStaff(psr);
				
				Inform info = new Inform();
				info.setBusno(pno);
				info.setSrcpno("root");
				info.setDstpno(charpno);
				info.setMtype("S0");
				//给负责人发送被拉进项目组的系统消息
				id.insertInform(info);
			}
			
			ConnectionManager.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionManager.rollback();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public Map<String, Object> findTaskInfoIncludeBudget(String taskno) {
		// TODO Auto-generated method stub
		StageTaskDao pd=new StageTaskDaoImpl();
		StageTask hehe=null;
		double res=0;
		try {
			BigDecimal bg = pd.selectTaskHasBudget(taskno);
			if(bg!=null){
				res=Double.parseDouble(bg.toString());
			}
			hehe = pd.selectStageTasks(taskno);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		Map<String, Object> resMap=new HashMap<String, Object>();
		resMap.put("entity", hehe);
		resMap.put("hasbudget", res);
		return resMap;
	}

}
