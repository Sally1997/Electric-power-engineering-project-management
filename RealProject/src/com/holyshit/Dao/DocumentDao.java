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
	 * 添加文件到数据库
	 * @param dno
	 * @param uloadpno
	 * @param pno
	 * @param dtitle
	 * @param dpath
	 * @param ftype
	 * @param dtype
	 * @param fsize
	 * @return
	 * @throws SQLException
	 */
	int addDocument(String dno,String uloadpno,String pno,String dtitle,String dpath,String ftype,String dtype,int fsize)throws SQLException;
	/**
	 * 将阅读数量加1
	 * @param dno
	 * @return
	 * @throws SQLException
	 */
	int addReadingNumber(String dno)throws SQLException;
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
	/**
	 * 插入新的文档信息
	 * @param doc
	 * @throws SQLException 
	 */
	int insertDocument(Document doc) throws SQLException;
	
	/**
	 * 更新文档审核表审核意见，审核状态，审核时间
	 * @param adv
	 * @param auditstate
	 * @throws SQLException 
	 */
	void updatePDocAudit(String adv,String auditstate,String dno) throws SQLException;
	
	/**
	 * 更新文档表审核意见
	 * @param agree
	 * @throws SQLException 
	 */
	void updateDocAuditState(String agree,String dno) throws SQLException;
}
