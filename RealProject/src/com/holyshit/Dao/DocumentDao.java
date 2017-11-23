package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.Document;

/**
 * 
 * @author yuan
 *
 */
public interface DocumentDao {
	
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
