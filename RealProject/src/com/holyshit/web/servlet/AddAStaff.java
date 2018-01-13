package com.holyshit.web.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.holyshit.Dao.StaffDao;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;
import com.mchange.v2.codegen.bean.BeangenUtils;

public class AddAStaff extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳到了AddAStaff SERVLET");
		String pno = request.getParameter("pno");
		PSRelation psr = new PSRelation();
		String duty = request.getParameter("duty");
		duty=new String(duty.getBytes("iso-8859-1"),"UTF-8");
		String SearchStaffNo = request.getParameter("SearchStaffNo");
		System.out.println(SearchStaffNo.length());
		if(SearchStaffNo.length()!=12)
		{
			String error = "您输入的员工编号不符合要求，必须为12位";
			request.setAttribute("error", error);
			request.setAttribute("pno", pno);
			request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
		}
		else {
			StaffService ss = new StaffServiceImpl();
			if(ss.findAStaff(SearchStaffNo)==null)
			{
				String error = "您添加的员工不存在，请查找确认后添加";
				request.setAttribute("error", error);
				request.setAttribute("pno", pno);
				request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
			}
			else {
				if(ss.isinproject(SearchStaffNo, pno)==1)
				{
					String error = "您添加的员工已存在项目组";
					request.setAttribute("error", error);
					request.setAttribute("pno", pno);
					request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
				}
				else {
					String me = ((Staff) request.getSession().getAttribute("staff")).getStaffno();
					System.out.println("Staffno:"+SearchStaffNo+" pno="+pno+" duty="+duty);
					psr.setPno(pno);
					psr.setDuty(duty);
					psr.setStaffno(SearchStaffNo);	
					ss.addAStaff(psr,me);
					request.setAttribute("pno", pno);
					String error = "添加成功";
					request.setAttribute("error", error);
					request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
				}
			}
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
