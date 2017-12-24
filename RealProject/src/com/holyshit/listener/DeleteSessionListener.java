package com.holyshit.listener;

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

public class DeleteSessionListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//新建livingcount存储系统在线人数
		int num=0;
		final ServletContext application= arg0.getServletContext();
		application.setAttribute("livingcount", num);
		
		//新建安全链表
		final List<HttpSession> list=Collections.synchronizedList(new LinkedList<HttpSession>());
		application.setAttribute("sessionlist", list);
		
		//定时清理失效session  
		//60s清理一次
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			
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
						session.invalidate();
						iterator.remove();
					}
				}
			}
		}, 0, 60000);
		
		
	}

}
