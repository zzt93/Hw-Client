package businesslogic.FinancialReceiptbl;

import java.rmi.RemoteException;

import vo.*;
import po.*;

public class FinancialReceiptdata_driver {
	ResultMessage result;
	public void driver(FinancialReceiptdata_stub finReceiptdata){
		try {
			result=finReceiptdata.addCash(new CashReceiptPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=finReceiptdata.addPay(new PayReceiptPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=finReceiptdata.addRec(new RecReceiptPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=finReceiptdata.update(new ReceiptPO[2]);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
