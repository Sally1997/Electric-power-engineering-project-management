package com.holyshit.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class ConnectionManager {
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	public static Connection getConnection(){
		Connection conn=tl.get();
		if(conn==null){
<<<<<<< HEAD
			//´ÓÁ¬½Ó³Ø»ñÈ¡Ò»¸öÁ¬½Ó
			try {
				conn=C3P0Util.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tl.set(conn);
		}
		return conn;
	}
	
	public static void closeConnection(){
		try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tl.remove();  //Çå¿Õ
	}
	
	public static void startTransaction(){
		try {
			Connection conn=getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rollback(){
		try {
			Connection conn=getConnection();
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit(){
		try {
			Connection conn=getConnection();
			conn.commit();
		} catch (SQLException e) {
=======
			//ï¿½ï¿½ï¿½ï¿½ï¿½Ó³Ø»ï¿½È¡Ò»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			try {
				conn=C3P0Util.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tl.set(conn);
		}
		return conn;
	}
	
	public static void closeConnection(){
		try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tl.remove();  //ï¿½ï¿½ï¿½
	}
	
	public static void startTransaction(){
		try {
			Connection conn=getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rollback(){
		try {
			Connection conn=getConnection();
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit(){
		try {
			Connection conn=getConnection();
			conn.commit();
		} catch (SQLException e) {
			
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
