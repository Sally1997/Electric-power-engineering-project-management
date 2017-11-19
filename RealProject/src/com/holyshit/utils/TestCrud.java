package com.holyshit.utils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.holyshit.utils.C3P0Util;

public class TestCrud {
	@Test
	public void TestUpdate() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("Insert into TaskIndexes values('0000000001','0000000001','haoqia','haoqiadabuzhao')");
	}
}
