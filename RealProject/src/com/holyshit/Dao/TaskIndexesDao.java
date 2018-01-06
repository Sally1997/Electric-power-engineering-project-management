package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TaskIndexesDao {
	/**
	 * 查找阶段或者任务的指标
	 * @param taskno
	 * @return
	 * @throws SQLException 
	 */
	List<Map<String,Object>> selectTaskIndexes(String taskno) throws SQLException;
	
	/**
	 * 改变指标状态为1
	 * @param indexno
	 * @throws SQLException 
	 */
	void updateIndexState(String indexno,String indexstate) throws SQLException;
}
