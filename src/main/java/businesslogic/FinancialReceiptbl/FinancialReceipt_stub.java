package businesslogic.FinancialReceiptbl;

import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;
import po.ResultMessage;
import vo.CashVO;
import vo.PayVO;
import vo.RecVO;

public class FinancialReceipt_stub implements FinancialReceiptblservice {
	ResultMessage right=new ResultMessage(null,null);
	ResultMessage wrong=new ResultMessage("出现了问题",null);
	public void makePayment(PayVO vo) throws Exception {
		wrong.throwIfFailed();
		System.out.println("创建付款单成功");
	}

	public void makeReceive(RecVO vo) throws Exception {
		right.throwIfFailed();
		System.out.println("创建收款单成功");
	}

	public void makeCash(CashVO vo) throws Exception {
		right.throwIfFailed();
		System.out.println("创建现金费用单成功");
	}

}
