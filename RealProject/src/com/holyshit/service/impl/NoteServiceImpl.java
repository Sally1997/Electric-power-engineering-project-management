package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.NoteDao;
import com.holyshit.Dao.impl.NoteDaoImpl;
import com.holyshit.domain.Note;
import com.holyshit.service.NoteService;

public class NoteServiceImpl implements NoteService{
	public void updateNote(String pno,String noterno,String notedno,String notes){
		NoteDao NoteDao = new NoteDaoImpl();
		try {
			Note note = NoteDao.findNote(pno,noterno,notedno);
			if(note==null)
			{
				NoteDao.addNote(pno, noterno, notedno, notes);
			}
			else {
				NoteDao.updateNote(pno, noterno, notedno, notes);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delNote(String pno,String noterno,String notedno){
		NoteDao NoteDao = new NoteDaoImpl();
		try {
			Note note = NoteDao.findNote(pno,noterno,notedno);
			if(note!=null)
			{
				NoteDao.delNote(pno, noterno, notedno);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
