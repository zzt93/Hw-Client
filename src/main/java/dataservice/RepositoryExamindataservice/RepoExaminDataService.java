package dataservice.RepositoryExamindataservice;

import po.RepoFilterPO;
import po.ResultMessage;
import vo.InOutRepoVO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RepoExaminDataService extends Remote {
	ResultMessage<ArrayList<InOutRepoVO>> getInOutRepo() throws RemoteException;
	
	ResultMessage<Boolean> insert(InOutRepoVO receipt) throws RemoteException;
	ResultMessage<Boolean> update(InOutRepoVO receipt) throws RemoteException;
	
	ResultMessage<InOutRepoVO> efind(String info) throws RemoteException;
}
