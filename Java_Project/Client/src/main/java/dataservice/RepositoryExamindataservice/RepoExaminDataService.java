package dataservice.RepositoryExamindataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RepoFilterPO;
import po.InOutRepoPO;

public interface RepoExaminDataService {
	ArrayList<InOutRepoPO> getRepoReceipt() throws RemoteException;
	boolean initialize(ArrayList<InOutRepoPO> receipts) throws RemoteException;
	
	boolean insert(InOutRepoPO receipt) throws RemoteException;
	boolean delete(InOutRepoPO receipt) throws RemoteException;
	boolean update(InOutRepoPO receipt) throws RemoteException;
	
	InOutRepoPO efind(String info) throws RemoteException;
	ArrayList<InOutRepoPO> ifind(RepoFilterPO filterPO) throws RemoteException;
}
