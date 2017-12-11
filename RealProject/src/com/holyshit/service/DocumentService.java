package com.holyshit.service;

import java.util.List;
import java.util.Map;

import javax.enterprise.deploy.model.DDBean;

import com.holyshit.Dao.DocumentDao;
import com.holyshit.Dao.impl.DocumentDaoImpl;
import com.holyshit.domain.Document;

/**
 * 和文档有关的service
 * @author yuan
 *
 */
public interface DocumentService {
	/**
	 * 列出用户相关项目的所有文档，时间排序
	 * @param id   用户id
	 * @param cur  当前页
	 * @param pageSize   页面大小
	 * @return
	 */
	Map<String, Object> findDocumentWithUserById(String id,int cur,int pageSize);
	
	/**
	 * 查询文件信息
	 * @param id
	 * @return
	 */
	Document findDocumentById(String id);
}
