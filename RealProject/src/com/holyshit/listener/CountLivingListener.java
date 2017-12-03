package com.holyshit.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountLivingListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session=se.getSession();
		List<HttpSession> sessionlist = (List<HttpSession>) session.getServletContext().getAttribute("sessionlist");
		
		sessionlist.add(session);
		
		ServletContext application=session.getServletContext();

		int count=(Integer) application.getAttribute("livingcount");
		count++;
		application.setAttribute("livingcount", count);
		System.out.println("1人登陆，当前在线人数："+(Integer)application.getAttribute("livingcount"));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
