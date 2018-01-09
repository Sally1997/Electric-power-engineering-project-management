package com.holyshit.listener;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Staff;

public class DeleteSessionListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//新建livingcount存储系统在线人数    stafflist统计登录用户
		int num=0;
		final ServletContext application= arg0.getServletContext();
		application.setAttribute("livingcount", num);
		//新建安全链表
		final List<HttpSession> list=Collections.synchronizedList(new LinkedList<HttpSession>());
		final List<String> stafflist=Collections.synchronizedList(new LinkedList<String>());
		application.setAttribute("sessionlist", list);
		application.setAttribute("hasLoginedStaff", stafflist);
		
		
		//定时清理失效session  
		//2分钟清理一次
		Timer timer1=new Timer();
		timer1.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				// TODO Auto-generated method stub
				//遍历链表中所有session，如果失效，则删除   
				for(Iterator<HttpSession> iterator=list.iterator();iterator.hasNext();){
					HttpSession session = iterator.next();
					long last=session.getLastAccessedTime();
					//超过20分钟没有操作  失效
					if(new Date().getTime()-last>1200000)
					{
						int num=(Integer) application.getAttribute("livingcount");
						application.setAttribute("livingcount", num-1);
						//修改在线人员表
						for(Iterator<String> it=stafflist.iterator();it.hasNext();){
							String cur=it.next();
							Staff tmp=(Staff) session.getAttribute("staff");
							if(tmp!=null&&tmp.getStaffno().equals(cur)){
								//删除
								System.out.println("删除人员链表"+cur);
								it.remove();
								break;
							}
						}
						
						session.invalidate();
						iterator.remove();
					}
				}
			}
		}, 0, 120000);
		
		//凌晨0点
		Calendar starttime=Calendar.getInstance();
		starttime.set(Calendar.HOUR_OF_DAY, 24); // 控制时
		starttime.set(Calendar.MINUTE, 0);    // 控制分
		starttime.set(Calendar.SECOND, 0);    // 控制秒
	 
	    Date time = starttime.getTime();
		
		
		//定时更新任务状态
		//每晚12点
		Timer taskTimer=new Timer();
		taskTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, time, 1000*24*60*60);
		
		//定时更新阶段状态
		//每晚12点
		
		
		//定时更新项目状态
		//每晚12点
		
		
		//定时清理tmp文件夹
		//每晚12点
		
		
	}

}
