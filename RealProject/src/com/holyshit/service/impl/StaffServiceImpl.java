package com.holyshit.service.impl;
import com.holyshit.Dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holyshit.utils.ConnectionManager;
import com.holyshit.service.*;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.Dao.impl.AccountDaoImpl;
import com.holyshit.Dao.impl.AuthorityDaoImpl;
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.Dao.impl.NoteDaoImpl;
import com.holyshit.Dao.impl.PSRelationDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.Inform;
import com.holyshit.domain.Note;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.PageBean;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public class StaffServiceImpl implements StaffService{
	public void updatete(String staffno,String te){
		StaffDao staffDao = new StaffDaoImpl();
		try {
			staffDao.updatete(staffno, te);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
	}
	
	public void updateemail(String staffno,String email){
		StaffDao staffDao = new StaffDaoImpl();
		try {
			staffDao.updateemail(staffno, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
	}
	
	public int isinproject(String staffno,String pno){
		StaffDao sd = new StaffDaoImpl();
		Staff a=null;
		try {
			a = sd.isinproject(staffno, pno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==null)
		{
			return 0;
		}
		else {
			return 1;
		}
		
	}
	
	//list staffs service
	public PageBean findAllStaffs(String pno,int CurrentPage,int PageSize,String noterno){
		StaffDao StaffDao = new StaffDaoImpl();
		NoteDao NoteDao = new NoteDaoImpl();
		try {
			int count = StaffDao.countAllStaffs(pno);
			int totalPage = (int)Math.ceil(count*1.0/PageSize);
			List<StaffDuty> stafflist = StaffDao.findAllStaffs(pno,CurrentPage,PageSize);
			List<String> notelist = new ArrayList<String>();
			for(int i=0;i<stafflist.size();i++)
			{
				if(NoteDao.findNote(pno, noterno, stafflist.get(i).getStaffno())==null)
				{
				notelist.add(null);
				}else {
					notelist.add(NoteDao.findNote(pno, noterno, stafflist.get(i).getStaffno()).getNotes());
				}
			}
			PageBean pb = new PageBean();
			pb.setCount(count);
			pb.setStaffs(stafflist);
			pb.setCurrentPage(CurrentPage);
			pb.setPageSize(PageSize);
			pb.setTotalPage(totalPage);
			pb.setNotes(notelist);
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return null;
	}
	//delete staffs service
	//delete staffs service
		public void delAllStaffs(String[] staffnos,String pno,String me) {
			// TODO Auto-generated method stub
			InformDao ifd = new InformDaoImpl();
			StaffDao StaffDao = new StaffDaoImpl();
			try{

				StaffDao.delAllStaffs(staffnos, pno);
				for(int i=0;i<staffnos.length;i++)
				{
					ifd.insertInformhr(pno,"S1", staffnos[i],me);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionManager.closeConnection();
			}
		}
	@Override
	public Staff findAStaff(String staffno) {
		// TODO Auto-generated method stub
		StaffDao StaffDao = new StaffDaoImpl();
		try {
			return StaffDao.selectStaffById(staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return null;
		
	}
	
	public void addAStaff(PSRelation psr,String me){
		InformDao ifd = new InformDaoImpl();
		StaffDao StaffDao = new StaffDaoImpl();
		try {
			StaffDao.addAStaff(psr);
			ifd.insertInformhr(psr.getPno(),"S0", psr.getStaffno(),me);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}
	@Override
	public boolean ifInProject(String staffno) {
		StaffDao StaffDao = new StaffDaoImpl();
		boolean b = true;
		try {
			int x = StaffDao.selectStaffByNo(staffno);
			if(x==0){
				b = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public List<Map<String, Object>> showStaffInProject(String pno, String userno) {
		StaffDao StaffDao = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			list =  StaffDao.selectStaffInProject(pno, userno);
			
			for(Map<String, Object> map:list){
				if(map.get("duty")==null){
					map.put("duty", "-");
				}
				if(map.get("notes")==null){
					map.put("notes", "-");
				}
			}
			Map<String, Object> map1 = new HashMap<String, Object>();
			int pn = StaffDao.selectSIP(pno, userno);
			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			map1.put("pagesize", pn);
			list.add(map1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> showStaffInProject(String pno, String userno,int pagenum) {
		StaffDao StaffDao = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			list =  StaffDao.selectStaffInProject(pno, userno, pagenum);
			for(Map<String, Object> map:list){
				if(map.get("duty")==null){
					map.put("duty", "-");
				}
				if(map.get("notes")==null){
					map.put("notes", "-");
				}
			}
			Map<String, Object> map1 = new HashMap<String, Object>();
			int pn = StaffDao.selectSIP(pno, userno);
			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			map1.put("pagesize", pn);
			list.add(map1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Map<String, Object>> showStaffInCompany(String pno, String userno) {
		StaffDao StaffDao = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			list =  StaffDao.selectStaffInCompany(pno, userno);
			for(Map<String, Object> map:list){
				if(map.get("duty")==null){
					map.put("duty", "-");
				}
				if(map.get("notes")==null){
					map.put("notes", "-");
				}
			}

			Map<String, Object> map1 = new HashMap<String, Object>();
			int pn = StaffDao.selectSIC(pno, userno);
			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			map1.put("pagesize", pn);
			list.add(map1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> showStaffInCompany(String pno, String userno,int pagenum) {
		StaffDao StaffDao = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			list =  StaffDao.selectStaffInCompany(pno, userno,pagenum);
			for(Map<String, Object> map:list){
				if(map.get("duty")==null){
					map.put("duty", "-");
				}
				if(map.get("notes")==null){
					map.put("notes", "-");
				}
			}
			Map<String, Object> map1 = new HashMap<String, Object>();
			int pn = StaffDao.selectSIC(pno, userno);
			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			map1.put("pagesize", pn);
			list.add(map1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> queryStaffInCompany(String pno, String userno,String keyword) {
		StaffDao StaffDao = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			list =  StaffDao.selectStaffInCompany(pno, userno, keyword);
			for(Map<String, Object> map:list){
				if(map.get("duty")==null){
					map.put("duty", "-");
				}
				if(map.get("notes")==null){
					map.put("notes", "-");
				}
			}
			
			Map<String, Object> map1 = new HashMap<String, Object>();
			int pn = StaffDao.selectSS(pno, userno, keyword);

			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			
			map1.put("pagesize", pn);
			list.add(map1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> queryStaffInCompany(String pno, String userno,String keyword,int pagenum) {
		StaffDao StaffDao = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			list =  StaffDao.selectStaffInCompany(pno, userno, keyword,pagenum);
			for(Map<String, Object> map:list){
				if(map.get("duty")==null){
					map.put("duty", "-");
				}
				if(map.get("notes")==null){
					map.put("notes", "-");
				}
			}
			Map<String, Object> map1 = new HashMap<String, Object>();
			int pn = StaffDao.selectSS(pno, userno, keyword);

			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			
			map1.put("pagesize", pn);
			list.add(map1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Map<String, Object> findStaffByPage(int cur, int pageSize,Staff condition) {
		// TODO Auto-generated method stub
		StaffDao sd=new StaffDaoImpl();
		List<Staff> list=null;
		long totalNum=0;
		try {
			list=sd.selectStaffByPage(cur, pageSize,condition);
			totalNum=sd.selectStaffNum(condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		Map<String, Object> resMap=new HashMap<String, Object>();
		
		resMap.put("staffs", list);
		resMap.put("totalNum", totalNum);
		resMap.put("currentPage", cur);
		resMap.put("pageSize", pageSize);
		resMap.put("pageNum", totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1);
		return resMap;
	}
	@Override
	public boolean addStaffByRoot(Staff staff,String password) {
		// TODO Auto-generated method stub
		StaffDao sd=new StaffDaoImpl();
		AccountDao ad=new AccountDaoImpl();
		int res1=0,res2=0;
		try {
			//使用事务插入两张表
			ConnectionManager.startTransaction();
			res1=sd.addStaff(staff);
			res2=ad.addAccount(staff.getStaffno(),password);
			ConnectionManager.commit();
		} catch (SQLException e) {
			System.out.println("发生呢个异常");
			ConnectionManager.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		if(res1==1&&res2==1){
			return true;
		}
		return false;
	}
	@Override
	public boolean editStaffInfo(Staff staff, boolean change,String password,String changeFlag) {
		// TODO Auto-generated method stub
		StaffDao sd=new StaffDaoImpl();
		boolean flag=false;
		AccountDao ad=new AccountDaoImpl();
		InformDao inform=new InformDaoImpl();
		Inform data=new Inform();
		Inform data2=new Inform();
		data.setBusno(staff.getStaffno());
		data.setSrcpno("root");
		data.setDstpno(staff.getStaffno());
		data.setMtype("S2");
		data.setHasread("0");
		
		data2.setBusno(staff.getStaffno());
		data2.setSrcpno("root");
		data2.setDstpno(staff.getStaffno());
		data2.setMtype("S3");
		data2.setHasread("0");
		int res1=0,res2=0,res3=0,res4=0;
		if(change){
			//重置了密码
			try {
				res3=1;
				ConnectionManager.startTransaction();
				res1=sd.editStaff(staff);
				res2=ad.editAccount(staff.getStaffno(), password);
				if(changeFlag.equals("1"))
					res3=inform.insertInform(data,1);
				res4=inform.insertInform(data2, 1);
				if(!(res1==1&&res2==1&&res3==1&&res4==1)){
					throw new SQLException();
				}
				
				ConnectionManager.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				ConnectionManager.rollback();
				e.printStackTrace();
			}finally{
				ConnectionManager.closeConnection();
			}
			if(res1==1&&res2==1&&res3==1&&res4==1){
				return true;
			}
		}else{
			//未重置密码
			try {
				ConnectionManager.startTransaction();
				res1=sd.editStaff(staff);
				res3=inform.insertInform(data, 1);
				if(!(res1==1&&res3==1)){
					throw new SQLException();
				}
				
				ConnectionManager.commit();
			} catch (SQLException e) {
				ConnectionManager.rollback();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnectionManager.closeConnection();
			}
			if(res1==1&&res3==1){
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean deleteStaffInfo(String[] staffs) {
		// TODO Auto-generated method stub
		StaffDao sd=new StaffDaoImpl();
		AccountDao ad=new AccountDaoImpl();
		PSRelationDao pr=new PSRelationDaoImpl();
		boolean resFlag=true;
		try {
			ConnectionManager.startTransaction();
			int[] res1 = pr.deleteAllRelation(staffs);
			int[] res2=ad.deleteAccount(staffs);
			int[] res3=sd.deleteStaff(staffs);
			for(int i=0;i<res1.length;i++){
				if(res1[i]!=0||res2[i]==0||res3[i]==0){
					resFlag=false;
					throw new SQLException();
				}
			}
			
			ConnectionManager.commit();
		} catch (SQLException e) {
			ConnectionManager.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return resFlag;
	}

	@Override
	public boolean isExist(String staffno) {
		// TODO Auto-generated method stub
		StaffDao sd=new StaffDaoImpl();
		Staff staff=null;
		try {
			staff=sd.selectStaffByIdOnRegister(staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		if(staff!=null)
			return true;
		return false;
	}

	@Override
	public List<Map<String, Object>> showStaffCanSetProject(String keyword) {
		// TODO Auto-generated method stub
		StaffDao sd = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			int pn = sd.selectCountSCPP(keyword);
			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			map.put("pagesize", pn);
			list = sd.selectStaffCanSetProject(keyword);
			list.add(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> showStaffCanSetProject(String keyword,int pagenum) {
		// TODO Auto-generated method stub
		StaffDao sd = new StaffDaoImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			int pn = sd.selectCountSCPP(keyword);
			if(pn<10){
				pn = 1;
			}
			else{
				if(pn%10==0){
					pn /= 10;
				}
				else{
					pn /= 10;
					pn ++;
				}
			}
			map.put("pagesize", pn);
			list = sd.selectStaffCanSetProject(keyword,pagenum);
			list.add(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public void addAStaff(PSRelation psr){
		StaffDao StaffDao = new StaffDaoImpl();
		try {
			StaffDao.addAStaff(psr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}
	
	public Staff findRootInfo() {
		// TODO Auto-generated method stub
		
		StaffDao sd=new StaffDaoImpl();
		Staff selectStaffById=null;
		try {
			selectStaffById = sd.selectStaffById("root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectStaffById;
	}

	@Override
	public boolean selectIfInProject(String pno, String staffno) {
		// TODO Auto-generated method stub
		PSRelationDao psrd = new PSRelationDaoImpl();
		boolean x = true;
		try {
			x = psrd.selectIfInProject(pno, staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
}
