package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holyshit.Dao.DocumentDao;
import com.holyshit.Dao.impl.DocumentDaoImpl;
import com.holyshit.domain.Document;
import com.holyshit.service.DocumentService;
import com.holyshit.utils.ConnectionManager;

public class DocumentServiceImpl implements DocumentService {

	@Override
	public Map<String, Object> findDocumentWithUserById(String id, int cur,
			int pageSize) {
		// TODO Auto-generated method stub
		List<Document> list=null;
		long total=0;
		DocumentDao dd=new DocumentDaoImpl();
		try {
			list=dd.selectAllDocumentByUserId(id, cur, pageSize);
			total=dd.totalSizeWithId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		
		//将分页结果封装成hashmap
		Map<String, Object> documents=new HashMap<String, Object>();
		documents.put("docs", list);
		documents.put("total", total);
		documents.put("currentPage", cur);
		documents.put("pageSize", pageSize);
		return documents;
	}

	@Override
	public Document findDocumentById(String id) {
		// TODO Auto-generated method stub
		DocumentDao dd=new DocumentDaoImpl();
		try {
			return dd.getDocumentById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
