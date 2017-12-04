package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Qualification;

public interface QualificationDao {
	List<Qualification> findAllQualifications(String staffno) throws SQLException;
}
