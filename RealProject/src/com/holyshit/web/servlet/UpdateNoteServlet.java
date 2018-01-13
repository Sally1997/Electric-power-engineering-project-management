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
		String pno = request.getParameter("pno");
		String notedno = request.getParameter("staffno");
		String noterno=((Staff) request.getSession().getAttribute("staff")).getStaffno();
		String notes = request.getParameter(notedno);
		String notesbefore = request.getParameter("notesofnow");
		NoteService ns = new NoteServiceImpl();
		notes=new String(notes.getBytes("iso-8859-1"),"UTF-8");
		System.out.println(notes);
		if(notes.equals(""))
		{
			if(notesbefore!=null)
			{
				ns.delNote(pno, noterno, notedno);
			}
		}
		else 
		{
			if(notesbefore!=notes)
			{
				ns.updateNote(pno, noterno, notedno, notes);
			}
		}
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
