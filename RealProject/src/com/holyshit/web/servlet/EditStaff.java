package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;
import com.holyshit.utils.MD5Util;

public class EditStaff extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取信息
		Staff newStaff=new Staff();
		newStaff.setStaffno(request.getParameter("staffno"));
		String name=request.getParameter("name");
		newStaff.setName(name);
		String sex=request.getParameter("sex");
		newStaff.setSex(sex);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = sdf.parse(request.getParameter("birthday"));
			newStaff.setBirthday(new java.sql.Date(parse.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("出生日期异常!");
			return;
		}
		newStaff.setTe(request.getParameter("te"));
		newStaff.setEmail(request.getParameter("email"));
		String password=request.getParameter("password");
		String changeFlag=request.getParameter("changeFlag");
		StaffService ss=new StaffServiceImpl();
		boolean flag=false;
		if(password.equals("")){
			flag=ss.editStaffInfo(newStaff,false,password,changeFlag);
		}else{
			flag=ss.editStaffInfo(newStaff,true,MD5Util.md5(password),changeFlag);
		}
		
		if(flag){
			response.getWriter().write("ok");
		}else{
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("员工信息修改失败，请仔细检查您的修改,稍后可再次提交");
		}
	}

}
