package com.holyshit.utils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.StageTasksServiceImpl;


public class TestCrud {
	@Test
	public void TestUpdate() throws SQLException{
		StageTask stage_task = new StageTask();
		TaskIndexs task_index = new TaskIndexs();
		
		try {
			/**
			 * 获取表单数据
			 */
			System.out.println("在搞我");
			//getParameterMap用不了
			stage_task.setTaskname("就这个吧");
			
			//预算
			stage_task.setBudget("1000.20");
			//日期转换
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			stage_task.setStime(sdf.parse("2015-16-05"));
			stage_task.setEtime(sdf.parse("2015-16-20"));
			
			//pro_stage.setPublisherNo("201526010429");//测试用
			
			stage_task.setPubno("201526010412");
			
			String tno = "";
			//点击新建子任务，阶段任务的编号会setAttribute转发到NewTask.jsp页面
			//tno = (String) request.getAttribute("taskno");
			tno = "1000110001";//测试用
			
			//父节点
			stage_task.setPtaskno(tno);
			
			//生成新节点便号
			AutoNumber an = new AutoNumber();
			String ntn = an.TrueNewTaskNo(tno);
			stage_task.setTaskno(ntn);
			
			//审批人
			String rcpn = "爱丽丝(201526010002)";
			String cpn = "";
			for(int i=0;i<12;i++){
				cpn+=rcpn.charAt(rcpn.length()-13+i);
			}
			stage_task.setCharpno(cpn);
			stage_task.setTstate(0);
			
			//任务指标表
			task_index.setTaskNo(ntn);
			task_index.setIndexNo(an.TNtoIN(ntn));
			
			//指标内容
			task_index.setIndexInfo("我真是想");
			System.out.println(task_index);
			
			//插入
			StageTasksService sts = new StageTasksServiceImpl();
			sts.AddTaskandIndex(stage_task, task_index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
