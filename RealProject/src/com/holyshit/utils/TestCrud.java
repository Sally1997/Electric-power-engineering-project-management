package com.holyshit.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.holyshit.domain.DTree;
import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;


public class TestCrud {
	@Test
	public void TestUpdate() throws SQLException{
		String pn = "10001";
		DTreeNodeService dtns = new DTreeNodeServiceImpl();
		List<DTree> list = new ArrayList<DTree>();
		try {
			Project pro = dtns.GetProjectInfo(pn);
			List<ProjectStage> slist = dtns.GetSNByPn(pn);
			List<StageTask> tlist = dtns.GetTNByPn(pn);
			
			for(int i=0;i<tlist.size();i++){
				System.out.println(tlist.get(i).getPubno());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
