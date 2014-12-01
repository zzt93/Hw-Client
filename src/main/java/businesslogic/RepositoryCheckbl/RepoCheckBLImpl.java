package businesslogic.RepositoryCheckbl;

import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;
import businesslogicservice.RepositoryCheckblservice.RepoCheckBLservice;
import dataservice.RepositoryCheckdataservice.RepoCheckDataService;
import po.GoodsListPO;
import po.RepoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RepoCheckBLImpl implements RepoCheckBLservice {

	GL_repo_BLservice gl_repo_BLservice;
	Exporter expoter;
	RepoCheckDataService repoCheckDataService;
	ArrayList<RepoPO> checkRes;

	public ArrayList<RepoPO> getCheckRes() {
		return checkRes;
	}

	public RepoCheckBLImpl() throws RemoteException, NullPointerException {
		this.gl_repo_BLservice = new GL_manager_repo_Impl();
		expoter = new Exporter();
		repoCheckDataService = new RepoCheckDataImpl();
		checkRes = repoCheckDataService.getRepo().getObj();
	}

	public RepoPO checkAndSum() throws Exception {
		GoodsListPO temp = gl_repo_BLservice.sum();

		checkRes.add(new RepoPO(temp));
		return checkRes.get(checkRes.size());

	}

	@Override
	public boolean export(int which) throws Exception {
		if (checkRes.isEmpty() || checkRes == null || which < checkRes.size() - 1) {
			return false;
		}
		expoter.export_excel(checkRes.get(which));
		return true;
	}

	public void refresh() throws Exception {
		checkRes = new RepoCheckDataImpl().getRepo().getObj();
	}

	public void synchronize() throws Exception {
		repoCheckDataService.initialize(checkRes);
	}
}
