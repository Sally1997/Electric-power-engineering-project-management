package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.TaskMesg;

public interface SystemMesgDao {
	List<TaskMesg> listSystemMesghr(String me) throws SQLException;
	List<TaskMesg> listSystemMesgroot(String me) throws SQLException;
}
