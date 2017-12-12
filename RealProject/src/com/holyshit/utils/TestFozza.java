package com.holyshit.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.Dao.impl.DTreeDaoImpl;
import com.holyshit.domain.ProjectInfo;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestFozza {
	@Test
	public void forTest() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String staffno = "201526010001";
		long l = (long) qr.query("select count(*) from ("+
				"SELECT Project.Pno,PName,NAME,duty,PType,PState "+
				"FROM project,psrelation,staff WHERE project.PNo=psrelation.PNo "+
				"AND PMno=staff.staffno AND psrelation.staffno=?)a"
				,new ScalarHandler(),staffno);
		int x = (int) l;
		System.out.println(x);
	}
	
	
}
