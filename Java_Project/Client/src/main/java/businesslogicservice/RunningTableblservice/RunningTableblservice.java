package businesslogicservice.RunningTableblservice;

import po.*;
import vo.*;

public interface RunningTableblservice {
	public GoodsRecordVO[] getSaleTable (SaleConditionVO  vo) ;
	public ReceiptPO[] getReceipt(ReceiptConditionVO vo);
	public ProfitVO getProfit(TimeConditionVO vo);
	public void CreditNote(ReceiptVO vo);
}
