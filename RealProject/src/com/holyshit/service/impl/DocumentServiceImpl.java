package com.holyshit.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.inject.New;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.Dao.DocumentDao;
import com.holyshit.Dao.impl.DocumentDaoImpl;
import com.holyshit.domain.Document;
import com.holyshit.domain.DocumentInfo;
import com.holyshit.service.DocumentService;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.web.servlet.NewProjectServlet;

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
		documents.put("totalNum", total);
		documents.put("currentPage", cur);
		documents.put("pageSize", pageSize);
		documents.put("pageNum", total%pageSize==0?total/pageSize:total/pageSize+1);
		return documents;
	}

	@Override
	public Document findDocumentById(String id) {
		// TODO Auto-generated method stub
		Document res=null;
		DocumentDao dd=new DocumentDaoImpl();
		try {
			res=dd.getDocumentById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return res;
	}

	@Override
	public Map<String, Object> findDocumentByContidtion(String ptype,String dtype,
			String datefrom, String dateto, String keywords, String ftype,int cur,int pageSize) {
		// TODO Auto-generated method stub
		DocumentDao dd=new DocumentDaoImpl();
		long totalSize=0;
		List<DocumentInfo> docs=null;
		try {
			docs = dd.selectDocumentByCondition(ptype,dtype, datefrom, dateto, keywords, ftype, cur, pageSize);
			totalSize=dd.totalNumWithCondition(ptype,dtype, datefrom, dateto, keywords, ftype);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		JSONArray documents=new JSONArray();
		//封装jsonarray
		for(DocumentInfo di:docs){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("dno", di.getDno());
			jsonObject.put("dtitle", di.getDtitle());
			jsonObject.put("uploadtime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(di.getUploadtime()));
			jsonObject.put("dloadtimes",di.getDloadtimes());
			jsonObject.put("ftype",di.getFtype());
			jsonObject.put("dtype",di.getDtype());
			jsonObject.put("uloadpno",di.getUloadpno());
			jsonObject.put("pname",di.getPname());
			jsonObject.put("fsize", di.getFsize());
			documents.add(jsonObject);
		}
		Map<String, Object> resMap=new HashMap<String, Object>();
		
		resMap.put("docs", documents.toString());
		resMap.put("totalNum", totalSize);
		resMap.put("currentPage", cur);
		resMap.put("pageSize", pageSize);
		resMap.put("pageNum", totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1);
		return resMap;
	}

	@Override
	public boolean uploadDocument(String dno,String dtitle,String dpath, String uloadpno, String pno,
			String ftype, String dtype,int fsize) {
		// TODO Auto-generated method stub
		DocumentDao dd=new DocumentDaoImpl();
		int res=0;
		//类型转换
		try {
			res=dd.addDocument(dno, uloadpno, pno, dtitle, dpath, ftype, dtype, fsize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		if(res==1)
			return true;
		return false;
	}

	@Override
	public int addReadingNumberInDocument(String id){
		// TODO Auto-generated method stub
		DocumentDao dd=new DocumentDaoImpl();
		try {
			return dd.addReadingNumber(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
