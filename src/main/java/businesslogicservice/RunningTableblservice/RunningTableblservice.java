package businesslogicservice.RunningTableblservice;

import po.*;
import vo.*;

public interface RunningTableblservice {
	public GoodsRecordVO[] getSaleTable (SaleConditionVO  vo) throws Exception ;
	public ReceiptPO[] getReceipt(ReceiptConditionVO vo)throws Exception;
	public ProfitVO getProfit(TimeConditionVO vo)throws Exception;
	public void CreditNote(ReceiptPO po)throws Exception;
}
