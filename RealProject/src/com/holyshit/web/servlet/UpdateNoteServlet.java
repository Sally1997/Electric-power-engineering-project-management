package com.holyshit.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.NoteService;
import com.holyshit.service.impl.NoteServiceImpl;

/**
 * Servlet implementation class UpdateNoteServlet
 */
@WebServlet("/web/servlet/updateNoteServlet")
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("床前明月光，头发掉光光！！！！");
		String pno = request.getParameter("pno");
		String notedno = request.getParameter("staffno");
		String noterno=((Staff) request.getSession().getAttribute("staff")).getStaffno();
		System.out.println("圣诞节愤怒愤怒经济法");
		String notes = request.getParameter(notedno);
		System.out.println("都案例和福利呢为了减肥38958");
		System.out.println(notes+"jijijijijiij");
		System.out.println("jijijijijiij");
		String notesbefore = request.getParameter("notesofnow");
		System.out.println("notesbrfore"+notesbefore);
		System.out.println("巨头望明月");
		NoteService ns = new NoteServiceImpl();
		if(notes.equals(""))
		{
			if(notesbefore!=null)
			{
				System.out.println("在Servlet里进行删除操作");
				ns.delNote(pno, noterno, notedno);
			}
		}
		else 
		{
			if(notesbefore!=notes)
			{
				System.out.println("在Servlet里进行修改操作");
				ns.updateNote(pno, noterno, notedno, notes);
			}
		}
		System.out.println("低头都是伤");
		request.getRequestDispatcher("/web/servlet/staffListServlet").forward(request,response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
