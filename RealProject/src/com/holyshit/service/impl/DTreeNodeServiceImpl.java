package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.Dao.impl.DTreeDaoImpl;
import com.holyshit.domain.Project;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.service.DTreeNodeService;

public class DTreeNodeServiceImpl implements DTreeNodeService {
	DTreeDao dtd = new DTreeDaoImpl();
	@Override
	public List<PSPlan> GetSNByPn(String pn) throws SQLException {
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

	@Override
	public PSPlan GetStageInfo(String sn) throws SQLException {
		return dtd.selectStageInfo(sn);
	}

	@Override
	public StageTask GetTaskInfo(String tn) throws SQLException {
		return dtd.selectTaskInfo(tn);
	}

}
