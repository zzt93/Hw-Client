package businesslogic.RunningTablebl;

import po.ReceiptPO;
import po.ResultMessage;
import vo.GoodsRecordVO;
import vo.ProfitVO;
import vo.ReceiptConditionVO;
import vo.ReceiptVO;
import vo.SaleConditionVO;
import vo.TimeConditionVO;
import businesslogicservice.RunningTableblservice.RunningTableblservice;

public class RunningTable_stub implements RunningTableblservice {
	ResultMessage right=new ResultMessage(null,null);
	ResultMessage wrong=new ResultMessage("出现了问题",null);
	
	public GoodsRecordVO[] getSaleTable(SaleConditionVO vo) throws Exception {
		right.throwIfFailed();
		GoodsRecordVO[] record=new GoodsRecordVO[2];
		record[0]=new GoodsRecordVO("商品1",300);
		record[1]=new GoodsRecordVO("商品2",50);
		return record;
	}

	
	public ReceiptVO[] getReceipt(ReceiptConditionVO vo) throws Exception {
		right.throwIfFailed();
		return new ReceiptVO[5];
	}


	public ProfitVO getProfit(TimeConditionVO vo) throws Exception {
		right.throwIfFailed();
		return new ProfitVO(3000,2000);
	}


	public void CreditNote(ReceiptVO vo) throws Exception {
		wrong.throwIfFailed();
		System.out.println("创建成功");
	}

}
