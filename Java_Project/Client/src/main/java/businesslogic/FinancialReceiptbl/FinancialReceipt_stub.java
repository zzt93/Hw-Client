package businesslogic.FinancialReceiptbl;

import po.ResultMessage;
import vo.CashReceiptVO;
import vo.PayReceiptVO;
import vo.RecReceiptVO;
import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;

public class FinancialReceipt_stub implements FinancialReceiptblservice {
	ResultMessage right=new ResultMessage(null,null);
	ResultMessage wrong=new ResultMessage("出现了问题",null);
	public void makePayment(PayReceiptVO vo) throws Exception {
		wrong.throwIfFailed();
		System.out.println("创建付款单成功");
	}

	public void makeReceive(RecReceiptVO vo) throws Exception {
		right.throwIfFailed();
		System.out.println("创建收款单成功");
	}

	public void makeCash(CashReceiptVO vo) throws Exception {
		right.throwIfFailed();
		System.out.println("创建现金费用单成功");
	}

}
