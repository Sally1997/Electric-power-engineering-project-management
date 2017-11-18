package com.blackstar0412.utils;


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
			//从连接池获取一个连接
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
		tl.remove();  //清空
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
