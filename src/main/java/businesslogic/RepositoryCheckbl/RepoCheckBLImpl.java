package businesslogic.RepositoryCheckbl;

import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;
import businesslogicservice.RepositoryCheckblservice.RepoCheckBLservice;
import dataservice.RepositoryCheckdataservice.RepoCheckDataService;
import po.GoodsListPO;
import po.RepoPO;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RepoCheckBLImpl implements RepoCheckBLservice {

	GL_repo_BLservice gl_repo_BLservice;
	Exporter expoter;
	RepoCheckDataService repoCheckDataService;
	ArrayList<RepoPO> checkRes;

	static String check = "repo check data service";
	public ArrayList<RepoPO> getCheckRes() {
		return checkRes;
	}

	public RepoCheckBLImpl() throws RemoteException, NullPointerException, NotBoundException {
		this.gl_repo_BLservice = new GL_manager_repo_Impl();
		expoter = new Exporter();
		repoCheckDataService = (RepoCheckDataService) RMIUtility.getImpl(check);
		checkRes = repoCheckDataService.getRepo().getObj();
	}

	public RepoPO checkAndSum() throws Exception {
		GoodsListPO temp = gl_repo_BLservice.sum();

		checkRes.add(new RepoPO(temp));
		return checkRes.get(checkRes.size());

	}

	@Override
	public boolean export(int which, String destFileName) throws Exception {
		if (checkRes == null || checkRes.isEmpty() || which < checkRes.size() - 1) {
			return false;
		}
		expoter.export_excel(checkRes.get(which), destFileName);
		return true;
	}

	public void refresh() throws Exception {
		checkRes = ((RepoCheckDataService) RMIUtility.getImpl(check)).getRepo().getObj();
	}

	public RepoPO get_aver_in(){
		if (checkRes.size() == 0){
			return null;
		}
		return checkRes.get(checkRes.size()-1);
	}
}
