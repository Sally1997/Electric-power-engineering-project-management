package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holyshit.Dao.AuditDao;
import com.holyshit.Dao.DocumentDao;
import com.holyshit.Dao.InformDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.StaffDao;
import com.holyshit.Dao.impl.AuditDaoImpl;
import com.holyshit.Dao.impl.DocumentDaoImpl;
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.Document;
import com.holyshit.domain.Inform;
import com.holyshit.domain.PDocAudit;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectInfo;
import com.holyshit.service.ProjectService;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.utils.StateConversion;

public class ProjectServiceImpl implements ProjectService {

	@Override
	public List<Project> findAllProjectsById(String id) {
		// TODO Auto-generated method stub
		List<Project> projects=null;
		ProjectDao pd=new ProjectDaoImpl();
		try {
			projects=pd.selectProjectsById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return projects;
	}

	@Override
	public List<Object> getNewStageNo(String pn){
		ProjectDao pjd = new ProjectDaoImpl();
		List<Object> list = new ArrayList<Object>();
		try {
			list = pjd.selectProjectStageNoByPN(pn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void NewProject(Project pro) {
		ProjectDao pd = new ProjectDaoImpl();
		try {
			pd.addProject(pro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Object> getNewProjectNo(String pn_1) {
		ProjectDao pd = new ProjectDaoImpl();
		List<Object> list = new ArrayList<Object>();
		try {
			list = pd.getMaxProNo(pn_1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String,Object> getProjectManageInfo(String staffno,int current_page,int page_size) {
		ProjectDao pd = new ProjectDaoImpl();
		Map<String,Object> pm_info = new HashMap<String,Object>();
		try {
			int count = pd.PMPageCount(staffno);
			int total_page = (int) Math.ceil(count*1.0/page_size);
			
			List<ProjectInfo> list = new ArrayList<ProjectInfo>();
			list = pd.selectProjectManageInfo(staffno,current_page,page_size);
			
			//state转换
			StateConversion sc = new StateConversion();
			sc.PStateConversion(list);
			sc.PTypeConversion(list);
			
			//封装到Map里面
			pm_info.put("current_page", current_page);
			pm_info.put("page_size", page_size);
			pm_info.put("count", count);
			pm_info.put("total_page", total_page);
			pm_info.put("pi_list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pm_info;
	}

	@Override
	public boolean ifIsEmptyProject(String pno) {
		ProjectDao pd = new ProjectDaoImpl();
		boolean iep = true;
		try {
			if(pd.selectCountStage(pno)>0){
				iep = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iep;
	}

	@Override
	public Map<String, Object> showProjectInfoByPage(String staffno, int cur,
			int pageSize) {
		// TODO Auto-generated method stub
		ProjectDao pd=new ProjectDaoImpl();
		List<Project> projects=null;
		long total=0;
		try {
			projects=pd.showPage(cur, pageSize, staffno);
			total=pd.selectWorkingProjectNumberById(staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		//将分页结果封装成hashmap
		Map<String, Object> res=new HashMap<String, Object>();
		res.put("projects", projects);
		res.put("totalNum", total);
		res.put("currentPage", cur);
		res.put("pageSize", pageSize);
		res.put("pageNum", total%pageSize==0?total/pageSize:total/pageSize+1);
		return res;
	}

	@Override
	public boolean newPeojectManage(Project pro, PSRelation psr,
			Inform info, Document doc, PDocAudit pda) {
		ConnectionManager.startTransaction();
		
		/*ProjectService ps = new ProjectServiceImpl();
		AuditService as = new AuditServiceImpl();
		InformService infoser = new InformServiceImpl();
		DocumentService ds = new DocumentServiceImpl();
		
		ps.NewProject(pro);
		as.addPdocauditInfo(pda);
		as.addProAuditInfo(paa);
		infoser.addInform(info);
		ds.addDocument(doc);*/
		ProjectDao pd = new ProjectDaoImpl();
		AuditDao ad = new AuditDaoImpl();
		InformDao id = new InformDaoImpl();
		DocumentDao dd=new DocumentDaoImpl();
		StaffDao sd = new StaffDaoImpl();
		
		boolean iff = true;
		
		try {
			//pd.addProject(pro);
			dd.insertDocument(doc);
			ad.insertpdocaudit(pda);
			//ad.insertprojaprlaudit(paa); 为了获得最新生成的理想审核编号，应该把插入立项审核信息提取出来
			id.insertInform(info);
			sd.addAStaff(psr);
			ConnectionManager.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionManager.rollback();
			iff = false;
		} finally{
			ConnectionManager.closeConnection();
		}
		return iff;
	}

	@Override
	public void changeProjectState(String pno, String state) {
		// TODO Auto-generated method stub
		ProjectDao pd = new ProjectDaoImpl();
		try {
			pd.updateProjectState(pno, state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public Project getProjectInfo(String pno) {
		ProjectDao pd = new ProjectDaoImpl();
		Project pro = null;
		try {
			pro = pd.selectProject(pno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

}
