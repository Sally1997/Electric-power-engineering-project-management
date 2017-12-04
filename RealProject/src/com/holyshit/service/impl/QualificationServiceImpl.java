package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.QualificationDao;
import com.holyshit.Dao.impl.QualificationDaoImpl;
import com.holyshit.domain.Qualification;
import com.holyshit.service.QualificationService;

public class QualificationServiceImpl implements QualificationService {
	private QualificationDao QualificationDao = new QualificationDaoImpl();
	public List<Qualification> findAllQualifications(String staffno){
		try {
			return QualificationDao.findAllQualifications(staffno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
