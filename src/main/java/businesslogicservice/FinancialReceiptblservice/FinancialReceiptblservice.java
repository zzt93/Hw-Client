package businesslogicservice.FinancialReceiptblservice;

import vo.CashVO;
import vo.PayVO;
import vo.RecVO;

public interface FinancialReceiptblservice {
	public void makePayment(PayVO vo) throws Exception;
	public void makeReceive(RecVO vo) throws Exception;
	public void makeCash(CashVO vo) throws Exception;
}
