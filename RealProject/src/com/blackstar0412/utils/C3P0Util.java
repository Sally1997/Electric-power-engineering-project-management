package com.blackstar0412.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource ds=new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public static void release(Connection conn,Statement state,ResultSet rs) throws SQLException{
		if(conn!=null)
			conn.close();
		if(state!=null)
			state.close();
		if(rs!=null)
			rs.close();
	}

}
