package businesslogic.RunningTablebl;

import vo.GoodsRecordVO;
import vo.ProfitVO;
import vo.ReceiptConditionVO;
import vo.ReceiptVO;
import vo.SaleConditionVO;
import vo.TimeConditionVO;
import businesslogicservice.RunningTableblservice.RunningTableblservice;

public class RunTableController implements RunningTableblservice {

	@Override
	public GoodsRecordVO[] getSaleTable(SaleConditionVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptVO[] getReceipt(ReceiptConditionVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfitVO getProfit(TimeConditionVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreditNote(ReceiptVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

}
