package businesslogic.RepositoryExaminbl;

import java.util.ArrayList;

import po.InOutRepoPO;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogicservice.RepositoryExaminblservice.RepoExaminBLservice;
import businesslogicservice.Stockblservice.StockUtility;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	

	public ArrayList<InOutRepoPO> countInOut() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<InOutRepoPO> result = new ArrayList<InOutRepoPO>(null);
		StockUtility stockReceipt = new StockUtilityImpl();
		stockReceipt.queryReceipt(null);
		
		
		return result;
	}

}
