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


	Exporter expoter;
	RepoCheckDataService repoCheckDataService;


	static String check = "repo check data service";
	public ArrayList<RepoPO> getCheckRes() throws RemoteException {
		return repoCheckDataService.getRepo().getObj();
	}

	public RepoCheckBLImpl() throws RemoteException, NullPointerException, NotBoundException {

		expoter = new Exporter();
		repoCheckDataService = (RepoCheckDataService) RMIUtility.getImpl(check);

	}

	public RepoPO checkAndSum() throws Exception {
		GL_repo_BLservice gl_repo_BLservice = new GL_manager_repo_Impl();
		GoodsListPO temp = gl_repo_BLservice.getGoodsList();
		RepoPO repoPO = new RepoPO(temp);
		repoCheckDataService.insert(repoPO);
		return repoPO;

	}

	@Override
	public boolean export(int which, String destFileName) throws Exception {
		if ((getCheckRes() == null) || getCheckRes().isEmpty() || (which > (getCheckRes().size() - 1))) {
			return false;
		}
		expoter.export_excel(getCheckRes().get(which), destFileName);
		return true;
	}



	public RepoPO get_aver_in() throws RemoteException {
		if (getCheckRes().size() == 0){
			return null;
		}
		return getCheckRes().get(getCheckRes().size() - 1);
	}
}
