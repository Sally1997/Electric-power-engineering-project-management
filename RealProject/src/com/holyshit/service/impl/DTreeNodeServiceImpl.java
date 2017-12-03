package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.Dao.impl.DTreeDaoImpl;
import com.holyshit.domain.Project;
<<<<<<< HEAD
import com.holyshit.domain.PsPlan;
=======
import com.holyshit.domain.PSPlan;
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
import com.holyshit.domain.StageTask;
import com.holyshit.service.DTreeNodeService;

public class DTreeNodeServiceImpl implements DTreeNodeService {
	DTreeDao dtd = new DTreeDaoImpl();
	@Override
<<<<<<< HEAD
	public List<PsPlan> GetSNByPn(String pn) throws SQLException {
=======
	public List<PSPlan> GetSNByPn(String pn) throws SQLException {
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
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
<<<<<<< HEAD
	public PsPlan GetStageInfo(String sn) throws SQLException {
=======
	public PSPlan GetStageInfo(String sn) throws SQLException {
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
		return dtd.selectStageInfo(sn);
	}

	@Override
	public StageTask GetTaskInfo(String tn) throws SQLException {
		return dtd.selectTaskInfo(tn);
	}

}
