package businesslogic.FinancialReceiptbl;

import po.CashPO;
import po.PayPO;
import po.RecPO;
import po.ResultMessage;

public class FinReceipt {

	public ResultMessage makePayMent(PayPO po){
		//生成付款单
		return new ResultMessage(null,null);
	}
	public ResultMessage makeReceive(RecPO po){
		//生成收款单
		return new ResultMessage(null,null);
	}
	public ResultMessage makeCash(CashPO po){
		//生成现金费用单
		return new ResultMessage(null,null);
	}
}
