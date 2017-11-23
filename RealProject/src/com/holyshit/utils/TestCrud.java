package com.holyshit.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.holyshit.domain.TaskIndexs;


public class TestCrud {
//	@Test
//	public void TestUpdate() throws SQLException{
//		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
//		qr.update("Insert into TaskIndexes values('0000000055','0000000003','haoqia','haoqiadabuzhao')");
//	}
	
	@Test
	public void TestUpdate() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into taskindexes "
				+ "values (?,?,?,?)",
				"0000dw002fg","0000000012",
				"jiandan","dwadaw");
	}
}
