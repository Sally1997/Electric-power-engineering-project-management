package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Qualification;

public interface QualificationDao {
	List<Qualification> findAllQualifications(String staffno) throws SQLException;
	void AddAQualification(String staffno,String qua) throws SQLException;
}
