package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.holyshit.Dao.InformDao;
import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.PSRelationDao;
import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.TaskIndexesDao;
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.Dao.impl.PSRelationDaoImpl;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.Dao.impl.TaskIndexesDaoImpl;
import com.holyshit.domain.Inform;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.utils.AutoNumber;
import com.holyshit.utils.ConnectionManager;

public class ProjectStageServiceImpl implements ProjectStageSercvice {

	@Override
	public void AddStageandTask(PSPlan pro_stage, TaskIndexs task_index) throws Exception {
		// TODO Auto-generated method stub
		PSPlanDao sd = new PSPlanDaoImpl();
//		sd.addStage(pro_stage, task_index);
	}

	@Override
	public void AddStage(PSPlan pro_stage) {
		// TODO Auto-generated method stub
		PSPlanDao sd = new PSPlanDaoImpl();
		try {
			sd.insertStage(pro_stage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public List<Object> getLatestStageNo(String pno) {
		ProjectDao pjd = new ProjectDaoImpl();
		List<Object> list = new ArrayList<Object>();
		try {
			list = pjd.selectProjectStageNoByPN(pno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addStageAndIndex(String pno,PSPlan[] parray, String[] icArray,
			String[] anArray,Inform[] iArray,PSRelation[] prArray) {
		//开启事务
		ConnectionManager.startTransaction();
		PSPlanDao ppd = new PSPlanDaoImpl();
		AutoNumber an = new AutoNumber();
		InformDao id = new InformDaoImpl();
		TaskIndexesDao tid = new TaskIndexesDaoImpl();
		PSRelationDao psr = new PSRelationDaoImpl();
		
		int len = parray.length;
		String sn = null;
		
		try {
			for(int i=0;i<len;i++){
				String cpn = parray[i].getCharpno();
				
				if(i==0){
					sn = an.PNtoSN(pno);
				}
				else{
					sn = an.SNToSN(sn);
				}
				
				parray[i].setStageno(sn);
				iArray[i].setBusno(sn);
				
				ppd.insertStage(parray[i]);
				id.insertInform(iArray[i]);
				
				//如果不在项目组里就把该人员拉进项目组里面
				if(!psr.selectIfInProject(pno, cpn)){
					psr.insertPSRelation(prArray[i]);
					
					Inform info = new Inform();
					info.setBusno(sn);
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
					ti.setTaskno(sn);
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

}
