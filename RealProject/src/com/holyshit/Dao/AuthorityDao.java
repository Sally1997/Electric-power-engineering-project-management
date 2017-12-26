package com.holyshit.Dao;

import java.sql.SQLException;

public interface AuthorityDao {
	/**
	 * 查询某人是否具有某种权限
	 * @param staffno
	 * @param perno
	 * @return
	 * @throws SQLException
	 */
	int selectHasPermission(String staffno,int perno)throws SQLException;
}
