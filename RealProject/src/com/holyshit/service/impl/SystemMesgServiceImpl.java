package com.holyshit.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.holyshit.Dao.SystemMesgDao;
import com.holyshit.Dao.impl.SystemMesgDaoImpl;
import com.holyshit.domain.TaskMesg;
import com.holyshit.service.SystemMesgService;


public class SystemMesgServiceImpl implements SystemMesgService {
	public List<TaskMesg> findAllSystemMesg(String me){
		SystemMesgDao smd = new SystemMesgDaoImpl();
		List<TaskMesg> a =null;
		List<TaskMesg> b =null;
		try {
			a = smd.listSystemMesghr(me);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			b = smd.listSystemMesgroot(me);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TaskMesg> sysmesgs = new ArrayList<TaskMesg>();
		if(a!=null)
		{
			sysmesgs.addAll(a);
		}
		
		if(b!=null)
		{
			sysmesgs.addAll(b);
		}
		if(sysmesgs!=null)
		{
			Collections.sort(sysmesgs, new Comparator<TaskMesg>(){
				@Override
				public int compare(TaskMesg o1, TaskMesg o2) {
					// TODO Auto-generated method stub
					int flag = o1.getMdate().compareTo(o2.getMdate());
					return -flag;
				}
			});
		}
		return sysmesgs;
	}
}
