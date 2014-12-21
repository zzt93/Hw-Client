package businesslogicservice.FinancialReceiptblservice;

import java.util.ArrayList;

import po.BkTransPO;
import po.CashPO;
import po.ItemPO;
import po.PayPO;
import po.RecPO;
import po.ReceiptPO;
import vo.CashVO;
import vo.PayVO;
import vo.RecVO;
import vo.ReceiptConditionVO;

public interface FinancialReceiptblservice {
	public void makePayment(PayVO vo) throws Exception;
	public void makeReceive(RecVO vo) throws Exception;
	public void makeCash(CashVO vo) throws Exception;
	public void clearBank();
	public void clearItem();
	public double addBank(BkTransPO po);
	public double addItem(ItemPO po);
	public double deleteBank(int i);
	public double deleteItem(int i);
	public String[] getBank() throws Exception;
	public String[] getClient() throws Exception;
	public String getOperator() throws Exception;
	public ArrayList<ReceiptPO> getReceipt()throws Exception;
	public ArrayList<ReceiptPO> getReceipt(ReceiptConditionVO vo)throws Exception;
	public void creditCash(CashPO po)throws Exception;
	public void creditPay(PayPO po)throws Exception;
	public void creditRec(RecPO po)throws Exception;
	public void update(ReceiptPO[] po)throws Exception;
	public void update(ReceiptPO po)throws Exception;
}
