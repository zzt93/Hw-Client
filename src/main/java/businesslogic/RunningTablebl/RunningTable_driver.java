package businesslogic.RunningTablebl;

import po.ReceiptPO;
import vo.*;

public class RunningTable_driver {
	public void driver(RunningTable_stub table){
		try {
			table.CreditNote(new ReceiptPO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ProfitVO profit=table.getProfit(new TimeConditionVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			GoodsRecordVO[] record=table.getSaleTable(new SaleConditionVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ReceiptPO[] receipt=table.getReceipt(new ReceiptConditionVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
