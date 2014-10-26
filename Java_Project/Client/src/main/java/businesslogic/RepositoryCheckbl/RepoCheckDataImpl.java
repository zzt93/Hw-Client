package businesslogic.RepositoryCheckbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.RepositoryCheckdataservice.RepoCheckDataService;
import po.RepoFilterPO;
import po.RepoPO;
import po.ResultMessage;

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

	public ResultMessage<ArrayList<RepoPO>> ifind(RepoFilterPO filterPO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
