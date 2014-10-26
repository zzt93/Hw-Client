package dataservice.RepositoryExamindataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InOutRepoPO;
import po.RepoFilterPO;
import po.ResultMessage;

public class RepoExamDataImpl implements RepoExaminDataService {

	public ResultMessage<ArrayList<InOutRepoPO>> getRepoReceipt()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> initialize(ArrayList<InOutRepoPO> receipts)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> insert(InOutRepoPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> delete(InOutRepoPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> update(InOutRepoPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<InOutRepoPO> efind(String info) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<ArrayList<InOutRepoPO>> ifind(RepoFilterPO filterPO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
