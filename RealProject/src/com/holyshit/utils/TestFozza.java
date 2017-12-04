package com.holyshit.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

public class TestFozza {
	@Test
	public void forTest() throws SQLException{
		String Pno = "";
		String x = "1";
		ProjectService ps = new ProjectServiceImpl();
		List<Object> list = new ArrayList<Object>();
		list = ps.getNewProjectNo(x);
		String str = list.get(0).toString();
		Pno = str.substring(0, str.length()-1);
		char c = str.charAt(str.length()-1);
		if(c=='9'){
			c='a';
		}
		else{
			c++;
		}
		Pno += c;
		System.out.println(Pno);
	}
}
