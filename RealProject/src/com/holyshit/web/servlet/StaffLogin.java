package com.holyshit.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javassist.compiler.ast.Variable;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.holyshit.domain.Account;
import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.service.AccountService;
import com.holyshit.service.PermissionService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.AccountServiceImpl;
import com.holyshit.service.impl.PermissionServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class StaffLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//��ȡ��
		Account account=new Account();
		try {
			BeanUtils.populate(account, request.getParameterMap());
			account.setLltime(new Date(new java.util.Date().getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code=request.getParameter("validatecode");
		String over=request.getParameter("over");
		//�Ƿ��½�ɹ�
		AccountService as=new AccountServiceImpl();
		boolean res=false;
		Map<String, String> error=new HashMap<String, String>();
		HttpSession session = request.getSession();

		if(code.equals(session.getAttribute("validatecode"))){
			if(as.login(account)){
				res=true;
			}
			else {
			
				error.put("username", "用户名或者密码错误");
			}
		}else {
		
			error.put("validatecode", "验证码错误");
		}	
		//�ַ�ת��
		if(res){
			//是否记住密码
			String remember=request.getParameter("remember");
			if(remember!=null&&request.getParameter("remember").equals("remember")){
				Cookie cname=new Cookie("staffno", account.getStaffno());
				Cookie cpassword=new Cookie("password", account.getPassword());
				cname.setMaxAge(Integer.MAX_VALUE);
				cpassword.setMaxAge(Integer.MAX_VALUE);
				cname.setPath("/");
				cpassword.setPath("/");
				
				response.addCookie(cname);
				response.addCookie(cpassword);
			
			}else{
				Cookie cname=new Cookie("staffno", "");
				Cookie cpassword=new Cookie("password", "");
				cname.setMaxAge(0);
				cpassword.setMaxAge(0);
				cname.setPath("/");
				cpassword.setPath("/");
				response.addCookie(cname);
				response.addCookie(cpassword);
			}
			//添加到一登录人员链表！
			ServletContext application = request.getServletContext();
			List<String> list=(List<String>) application.getAttribute("hasLoginedStaff");
			if(list==null){
				list=new LinkedList<String>();
				list.add(account.getStaffno());
				//压回session
				application.setAttribute("hasLoginedStaff", list);
				
			}else{
				if(over!=null){
					//确认登录
					
					//进行的操作，使对方掉线   可能很慢
					List<HttpSession> sessionlist=(List<HttpSession>) application.getAttribute("sessionlist");
					//遍历寻找对应的session，销毁
					for(Iterator<HttpSession> it=sessionlist.iterator();it.hasNext();){
						HttpSession s=it.next();
						if(((Staff)s.getAttribute("staff")).getStaffno().equals(account.getStaffno())){
							System.out.println("强制对方掉线");
							s.invalidate();
							it.remove();
							break;
						}
					}
					
				}else{
					//是否存在
					if(list.contains(account.getStaffno())){
						request.setAttribute("overLogin_staffno", account.getStaffno());
						request.setAttribute("overLogin_password", account.getPassword());
						request.setAttribute("overLogin_validatecode", code);
						request.getRequestDispatcher("/overLogin.jsp").forward(request, response);
						return;
					}else{
						list.add(account.getStaffno());
						application.setAttribute("hasLoginedStaff", list);
					}
				}
			}
			
			
			
			//����session
			session.removeAttribute("validatecode");
			//获取用户的信息
			Staff staff = as.getUserById(account.getStaffno());
			session.setAttribute("staff", staff);
			//文档审批权限是否具有
			PermissionService ps=new PermissionServiceImpl();
			boolean enableCheckDocument = ps.enableCheckDocument(staff.getStaffno());
			if(enableCheckDocument)
				session.setAttribute("enableCheckDocument", 1);
			//发布公告权限
			boolean enablePublicNotice=ps.enablePublicNotice(staff.getStaffno());
			if(enablePublicNotice){
				session.setAttribute("enablePublicNotice", 1);
			}
			
			
			
			//跳转到相应的uri
			String uri=request.getParameter("uri");
			if(uri!=null){
				//跳入相应的界面
				response.sendRedirect(uri);
			}
			else {
				//进入主页
				response.sendRedirect(request.getContextPath()+"/web/servlet/mainServlet");
				
			}
		}else{
		
			request.setAttribute("error", error);
			request.setAttribute("account", account);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
