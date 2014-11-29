package businesslogic.RepositoryExaminbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.RepositoryExamindataservice.RepoExaminDataService;
import po.RepoFilterPO;
import po.ResultMessage;
import vo.InOutRepoVO;

public class RepoExamDataImpl implements RepoExaminDataService {

	public ResultMessage<ArrayList<InOutRepoVO>> getRepoReceipt()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> initialize(ArrayList<InOutRepoVO> receipts)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> insert(InOutRepoVO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> delete(InOutRepoVO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<Boolean> update(InOutRepoVO receipt)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<InOutRepoVO> efind(String info) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage<ArrayList<InOutRepoVO>> ifind(RepoFilterPO filterPO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
