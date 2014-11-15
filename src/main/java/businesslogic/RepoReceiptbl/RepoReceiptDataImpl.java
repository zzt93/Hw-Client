package businesslogic.RepoReceiptbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.RepoFilterPO;
import po.RepoReceiptPO;
import po.ResultMessage;

public class RepoReceiptDataImpl implements RepoReceiptDataService {

	public ResultMessage<ArrayList<RepoReceiptPO>> getRepoReceipts()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> initialize(ArrayList<RepoReceiptPO> receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> insert(RepoReceiptPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> delete(RepoReceiptPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> update(RepoReceiptPO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<RepoReceiptPO> efind(String info)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<ArrayList<RepoReceiptPO>> ifind(RepoFilterPO filter)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
