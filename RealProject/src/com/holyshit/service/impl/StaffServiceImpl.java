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
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.Dao.impl.NoteDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
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
	public void delAllStaffs(String[] staffnos,String pno) {
		// TODO Auto-generated method stub
		InformDao ifd = new InformDaoImpl();
		StaffDao StaffDao = new StaffDaoImpl();
		try{

			StaffDao.delAllStaffs(staffnos, pno);
			for(int i=0;i<staffnos.length;i++)
			{
				ifd.insertInformhr("S1", staffnos[i]);
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
	
	public void addAStaff(PSRelation psr){
		InformDao ifd = new InformDaoImpl();
		StaffDao StaffDao = new StaffDaoImpl();
		try {
			StaffDao.addAStaff(psr);
			ifd.insertInformhr("S0", psr.getStaffno());
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
					map.put("duty", "null");
				}
				if(map.get("notes")==null){
					map.put("notes", "null");
				}
			}
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
					map.put("duty", "null");
				}
				if(map.get("notes")==null){
					map.put("notes", "null");
				}
			}
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
					map.put("duty", "null");
				}
				if(map.get("notes")==null){
					map.put("notes", "null");
				}
			}
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
	public boolean editStaffInfo(Staff staff, boolean change,String password) {
		// TODO Auto-generated method stub
		StaffDao sd=new StaffDaoImpl();
		AccountDao ad=new AccountDaoImpl();
		int res1=0,res2=0;
		if(change){
			//重置了密码
			try {
				ConnectionManager.startTransaction();
				res1=sd.editStaff(staff);
				res2=ad.editAccount(staff.getStaffno(), password);
				ConnectionManager.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				ConnectionManager.rollback();
				e.printStackTrace();
			}finally{
				ConnectionManager.closeConnection();
			}
			if(res1==1&&res2==1){
				return true;
			}
		}else{
			//未重置密码
			try {
				res1=sd.editStaff(staff);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnectionManager.closeConnection();
			}
			if(res1==1){
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
		boolean resFlag=false;
		try {
			ConnectionManager.startTransaction();
			//有先后关系
			int[] res2 = ad.deleteAccount(staffs);
			int[] res1 = sd.deleteStaff(staffs);
			boolean flag=false;
			for(int i=0;i<res1.length;i++)
				if(res1[i]!=res2[i]){
					flag=true;
					break;
				}else if(res1[i]==0){
					flag=true;
					break;
				}
			if(!flag){
				resFlag=true;
				ConnectionManager.commit();
			}else {
				ConnectionManager.rollback();
			}
		} catch (SQLException e) {
			ConnectionManager.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return resFlag;
	}
}
