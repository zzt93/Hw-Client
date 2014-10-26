package businesslogic.FinancialReceiptbl;

import java.rmi.RemoteException;

import dataservice.FinancialReceiptdataservice.FinancialReceiptdata_stub;
import vo.*;
import po.*;

public class FinancialReceiptdata_driver {
	ResultMessage result;
	public void driver(FinancialReceiptdata_stub finReceiptdata){
		try {
			result=finReceiptdata.addCash(new CashPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=finReceiptdata.addPay(new PayPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=finReceiptdata.addRec(new RecPO());
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
