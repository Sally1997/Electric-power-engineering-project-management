package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.TaskMesg;

public interface TaskMesgDao {
	List<TaskMesg> findallTaskMesg(String me) throws SQLException;
	List<TaskMesg> findallStageMesg(String me) throws SQLException;
}
