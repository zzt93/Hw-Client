package businesslogic.RepositoryExaminbl;

import java.util.ArrayList;
import java.util.Vector;

import po.InOutRepoPO;
import po.StockReceiptPO;
import vo.ReceiptConditionVO;
import businesslogicservice.RepositoryExaminblservice.RepoExaminBLservice;
import businesslogicservice.Stockblservice.StockUtility;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	

	public ArrayList<InOutRepoPO> countInOut() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<InOutRepoPO> result = new ArrayList<InOutRepoPO>(null);
//		StockUtility stockReceipt = new StockUtilityImpl();
		StockUtility stockReceipt = new Mock_stock();
		
		ReceiptConditionVO conditionVO = new ReceiptConditionVO();
		
		Vector<StockReceiptPO> stockReceiptPOs = stockReceipt.queryReceipt(conditionVO);
		
		
		return result;
	}

}
