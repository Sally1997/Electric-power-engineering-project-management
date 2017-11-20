package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.StageTask;

public interface StageTasksDao {
	/**
	 * 根据id获取员工的所有正在进行的任务
	 * @return 任务列表
	 */
	List<StageTask> selectAllTasksById(String id)throws SQLException;
}
