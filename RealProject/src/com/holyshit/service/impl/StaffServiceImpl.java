package com.holyshit.service.impl;
import com.holyshit.Dao.*;

import java.sql.SQLException;
import java.util.List;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.service.*;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.Dao.impl.StaffDaoImpl;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public class StaffServiceImpl implements StaffService{
	private StaffDao StaffDao = new StaffDaoImpl();
	//list staffs service
	public List<StaffDuty> findAllStaffs(String pno){
		try {
			return StaffDao.findAllStaffs(pno);
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
		try {
			StaffDao.addAStaff(psr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
