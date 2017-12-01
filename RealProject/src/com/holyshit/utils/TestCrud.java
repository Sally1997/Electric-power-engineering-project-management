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
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class TestCrud {
	@Test
	public void TestUpdate() throws SQLException{
		String pn = "10001";
		DTreeNodeService dtns = new DTreeNodeServiceImpl();
		List<DTree> list = new ArrayList<DTree>();
		try {
			Project pro = dtns.GetProjectInfo(pn);
			List<PSPlan> slist = dtns.GetSNByPn(pn);
			List<StageTask> tlist = dtns.GetTNByPn(pn);
			
			//加入项目阶段节点
			DTree dt = new DTree();
			dt.setCurrentNode(pro.getPno());
			dt.setParentNode("-1");
			dt.setNodeName(pro.getPname());
			list.add(dt);
			
			//加入阶段节点
			for(int i=0;i<slist.size();i++){
				DTree dt1 = new DTree();
				dt1.setCurrentNode(slist.get(i).getStageNo());
				dt1.setParentNode(slist.get(i).getPNo());
				dt1.setNodeName(slist.get(i).getSName());
				list.add(dt1);
			}
			
			//加入任务节点
			for(int i=0;i<tlist.size();i++){
				DTree dt2 = new DTree();
				dt2.setCurrentNode(tlist.get(i).getTaskno());
				dt2.setParentNode(tlist.get(i).getPtaskno());
				dt2.setNodeName(tlist.get(i).getTaskname());
				list.add(dt2);
			}
			String str = JSONArray.fromObject(list).toString();
			System.out.println(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
