package dataservice.RepositoryExamindataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.InOutRepoPO;
import po.ResultMessage;

public interface RepoExaminDataService {
	ResultMessage<ArrayList<InOutRepoPO>> getRepoReceipt() throws RemoteException;
	ResultMessage<Boolean> initialize(ArrayList<InOutRepoPO> receipts) throws RemoteException;
	
	ResultMessage<Boolean> insert(InOutRepoPO receipt) throws RemoteException;
	ResultMessage<Boolean> delete(InOutRepoPO receipt) throws RemoteException;
	ResultMessage<Boolean> update(InOutRepoPO receipt) throws RemoteException;
	
	ResultMessage<InOutRepoPO> efind(String info) throws RemoteException;
	ResultMessage<ArrayList<InOutRepoPO>> ifind(RepoFilterPO filterPO) throws RemoteException;
}
