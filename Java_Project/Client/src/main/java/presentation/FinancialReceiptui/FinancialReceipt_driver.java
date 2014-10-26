package presentation.FinancialReceiptui;

import vo.*;
import businesslogic.FinancialReceiptbl.FinancialReceipt_stub;

public class FinancialReceipt_driver {
	public void driver(FinancialReceipt_stub finReceipt){
		try {
			finReceipt.makeCash(new CashVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			finReceipt.makePayment(new PayVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			finReceipt.makeReceive(new RecVO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
