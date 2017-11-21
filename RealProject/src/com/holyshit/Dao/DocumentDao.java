package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Document;

/**
 * 
 * @author yuan
 *
 */
public interface DocumentDao {
	/**
	 * 根据用户id获取相关项目的所有文档
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	List<Document> selectAllDocumentByUserId(String id)throws SQLException;
}
