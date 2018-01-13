package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Authority;

public interface AuthorityDao {
	/**
	 * 查询某人是否具有某种权限
	 * @param staffno
	 * @param perno
	 * @return
	 * @throws SQLException
	 */
	int selectHasPermission(String staffno,int perno)throws SQLException;
	
	/**
	 * 获取当前系统存在的所有权限
	 * @return
	 * @throws SQLException
	 */
	List<Authority> selectAllPermission()throws SQLException;
	
	/**
	 * 获取某人所具有的全部权限
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<Authority> selectPermissionById(String staffno)throws SQLException;
	
	/**
	 * 查看某人是否具有某种权限
	 * @param staffno
	 * @param perno
	 * @return
	 * @throws SQLException
	 */
	boolean hasPermissionById(String staffno,int perno)throws SQLException;
	
	/**
	 * 给某人添加权限
	 * @param staffno
	 * @param perno
	 * @return
	 * @throws SQLException
	 */
	int addAuthorityById(String staffno,String perno)throws SQLException;
	
	/**
	 * 删除某人权限
	 * @param staffno
	 * @param perno
	 * @return
	 * @throws SQLException
	 */
	int deleteAuthorityById(String staffno,String perno)throws SQLException;
	
	/**
	 * 批量删除全部权限
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	int[] deleteAllAuthorityById(String[] staffs)throws SQLException;
}
