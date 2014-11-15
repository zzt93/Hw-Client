package businesslogic.FinancialReceiptbl;

import po.*;

public class FinReceipt {

	public ResultMessage makePayMent(PayReceiptPO po){
		//生成付款单
		return new ResultMessage(null,null);
	}
	public ResultMessage makeReceive(RecReceiptPO po){
		//生成收款单
		return new ResultMessage(null,null);
	}
	public ResultMessage makeCash(CashReceiptPO po){
		//生成现金费用单
		return new ResultMessage(null,null);
	}
}
