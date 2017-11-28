package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.DTree;
import com.holyshit.domain.StageTask;
/**
 * 
 * @author yuan
 *
 */
public interface StageTasksDao {
	/**
	 * 根据id获取员工的所有正在进行的任务
	 * @return 任务列表
	 */
	List<StageTask> selectAllTasksById(String id)throws SQLException;
	
	/**
	 * 根据任务编号生成新的指标编号
	 * @param tn
	 * @return
	 * @throws SQLException 
	 */
	List<Object> selectIndexNobyTN(String tn) throws SQLException;
	
}
