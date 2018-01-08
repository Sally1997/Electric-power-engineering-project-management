package com.holyshit.service.impl;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.enterprise.inject.New;

import com.holyshit.Dao.TaskMesgDao;
import com.holyshit.Dao.impl.TaskMesgDaoImpl;
import com.holyshit.domain.TaskMesg;
import com.holyshit.service.TaskMesgService;

public class TaskMesgServiceImpl implements TaskMesgService{
	public List<TaskMesg> findAllTaskMesg(String me){
		TaskMesgDao tmd = new TaskMesgDaoImpl();
		List<TaskMesg> a=null;
		try {
			a = tmd.findallTaskMesg(me);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TaskMesg> b=null;
		try {
			b = tmd.findallStageMesg(me);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b!=null)
		{
		a.addAll(b);
		if(a!=null)
		{
		Collections.sort(a, new Comparator<TaskMesg>(){
			@Override
			public int compare(TaskMesg o1, TaskMesg o2) {
				// TODO Auto-generated method stub
				int flag = o1.getMdate().compareTo(o2.getMdate());
				System.out.println(flag);
				System.out.println(o1.getMdate());
				System.out.println(o2.getMdate());
				return -flag;
			}
		});
		}
		}
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i).getMdate());
		}
		return a;
		
	}
	
}
	
