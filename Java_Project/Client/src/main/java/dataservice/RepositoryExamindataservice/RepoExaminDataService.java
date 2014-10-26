package dataservice.RepositoryExamindataservice;

import java.util.ArrayList;

import po.RepoFilterPO;
import po.InOutRepoPO;

public interface RepoExaminDataService {
	ArrayList<InOutRepoPO> getRepoReceipt() throws Exception;
	boolean initialize(ArrayList<InOutRepoPO> receipts) throws Exception;
	
	boolean insert(InOutRepoPO receipt) throws Exception;
	boolean delete(InOutRepoPO receipt) throws Exception;
	boolean update(InOutRepoPO receipt) throws Exception;
	
	InOutRepoPO efind(String info) throws Exception;
	ArrayList<InOutRepoPO> ifind(RepoFilterPO filterPO) throws Exception;
}
