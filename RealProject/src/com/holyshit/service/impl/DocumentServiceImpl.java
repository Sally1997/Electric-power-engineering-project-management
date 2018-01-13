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
	public List<Document> findallneededauditfile(String me){
		DocumentDao dd=new DocumentDaoImpl();
		List<Document> dL=null;
		try {
			dL =  dd.findallneededauditfile(me);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return dL;
	}
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
			String datefrom, String dateto, String keywords, String ftype,int cur,int pageSize,String staffno) {
		// TODO Auto-generated method stub
		DocumentDao dd=new DocumentDaoImpl();
		long totalSize=0;
		List<DocumentInfo> docs=null;
		try {
			docs = dd.selectDocumentByCondition(ptype,dtype, datefrom, dateto, keywords, ftype, cur, pageSize,staffno);
			totalSize=dd.totalNumWithCondition(ptype,dtype, datefrom, dateto, keywords, ftype,staffno);
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
	
	@Override
	public boolean addDocument(Document doc) {
		DocumentDao dd=new DocumentDaoImpl();
		int res=0;
		//类型转换
		try {
			res=dd.insertDocument(doc);
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
	public void auditfile(String type,String dno){
		DocumentDao dd=new DocumentDaoImpl();
		System.out.println("typeService:"+type+"00000");
		System.out.println("typelength:"+type.length());
		if(type!="")//审核通过
		{
			try {
				System.out.println("pass");
				dd.auditfilepass(dno);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnectionManager.closeConnection();
			}
		}
		else 
		{
			try {
				System.out.println("fail");
				dd.auditfilefail(dno);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnectionManager.closeConnection();
			}
		}
	}
	@Override
	public String getPDocNo(String pno) {
		// TODO Auto-generated method stub
		DocumentDao dd=new DocumentDaoImpl();
		String dno = null;
		try {
			dno = (String) dd.selectPDocNo(pno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dno;
	}
	@Override
	public void changeDocAuditRes(String agree, String dno) {
		// TODO Auto-generated method stub
		DocumentDao dd=new DocumentDaoImpl();
		try {
			dd.updateDocAuditState(agree, dno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

}
