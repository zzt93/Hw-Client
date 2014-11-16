package businesslogic.RunningTablebl;

import po.ReceiptPO;
import vo.GoodsRecordVO;
import vo.ProfitVO;
import vo.ReceiptConditionVO;
import vo.ReceiptVO;
import vo.SaleConditionVO;
import vo.TimeConditionVO;
import businesslogicservice.RunningTableblservice.RunningTableblservice;

public class RunTableController implements RunningTableblservice {
	CheckReceipt checkReceipt=new CheckReceipt();
	SaleRecord record=new SaleRecord();
	@Override
	public GoodsRecordVO[] getSaleTable(SaleConditionVO vo) throws Exception {
		return record.getSaleTable();
	}

	@Override
	public ReceiptVO[] getReceipt(ReceiptConditionVO vo) throws Exception {
		ReceiptPO[] list=checkReceipt.getReceipt(vo);
		//类型转换
		return null;
	}

	@Override
	public ProfitVO getProfit(TimeConditionVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreditNote(ReceiptVO vo) throws Exception {
		checkReceipt.CreditNote(vo);
	}

}
