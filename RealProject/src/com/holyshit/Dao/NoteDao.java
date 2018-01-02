package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.Note;

public interface NoteDao {
	public Note findNote(String pno,String noterno,String notedno) throws SQLException;
	public void updateNote(String pno,String noterno,String notedno,String notes) throws SQLException;
	public void addNote(String pno,String noterno,String notedno,String notes) throws SQLException;
	public void delNote(String pno,String noterno,String notedno) throws SQLException;
}   
