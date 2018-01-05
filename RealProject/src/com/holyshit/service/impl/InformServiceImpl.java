package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.InformDao;
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.domain.Inform;
import com.holyshit.service.InformService;
import com.holyshit.utils.ConnectionManager;

public class InformServiceImpl implements InformService {

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

}
