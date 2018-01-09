package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Qualification;
import com.holyshit.domain.Staff;
import com.holyshit.service.QualificationService;
import com.holyshit.service.impl.QualificationServiceImpl;

/**
 * Servlet implementation class AddQualificationServlet
 */
@WebServlet("/web/servlet/addQualificationServlet")
public class AddQualificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addqualificationnow");
		String staffno = ((Staff) request.getSession().getAttribute("staff")).getStaffno();
		String qua=request.getParameter("qua");//将Usercenter添加资格证的输入框的name设置成qua
		qua=new String(qua.getBytes("iso-8859-1"),"UTF-8");
		QualificationService qfs = new QualificationServiceImpl();
		List<Qualification> qL = qfs.findAllQualifications(staffno);
		String error2="";
		int flag =0;
		for(int i=0;i<qL.size();i++)
		{
			if(qL.get(i).getQualifdesc().equals(qua))
			{
				error2="不可添加已存在的资格证";
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			qfs.AddAQualification(staffno,qua);
		}
		request.setAttribute("error2",error2);
		
		request.getRequestDispatcher("/web/showUserCenterServlet").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
