package businesslogicservice.RunningTableblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;
import vo.*;

public interface RunningTableblservice {
	public GoodsRecordVO[] getSaleTable (SaleConditionVO  vo) throws Exception ;
	public ArrayList<ReceiptPO> getReceipt(ReceiptConditionVO vo)throws Exception;
	public ProfitVO getProfit(ReceiptConditionVO vo)throws Exception;
	public void CreditNote(ReceiptPO po)throws Exception;
	public String[] getClient() throws Exception;
	public String[] getOperator() throws Exception;
	public String[] getGoodsList() throws RemoteException;
}
