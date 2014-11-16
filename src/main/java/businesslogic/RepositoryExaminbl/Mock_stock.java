package businesslogic.RepositoryExaminbl;

import java.util.Vector;

import po.StockReceiptPO;
import businesslogicservice.Stockblservice.StockUtility;
import vo.ReceiptConditionVO;

public class Mock_stock implements StockUtility{
	
	Vector<StockReceiptPO> receiptPOs = new Vector<StockReceiptPO>(null);

	public void makeReceipt(StockReceiptPO receiptPO) throws Exception {
		
	}

	public Vector<StockReceiptPO> queryReceipt(ReceiptConditionVO filter)
			throws Exception {
		
		return receiptPOs;
	}

}
