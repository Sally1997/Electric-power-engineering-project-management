package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.PSRelation;

public interface PSRelationDao {
	/**
	 * 查询一个员工是否在项目组里面
	 * @param staffno
	 * @return
	 * @throws SQLException 
	 */
	boolean selectIfInProject(String pno,String staffno) throws SQLException;
	
	/**
	 * 向人员关系表添加信息
	 * @param psr
	 * @throws SQLException
	 */
	void insertPSRelation(PSRelation psr) throws SQLException;
	
	/**
	 * 批量删除所有的人员项目关系
	 * @param para
	 * @return
	 * @throws SQLException
	 */
	int[] deleteAllRelation(String[] para)throws SQLException;
}
