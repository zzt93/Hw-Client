package dataservice.RepositoryExamindataservice;

import po.RepoFilterPO;
import po.ResultMessage;
import vo.InOutRepoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RepoExaminDataService {
	ResultMessage<ArrayList<InOutRepoVO>> getRepoReceipt() throws RemoteException;
	ResultMessage<Boolean> initialize(ArrayList<InOutRepoVO> receipts) throws RemoteException;
	
	ResultMessage<Boolean> insert(InOutRepoVO receipt) throws RemoteException;
	ResultMessage<Boolean> delete(InOutRepoVO receipt) throws RemoteException;
	ResultMessage<Boolean> update(InOutRepoVO receipt) throws RemoteException;
	
	ResultMessage<InOutRepoVO> efind(String info) throws RemoteException;
	ResultMessage<ArrayList<InOutRepoVO>> ifind(RepoFilterPO filterPO) throws RemoteException;
}
