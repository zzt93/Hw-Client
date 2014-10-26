package businesslogic.RepositoryExaminbl;

import java.util.ArrayList;

import po.InOutRepoPO;
import po.StockReceiptPO;
import businesslogic.Stockbl.StockUtility;
import businesslogicservice.RepositoryExaminblservice.RepoExaminBLservice;
import businesslogicservice.Stockblservice.StockUtilityImpl;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	

	public ArrayList<InOutRepoPO> countInOut() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<InOutRepoPO> result = new ArrayList<InOutRepoPO>(null);
		StockUtilityImpl stockReceipt = new StockUtility();
		stockReceipt.queryReceipt(null);
		
		
		return result;
	}

}
