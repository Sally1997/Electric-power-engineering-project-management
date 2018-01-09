package com.holyshit.listener;

import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.service.PSPlanService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.PSPlanServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

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
				StageTasksService ss=new StageTasksServiceImpl();
				List<StageTask> res = ss.findAllChangeState();
				Map<String, String> para=new HashMap<String, String>();
				for(StageTask task:res){
					long curtime=new Date().getTime();
					if((curtime>task.getEtime().getTime())){
						//大于截至日期
						para.put(task.getTaskno(),"2");
					}else if((curtime>task.getStime().getTime())&&(!task.getTstate().equals("1"))){
						para.put(task.getTaskno(),"1");
					}
				}
				//刷新任务状态
				if(para.size()>0){
					StageTasksService sts=new StageTasksServiceImpl();
					boolean flag = sts.refreshTaskState(para);
					if(flag)
						System.out.println("任务状态更新成功");
					else {
						System.out.println("任务状态更新失败");
					}
				}
				
			}
		}, 0, 60000);
		
		//定时更新阶段状态
		//每晚12点
		Timer stageTimer=new Timer();
		stageTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				PSPlanService ss=new PSPlanServiceImpl();
				List<PSPlan> res = ss.findAllChangeState();
				Map<String, String> para=new HashMap<String, String>();
				for(PSPlan task:res){
					long curtime=new Date().getTime();
					if((curtime>task.getEtime().getTime())){
						//大于截至日期
						para.put(task.getStageno(),"2");
					}else if((curtime>task.getStime().getTime())&&(!task.getSstate().equals("1"))){
						para.put(task.getStageno(),"1");
					}
				}
				//刷新任务状态
				if(para.size()>0){
					PSPlanService sts=new PSPlanServiceImpl();
					boolean flag = sts.refreshStageState(para);
					if(flag)
						System.out.println("阶段状态更新成功");
					else {
						System.out.println("阶段状态更新失败");
					}
				}
				
			}
		}, 60000, 60000);
		
		//定时更新项目状态
		//每晚12点
		Timer projectTimer=new Timer();
		projectTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ProjectService ss=new ProjectServiceImpl();
				List<Project> res = ss.findAllChangeState();
				Map<String, String> para=new HashMap<String, String>();
				for(Project task:res){
					long curtime=new Date().getTime();
					if((curtime>task.getEtime().getTime())){
						//大于截至日期
						para.put(task.getPno(),"2");
					}else if((curtime>task.getStime().getTime())&&(!task.getPstate().equals("1"))){
						para.put(task.getPno(),"1");
					}
				}
				//刷新任务状态
				if(para.size()>0){
					ProjectService sts=new ProjectServiceImpl();
					boolean flag = sts.refreshProjectState(para);
					if(flag)
						System.out.println("阶段状态更新成功");
					else {
						System.out.println("阶段状态更新失败");
					}
				}
				
			}
		}, 120000, 60000);
		
		//定时清理tmp文件夹
		//每晚12点
		Timer clearTimer=new Timer();
		clearTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//删除tmp下面所有的文件
				String pathbase = application.getRealPath("/tmp");
				File file=new File(pathbase);
				File[] listFiles = file.listFiles();
				if(listFiles!=null){
					for(File f:listFiles){
						if(f.isFile())
							f.delete();
					}
				}
			}
		},time, 60*60*24*1000);
		
		
		
		
		
	}

}
