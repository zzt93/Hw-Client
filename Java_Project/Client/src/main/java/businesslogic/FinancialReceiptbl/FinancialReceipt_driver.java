package businesslogic.FinancialReceiptbl;

import vo.*;
import businesslogic.FinancialReceiptbl.FinancialReceipt_stub;

public class FinancialReceipt_driver {
	public void driver(FinancialReceipt_stub finReceipt){
		try {
			finReceipt.makeCash(new CashReceiptVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			finReceipt.makePayment(new PayReceiptVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			finReceipt.makeReceive(new RecReceiptVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
