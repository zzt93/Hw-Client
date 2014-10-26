package presentation.RunningTableui;

import vo.*;
import businesslogic.RunningTablebl.RunningTable_stub;

public class RunningTable_driver {
	public void driver(RunningTable_stub table){
		try {
			table.CreditNote(new ReceiptVO());
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
			ReceiptVO[] receipt=table.getReceipt(new ReceiptConditionVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
