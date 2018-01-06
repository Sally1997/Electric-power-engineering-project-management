package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Inform;

public interface InformDao {
	/**
	 * 返回当前新建的立项审核编号，因为时自增数列，直接返回最大值即可
	 * @return
	 * @throws SQLException 
	 */
	List<Object> selectCurPaauditNO() throws SQLException;
	     
	/**
	 * 插入信息表信息
	 * @param info
	 * @throws SQLException 
	 */
	void insertInform(Inform info) throws SQLException;
	
	/**
	 * 根据mno获得inform
	 * @param mno
	 * @return
	 * @throws SQLException 
	 */
	Inform selectInformByMno(String mno) throws SQLException;
	
	/**
	 * 修改信息表未读状态
	 * @throws SQLException 
	 */
	void updateInformState(String mno) throws SQLException;
	
	/**
	 * 查询某种类型的数据
	 * @param staffno
	 * @param types
	 * @return
	 * @throws SQLException
	 */
	List<Inform> selectInformByTypePage(String staffno,String[] types)throws SQLException;
	
	/**
	 * 查询某种类型消息的数量
	 * @param staffno
	 * @param types
	 * @return
	 * @throws SQLException
	 */
	long selectInformNumberBytype(String staffno,String[] types)throws SQLException;
}
