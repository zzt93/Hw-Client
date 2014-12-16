package businesslogic.RepositoryCheckbl;

import dataservice.RepositoryCheckdataservice.RepoCheckDataService;
import po.RepoFilterPO;
import po.RepoPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RepoCheckDataImpl implements RepoCheckDataService {

	public ResultMessage<ArrayList<RepoPO>> getRepo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> initialize(ArrayList<RepoPO> repoPOs)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> insert(RepoPO repoPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> delete(RepoPO repoPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> update(RepoPO repoPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<RepoPO> efind(String info) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage<Double> getAver_in(String id) throws RemoteException {
		return null;
	}

	public ResultMessage<ArrayList<RepoPO>> ifind(RepoFilterPO filterPO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
