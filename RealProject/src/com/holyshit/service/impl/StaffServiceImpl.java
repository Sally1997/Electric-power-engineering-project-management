package com.holyshit.service.impl;
import com.holyshit.Dao.*;

import java.sql.SQLException;
import java.util.List;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.service.*;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.PageBean;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public class StaffServiceImpl implements StaffService{
	//list staffs service
	public PageBean findAllStaffs(String pno,int CurrentPage,int PageSize){
		StaffDao StaffDao = new StaffDaoImpl();
		try {
			int count = StaffDao.countAllStaffs(pno);
			int totalPage = (int)Math.ceil(count*1.0/PageSize);
			
			PageBean pb = new PageBean();
			pb.setCount(count);
			pb.setStaffs(StaffDao.findAllStaffs(pno,CurrentPage,PageSize));
			pb.setCurrentPage(CurrentPage);
			pb.setPageSize(PageSize);
			pb.setTotalPage(totalPage);
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
	

}
