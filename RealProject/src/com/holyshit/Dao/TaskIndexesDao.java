package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.TaskIndexs;

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
	
	/**
	 * 插入任务指标信息
	 * @param ti
	 * @throws SQLException 
	 */
	void insertTaskIndexes(TaskIndexs ti) throws SQLException;
	
	/**
	 * 根据编号和指标内容该表指标附件路径
	 * @param no
	 * @param indexinfo
	 * @throws SQLException 
	 */
	void updateIndexAttachPath(String no,String indexinfo,String path) throws SQLException;
}
