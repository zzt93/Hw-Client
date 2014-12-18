package businesslogic.RepositoryCheckbl;

import dataservice.RepositoryCheckdataservice.RepoCheckDataService;
import po.GoodsListPO;
import po.RepoFilterPO;
import po.RepoPO;
import po.ResultMessage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RepoCheckDataImpl implements RepoCheckDataService {

	public ResultMessage<ArrayList<RepoPO>> getRepo() throws RemoteException {
		System.out.println("in getRepo of repo check data stub");
		return new ResultMessage<ArrayList<RepoPO>>(null, new ArrayList<RepoPO>());
	}



	public ResultMessage<Boolean> insert(RepoPO repoPO) throws RemoteException {
		System.out.println("in insert of repo check data stub");
		return new ResultMessage<Boolean>(null, true);
	}


	public ResultMessage<Boolean> update(RepoPO repoPO) throws RemoteException {
		System.out.println("in update of repo check data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<RepoPO> efind(String info) throws RemoteException, NotBoundException {
		System.out.println("in insert of repo receipt data stub");
		return new ResultMessage<RepoPO>(null, new RepoPO(new GoodsListPO()));
	}

	@Override
	public ResultMessage<Double> getAver_in(String id) throws RemoteException {
		System.out.println("in insert of repo receipt data stub");
		return new ResultMessage<Double>(null, 1.1);
	}



}
