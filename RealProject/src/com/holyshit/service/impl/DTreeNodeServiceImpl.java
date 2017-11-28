package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.Dao.impl.DTreeDaoImpl;
import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.StageTask;
import com.holyshit.service.DTreeNodeService;

public class DTreeNodeServiceImpl implements DTreeNodeService {
	DTreeDao dtd = new DTreeDaoImpl();
	@Override
	public List<ProjectStage> GetSNByPn(String pn) throws SQLException {
		return dtd.selectAllSNByPn(pn);
	}

	@Override
	public List<StageTask> GetTNByPn(String pn) throws SQLException {
		return dtd.selectAllTNByPn(pn);
	}

	@Override
	public Project GetProjectInfo(String pn) throws SQLException {
		return dtd.selectProjectInfo(pn);
	}

}
