package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

	@Override
	public Map<String, Object> findInformNumber(String staffno) {
		// TODO Auto-generated method stub
		String[] task_inform={"1"};
		String[] system_inform={"2","7"};
		String[] audit_inform={"3","4","5","6"};
		Map<String, Object> res=new HashMap<String, Object>();
		InformDao inform=new InformDaoImpl();
		try {
			ConnectionManager.startTransaction();
			
			long task_num = inform.selectInformNumberBytype(staffno, task_inform);
			
			long system_num = inform.selectInformNumberBytype(staffno, system_inform);
			long audit_num = inform.selectInformNumberBytype(staffno, audit_inform);
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

}
