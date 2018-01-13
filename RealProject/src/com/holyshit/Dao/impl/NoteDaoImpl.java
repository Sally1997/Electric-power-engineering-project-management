package com.holyshit.Dao.impl;

import java.sql.SQLException;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.holyshit.Dao.NoteDao;
import com.holyshit.domain.Note;
import com.holyshit.utils.C3P0Util;

public class NoteDaoImpl implements NoteDao {
	public Note findNote(String pno,String noterno,String notedno) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from staffnote where pno=? and noterno=? and notedno=?", new BeanHandler<Note>(Note.class), pno,noterno,notedno);
	}
	public void updateNote(String pno,String noterno,String notedno,String notes) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update staffnote set notes=? where pno=? and noterno=? and notedno=?",notes,pno,noterno,notedno);
	}
	public void addNote(String pno,String noterno,String notedno,String notes) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into staffnote(NoterNo,NotedNo,Notes,PNo) values(?,?,?,?)",noterno,notedno,notes,pno);
	}
	public void delNote(String pno,String noterno,String notedno) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from staffnote where pno=? and noterno=? and notedno=?",pno,noterno,notedno);
	}
}
