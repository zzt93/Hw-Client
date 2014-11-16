package businesslogic.FinancialReceiptbl;

import po.CashPO;
import po.ResultMessage;

public class MockFinReceipt extends FinReceipt{
	public ResultMessage makeCash(CashPO po){
		return new ResultMessage("测试异常抛出",null);
	}
}
