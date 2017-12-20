package com.holyshit.Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.Document;
import com.holyshit.domain.DocumentInfo;

/**
 * 
 * @author yuan
 *
 */
public interface DocumentDao {
	/**
	 * 查询符合相应条件的文件数量
	 * @param dtype
	 * @param dateFrom
	 * @param dateTo
	 * @param keywords
	 * @param ftype
	 * @return
	 * @throws SQLException
	 */
	long totalNumWithCondition(String ptype,String dtype,String dateFrom,String dateTo,String keywords,String ftype)throws SQLException;
	/**
	 * 根据条件查询文档
	 * @param dtype
	 * @param dateFrom
	 * @param dateTo
	 * @param keywords
	 * @param ftype
	 * @return
	 * @throws SQLException
	 */
	List<DocumentInfo> selectDocumentByCondition(String ptype,String dtype,String dateFrom,String dateTo,String keywords,String ftype,int cur,int pageSize)throws SQLException;
	/**
	 * 查询上传文件的信息
	 * @param dno
	 * @return
	 * @throws SQLException
	 */
	Document getDocumentById(String dno)throws SQLException;
	
	/**
	 * 根据用户id获取相关项目的所有文档
	 * 分页查询
	 * @param id   用户id
	 * @param cur   当前页
	 * @param pageSize  分页大小
	 * @return
	 * @throws SQLException
	 */
	List<Document> selectAllDocumentByUserId(String id,int cur,int pageSize)throws SQLException;
	/**
	 * 获取用户相关文档的总数
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	long totalSizeWithId(String id)throws SQLException;
}
