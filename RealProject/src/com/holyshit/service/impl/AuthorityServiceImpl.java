package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.Dao.InformDao;
import com.holyshit.Dao.impl.AuthorityDaoImpl;
import com.holyshit.Dao.impl.InformDaoImpl;
import com.holyshit.domain.Authority;
import com.holyshit.domain.Inform;
import com.holyshit.service.AuthorityService;
import com.holyshit.utils.ConnectionManager;

public class AuthorityServiceImpl implements AuthorityService {

	@Override
	public List<Authority> findAllAuthority() {
		// TODO Auto-generated method stub
		AuthorityDao ad=new AuthorityDaoImpl();
		List<Authority> list=null;
		try {
			list=ad.selectAllPermission();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Authority> findAuthorityById(String staffno) {
		// TODO Auto-generated method stub
		AuthorityDao ad=new AuthorityDaoImpl();
		List<Authority> list=null;
		try {
			list=ad.selectPermissionById(staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public boolean setAuthority(String staffno, String para) {
		// TODO Auto-generated method stub
		//对于数据进行拆封
		String[] changes = para.split(":");
		AuthorityDao ad=new AuthorityDaoImpl();
		InformDao inform=new InformDaoImpl();
		Inform data=new Inform();
		boolean flag=false;
		data.setBusno(staffno);
		data.setSrcpno("root");
		data.setDstpno(staffno);
		data.setMtype("S4");
		data.setHasread("0");
		int res1=0,res2=0,res3=0;
		try {
			ConnectionManager.startTransaction();
			res3=inform.insertInform(data, 1);
			for(int i=0;i<changes.length;i++){
				//重置标记
				res1=0;
				res2=0;
				String[] hehe = changes[i].split("-");
				String perno=hehe[0];
				String operateCode=hehe[1];
				//分情况进行处理
				if(operateCode.equals("1")){
					//添加权限
					res1 = ad.addAuthorityById(staffno, perno);
					if(res1==0){
						throw new SQLException();
					}
				}else if(operateCode.equals("0")){
					//取消权限
					res2 = ad.deleteAuthorityById(staffno, perno);
					if(res2==0){
						throw new SQLException();
					}
				}
				if(res3==0){
					throw new SQLException();
				}
				
			}
			ConnectionManager.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ConnectionManager.rollback();
			flag=true;
			e.printStackTrace();
			return false;
		}finally{
			ConnectionManager.closeConnection();
		}
		return !flag;
	}

}
