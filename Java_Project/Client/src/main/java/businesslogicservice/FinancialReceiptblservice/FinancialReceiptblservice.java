package businesslogicservice.FinancialReceiptblservice;

import vo.CashReceiptVO;
import vo.PayReceiptVO;
import vo.RecReceiptVO;

public interface FinancialReceiptblservice {
	public void makePayment(PayReceiptVO vo) throws Exception;
	public void makeReceive(RecReceiptVO vo) throws Exception;
	public void makeCash(CashReceiptVO vo) throws Exception;
}
