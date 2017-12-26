package com.holyshit.service.impl;
import com.holyshit.Dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.holyshit.utils.ConnectionManager;
import com.holyshit.service.*;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.Dao.impl.NoteDaoImpl;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.Note;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.PageBean;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public class StaffServiceImpl implements StaffService{
	//list staffs service
	public PageBean findAllStaffs(String pno,int CurrentPage,int PageSize,String noterno){
		System.out.println("跳转了到了见鬼的findallstaffs函数");
		StaffDao StaffDao = new StaffDaoImpl();
		NoteDao NoteDao = new NoteDaoImpl();
		try {
			System.out.println("进来了啦啦啦啦啦啦啦啦阿拉蕾");
			int count = StaffDao.countAllStaffs(pno);
			int totalPage = (int)Math.ceil(count*1.0/PageSize);
			List<StaffDuty> stafflist = StaffDao.findAllStaffs(pno,CurrentPage,PageSize);
			List<String> notelist = new ArrayList<String>();
			System.out.println("开始了……感觉要完蛋");
			System.out.println("size:"+stafflist.size());
			for(int i=0;i<stafflist.size();i++)
			{
				
				System.out.println("i=="+i);
				System.out.println("开始了……感觉要完蛋啊啊啊啊"+stafflist.get(i).getStaffno()+"pno:"+ pno);
				
				//System.out.println("notes"+NoteDao.findNote(pno, noterno, stafflist.get(i).getStaffno()).getNotes());
				if(NoteDao.findNote(pno, noterno, stafflist.get(i).getStaffno())==null)
				{
				notelist.add(null);
				}else {
					System.out.println("瞎几把搞啊啊啊啊啊");
					notelist.add(NoteDao.findNote(pno, noterno, stafflist.get(i).getStaffno()).getNotes());
				}
			}
			System.out.println("卧槽！！！！！");
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
		StaffDao StaffDao = new StaffDaoImpl();
		try{

			StaffDao.delAllStaffs(staffnos, pno);
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
}
