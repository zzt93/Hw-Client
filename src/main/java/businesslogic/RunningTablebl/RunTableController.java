package businesslogic.RunningTablebl;

import java.util.ArrayList;

import po.ReceiptPO;
import vo.GoodsRecordVO;
import vo.ProfitVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;
import vo.TimeConditionVO;
import businesslogicservice.RunningTableblservice.RunningTableblservice;

public class RunTableController implements RunningTableblservice {
	CheckReceipt checkReceipt=new CheckReceipt();
	SaleRecord record=new SaleRecord();
	CheckProfit profit=new CheckProfit();
	@Override
	public GoodsRecordVO[] getSaleTable(SaleConditionVO vo) throws Exception {
		System.out.println("进入controller");
		return record.getSaleTable(vo);
	}

	@Override
	public ReceiptPO[] getReceipt(ReceiptConditionVO vo) throws Exception {
		ArrayList<ReceiptPO> list=checkReceipt.getReceipt(vo);
		ReceiptPO[] receipt=new ReceiptPO[list.size()];
		for(int i=0;i<list.size();i++){
			receipt[i]=list.get(i);
		}
		return receipt;
	}

	@Override
	public ProfitVO getProfit(TimeConditionVO vo) throws Exception {
		
		return profit.getProfit(vo);
	}

	@Override
	public void CreditNote(ReceiptPO po) throws Exception {
		checkReceipt.CreditNote(po);
	}

}
