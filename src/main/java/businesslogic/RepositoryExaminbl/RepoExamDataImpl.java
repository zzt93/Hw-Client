package businesslogic.RepositoryExaminbl;

import dataservice.RepositoryExamindataservice.RepoExaminDataService;
import po.RepoFilterPO;
import po.ResultMessage;
import vo.InOutRepoVO;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RepoExamDataImpl implements RepoExaminDataService {

	public ResultMessage<ArrayList<InOutRepoVO>> getRepoReceipt()
			throws RemoteException {
		System.out.println("in getRepoReceipt of repo examin data stub");
		return new ResultMessage<ArrayList<InOutRepoVO>>(null, new ArrayList<InOutRepoVO>());
	}



	public ResultMessage<Boolean> insert(InOutRepoVO receipt)
			throws RemoteException {
		System.out.println("in insert of repo examin data stub");
		return new ResultMessage<Boolean>(null, true);
	}



	public ResultMessage<Boolean> update(InOutRepoVO receipt)
			throws RemoteException {
		System.out.println("in insert of repo examin data stub");
		return new ResultMessage<Boolean>(null, true);
	}

	public ResultMessage<InOutRepoVO> efind(String info) throws RemoteException {
		System.out.println("in insert of repo check data stub");
		BigDecimal in = new BigDecimal(100);
		BigDecimal out = new BigDecimal(10);

		return new ResultMessage<InOutRepoVO>(null, new InOutRepoVO(in, out, 10, 10, "2014-12-4", "2014-12-14"));
	}



}
