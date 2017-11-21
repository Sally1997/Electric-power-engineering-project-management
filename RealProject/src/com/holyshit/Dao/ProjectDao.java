package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Project;
/**
 * 
 * @author yuan
 *
 */
public interface ProjectDao {
	/**
	 * 获取用户正在参与的所有项目的列表
	 * @param id 用户id
	 * @return
	 * @throws SQLException sql异常抛出，service处理
	 */
	List<Project> selectProjectsById(String id)throws SQLException;
}
