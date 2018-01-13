package com.holyshit.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.Dao.InformDao;
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.domain.Inform;
import com.holyshit.domain.InformDocument;
import com.holyshit.domain.InformFee;
import com.holyshit.domain.InformProject;
import com.holyshit.domain.InformStageIndex;
import com.holyshit.domain.InformTaskIndex;
import com.holyshit.service.InformService;
import com.holyshit.utils.ConnectionManager;

public class InformServiceImpl implements InformService {
	public void insertinformdocaudit(String dno,String staffno,String me,String type)
	{
		InformDao id = new InformDaoImpl();
		try {
			id.insertInformdocaudit(dno, type, staffno, me);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updatehasread(String mno){
		InformDao id = new InformDaoImpl();
		try {
			id.updatehasread(mno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String getNewPaauditNo() {
		InformDao id = new InformDaoImpl();
		String busno = new String();
		try {
			int tmp = (int) id.selectCurPaauditNO().get(0);
			 busno = Integer.toString(tmp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return busno;
	}

	@Override
	public void addInform(Inform info) {
		// TODO Auto-generated method stub
		InformDao id = new InformDaoImpl();
		try {
			id.insertInform(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public Inform getInformByMno(String mno) {
		InformDao id = new InformDaoImpl();
		Inform info = new Inform();
		try {
			info = id.selectInformByMno(mno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
		return info;
	}

	@Override
	public Map<String, Object> findInformNumber(String staffno) {
		// TODO Auto-generated method stub
		Map<String, Object> res=new HashMap<String, Object>();
		InformDao inform=new InformDaoImpl();
		try {
			ConnectionManager.startTransaction();
			
			long task_num = inform.selectInformNumberBytype(staffno, "T");
			
			long system_num = inform.selectInformNumberBytype(staffno, "S");
			long audit_num = inform.selectInformNumberBytype(staffno, "A");
			res.put("task_num", task_num);
			res.put("system_num", system_num);
			res.put("audit_num", audit_num);
			ConnectionManager.commit();
		} catch (SQLException e) {
			ConnectionManager.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
			
		}
		return res;
	}

	@Override
	public JSONArray findInformByType(String staffno, String type) {
		// TODO Auto-generated method stub
		InformDao inform=new InformDaoImpl();
		JSONArray list=new JSONArray();
		try {
			List<Object> types = inform.selectTypeById(staffno);
			//对于报账类型
			boolean flag1=false;
			for(Object o:types){
				String s=(String) o;
				if(s.equals("A0")||s.equals("A1")||s.equals("A2")){
					flag1=true;
					break;
				}
			}
			if(flag1){
				List<InformFee> res = inform.selectInformByTypeInFee(staffno);
				for(InformFee iFee:res){
					JSONObject jo=new JSONObject();
					jo.put("mno", iFee.getMno());
					jo.put("busno", iFee.getBusno());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String format = sdf.format(new Date(iFee.getMdate().getTime()));
					jo.put("mdate", format);
					jo.put("mtype",iFee.getMtype());
					jo.put("taskname", iFee.getTaskname());
					jo.put("fee", iFee.getFee());
					jo.put("auditadv", iFee.getAuditadv());
					if(iFee.getOfeereason()!=null){
						jo.put("ofeereason", iFee.getOfeereason());
					}else{
						jo.put("ofeereason", "");
					}
					
					list.add(jo);
				}
			}
			
			//对于普通文档审核
			boolean flag2=false;
			for(Object o:types){
				String s=(String) o;
				if(s.equals("A3")||s.equals("A4")){
					flag2=true;
					break;
				}
			}
			if(flag2){
				List<InformDocument> res = inform.selectInformByTypeInDocument(staffno);
				for(InformDocument iFee:res){
					JSONObject jo=new JSONObject();
					jo.put("mno", iFee.getMno());
					jo.put("busno", iFee.getBusno());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String format = sdf.format(new Date(iFee.getMdate().getTime()));
					jo.put("mdate", format);
					jo.put("mtype",iFee.getMtype());
					jo.put("dtitle", iFee.getDtitle());
					list.add(jo);
				}
			}
			
			//对于任务指标
			boolean flag3=false;
			for(Object o:types){
				String s=(String) o;
				if(s.equals("A5")||s.equals("A6")||s.equals("A7")){
					flag3=true;
					break;
				}
			}
			if(flag3){
				List<InformTaskIndex> res = inform.selectInformByTypeInTaskIndex(staffno);
				for(InformTaskIndex iFee:res){
					
					JSONObject jo=new JSONObject();
					jo.put("mno", iFee.getMno());
					jo.put("busno", iFee.getBusno());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String format = sdf.format(new Date(iFee.getMdate().getTime()));
					jo.put("mdate", format);
					jo.put("mtype",iFee.getMtype());
					jo.put("taskname", iFee.getTaskname());
					jo.put("taskno", iFee.getTaskno());
					list.add(jo);
				}
			}
			
			//对于阶段指标
			boolean flag4=false;
			for(Object o:types){
				String s=(String) o;
				if(s.equals("A8")||s.equals("A9")||s.equals("A10")){
					flag4=true;
					break;
				}
			}
			if(flag4){
				List<InformStageIndex> res = inform.selectInformByTypeInStageIndex(staffno);
				
				for(InformStageIndex iFee:res){
					JSONObject jo=new JSONObject();
					jo.put("mno", iFee.getMno());
					jo.put("busno", iFee.getBusno());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String format = sdf.format(new Date(iFee.getMdate().getTime()));
					jo.put("mdate", format);
					jo.put("mtype",iFee.getMtype());
					jo.put("sname", iFee.getSname());
					jo.put("stageno", iFee.getStageno());
					list.add(jo);
				}
			}
			
			//对于项目立项审核
			boolean flag5=false;
			for(Object o:types){
				String s=(String) o;
				if(s.equals("A11")||s.equals("A12")||s.equals("A13")){
					flag5=true;
					break;
				}
			}
			if(flag5){
				List<InformProject> res = inform.selectInformByTypeInProject(staffno);
				for(InformProject iFee:res){
					JSONObject jo=new JSONObject();
					jo.put("mno", iFee.getMno());
					jo.put("busno", iFee.getBusno());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String format = sdf.format(new Date(iFee.getMdate().getTime()));
					jo.put("mdate", format);
					jo.put("mtype",iFee.getMtype());
					jo.put("pname", iFee.getPname());
					jo.put("pno", iFee.getPno());
					list.add(jo);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean readInform(String mno) {
		// TODO Auto-generated method stub
		InformDao inform=new InformDaoImpl();
		int res=0;
		try {
			res=inform.hasRead(mno, "1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		if(res==1)
			return true;
		return false;
	}

	@Override
	public Map<String, Object> askStageIfAudited(String sno) {
		// TODO Auto-generated method stub
		InformDao id = new InformDaoImpl();
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map = id.selectStageIfAudited(sno);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			java.sql.Date sd1 = (java.sql.Date) map.get("stime");
			String s1 = sdf.format(sd1);
			map.put("stime", s1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> askTaskIfAudited(String tno) {
		// TODO Auto-generated method stub
		InformDao id = new InformDaoImpl();
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map = id.selectTaskIfAudited(tno);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			java.sql.Date sd1 = (java.sql.Date) map.get("stime");
			String s1 = sdf.format(sd1);
			map.put("stime", s1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
