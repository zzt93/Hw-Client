package RepoExaminDataService;

import java.util.ArrayList;

import PO.RepoFilterPO;
import PO.InOutRepoPO;

public interface RepoExaminDataService {
	ArrayList<InOutRepoPO> getRepoReceipt();
	boolean initialize(ArrayList<InOutRepoPO> receipts);
	
	boolean insert(InOutRepoPO receipt);
	boolean delete(InOutRepoPO receipt);
	boolean update(InOutRepoPO receipt);
	
	InOutRepoPO efind(String info);
	ArrayList<InOutRepoPO> ifind(RepoFilterPO filterPO);
}
