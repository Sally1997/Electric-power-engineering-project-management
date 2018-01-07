package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Inform;
import com.holyshit.domain.InformDocument;
import com.holyshit.domain.InformFee;
import com.holyshit.domain.InformProject;

public interface InformDao {
	/**
	 * 插入人员的系统消息
	 * @param type
	 * @param staffno
	 * @throws SQLException
	 */
	void insertInformhr(String type,String staffno) throws SQLException;
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
	 * 查询资金审核通知
	 * @param staffno
	 * @param types
	 * @return
	 * @throws SQLException
	 */
	List<InformFee> selectInformByTypeInFee(String staffno)throws SQLException;
	
	/**
	 * 查询普通文档消息
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<InformDocument> selectInformByTypeInDocument(String staffno)throws SQLException;
	
	/**
	 * 查询任务指标消息
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<InformDocument> selectInformByTypeInTaskIndex(String staffno)throws SQLException;
	
	/**
	 * 查询阶段指标信息
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<InformDocument> selectInformByTypeInStageIndex(String staffno)throws SQLException;
	
	/**
	 * 查询项目立项信息
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<InformProject>  selectInformByTypeInProject(String staffno)throws SQLException;
	
	/**
	 * 查询某种类型消息的数量
	 * @param staffno
	 * @param types
	 * @return
	 * @throws SQLException
	 */
	long selectInformNumberBytype(String staffno,String types)throws SQLException;
	
	/**
	 * 获取需要查询的消息种类
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<Object> selectTypeById(String staffno)throws SQLException;
	
	/**
	 * 设置消息字段
	 * @param mno
	 * @return
	 * @throws SQLException
	 */
	int hasRead(String mno,String flag)throws SQLException;
}
