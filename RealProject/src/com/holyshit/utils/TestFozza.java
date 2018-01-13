package com.holyshit.utils;

import java.sql.SQLException;

import org.junit.Test;

import com.holyshit.Dao.PSRelationDao;
import com.holyshit.Dao.impl.PSRelationDaoImpl;
import com.holyshit.domain.PSRelation;

public class TestFozza {
	@Test
	public void forTest(){
		PSRelationDao psr = new PSRelationDaoImpl();
		boolean tt = false;
		PSRelation ps = new PSRelation();
		
		try {
			tt = psr.selectIfInProject("1000i", "201526010007");
			if(!psr.selectIfInProject("1000i", "201526010007")){
				ps.setPno("1000i");
				ps.setStaffno("201526010007");
				ps.setDuty("负责热");
				psr.insertPSRelation(ps);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tt);
	}
	
	
}
